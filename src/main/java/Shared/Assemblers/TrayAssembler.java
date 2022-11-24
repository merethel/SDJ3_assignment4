package Shared.Assemblers;

import Shared.Model.AnimalPart;
import Shared.Model.Tray;
import animals.AnimalPartMessage;
import animals.TrayMessage;

import java.util.ArrayList;

public class TrayAssembler {
    public static Tray fromMessageToTray(TrayMessage trayToAssemble){

        ArrayList<AnimalPart> parts = new ArrayList<>();
        for (AnimalPartMessage message: trayToAssemble.getAnimalPartsList()) {
            parts.add(AnimalPartAssembler.fromMessageToAnimalPart(message));
        }


        Tray tray = new Tray(
                trayToAssemble.getTypeOfPart(),
                trayToAssemble.getMaxWeight(),
                parts
        );

        tray.setTrayNumber(trayToAssemble.getTrayNumber());
        return tray;
    }

    public static TrayMessage fromTrayToMessage(Tray tray){

        ArrayList<AnimalPartMessage> partMessages = new ArrayList<>();

        for (AnimalPart part : tray.getParts()) {
            partMessages.add(AnimalPartAssembler.fromAnimalPartToMessage(part));
        }

        TrayMessage trayMessage = TrayMessage.newBuilder()
                .setTrayNumber(tray.getTrayNumber())
                .setTypeOfPart(tray.getTypeOfPart())
                .setMaxWeight(tray.getMaxWeight())
                .addAllAnimalParts(partMessages)
                .build();

        return trayMessage;
    }
}
