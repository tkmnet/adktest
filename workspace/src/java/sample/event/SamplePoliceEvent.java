package sample.event;

import adk.team.util.provider.VictimSelectorProvider;
import adk.team.util.provider.WorldProvider;
import comlib.event.information.MessagePoliceForceEvent;
import comlib.manager.MessageReflectHelper;
import comlib.message.information.MessagePoliceForce;
import rescuecore2.standard.entities.PoliceForce;

public class SamplePoliceEvent implements MessagePoliceForceEvent {

    private WorldProvider wp;
    private VictimSelectorProvider vsp;

    public SamplePoliceEvent(WorldProvider worldProvider, VictimSelectorProvider victimSelectorProvider) {
        this.wp = worldProvider;
        this.vsp = victimSelectorProvider;
    }

    @Override
    public void receivedRadio(MessagePoliceForce message) {
        PoliceForce policeForce = MessageReflectHelper.reflectedMessage(this.wp.getWorld(), message);
        this.vsp.getVictimSelector().add(policeForce);
    }

    @Override
    public void receivedVoice(MessagePoliceForce message) {
        this.receivedRadio(message);
    }
}
