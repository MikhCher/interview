package yandex;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Conference {
    private final List<Event> confs = new ArrayList<>();

    private static class Event {
        int day;
        LocalTime time;
        int duration;
        int numParticipants;
        List<String> names = new ArrayList<>();

        Event(String[] arguments) {
            this.day = Integer.parseInt(arguments[0]);
            this.time = LocalTime.parse(arguments[1]);
            this.duration = Integer.parseInt(arguments[2]);
            this.numParticipants = Integer.parseInt(arguments[3]);
            for (int i = 4; i < arguments.length; i++)
                names.add(arguments[i]);
        }
    }

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/yandex/conferenceIn.txt"))) {
            int numLines = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numLines; i++) {
                String line = reader.readLine();
                if (line.startsWith("APPOINT")) {
                    line = line.substring("APPOINT".length() + 1);
                    if (addConference(line.split(" "))) System.out.println("OK");
                    else System.out.println("FAIL");
                } else if (line.startsWith("PRINT")) {
                    printInfo(line.substring("PRINT".length() + 1).split(" "));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean addConference(String[] arguments) {
        if (!isAvailable(Integer.parseInt(arguments[0]),
                LocalTime.parse(arguments[1]), Integer.parseInt(arguments[2])))
            return false;
        return confs.add(new Event(arguments));
    }

    private boolean isAvailable(int day, LocalTime time, int duration) {
        for (Event event : confs) {
            if (event.day == day &&
                    (time.isAfter(event.time) && time.isBefore(event.time.plusMinutes(event.duration))) ||
                    (time.isBefore(event.time) && time.isBefore(event.time.plusMinutes(event.duration))
                            && time.plusMinutes(duration).isAfter(event.time))) {
                return false;
            }
        }
        return true;
    }
    private void printInfo(String[] arguments) {
        confs.sort((e1, e2) -> {
            if (e1.day == e2.day) return e1.time.compareTo(e2.time);
            return e1.day - e2.day;
        });
        for (Event event : confs) {
            if (event.day == Integer.parseInt(arguments[0]) && event.names.contains(arguments[1])) {
                System.out.print(event.time + " " + event.duration  + " ");
                for (String s : event.names) {
                    System.out.print(s  + " ");
                }
                System.out.println();
            }
        }
    }
}