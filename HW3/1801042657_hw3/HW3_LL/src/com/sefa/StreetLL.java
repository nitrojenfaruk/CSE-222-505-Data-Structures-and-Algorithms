package com.sefa;

import java.util.LinkedList;
import java.util.List;

/**
 * It represents street on the city. It has two sides (front and back)
 */
public class StreetLL implements City {
    private int streetLength;

    private LinkedList<Object> frontStreet = new LinkedList<>();
    private LinkedList<Object> backStreet = new LinkedList<>();

    @Override
    public int getLength() {
        return streetLength;
    }

    @Override
    public void setLength(int length) {
        if (length <= 0)
            throw new NegativeArraySizeException();
        this.streetLength = length;
    }

    /**
     * Different types of information are presented on focusing on a building with
     * entering side choice and position
     * 
     * @param sideChoice the selection of side on the street
     * @param position   the position of the building
     */
    public void focuseOnBuilding(int sideChoice, int position) {

        int buildPos = 0;
        int buildLength = 0;
        int buildBound = 0;

        Object build = new Object();

        if (sideChoice == 1) { // frontStreet
            for (int i = 0; i < frontStreet.size(); i++) {
                buildPos = (frontStreet.get(i) instanceof Playground)
                        ? ((Playground) frontStreet.get(i)).getPosition()
                        : ((Building) frontStreet.get(i)).getPosition();
                buildLength = (frontStreet.get(i) instanceof Playground)
                        ? ((Playground) frontStreet.get(i)).getLength()
                        : ((Building) frontStreet.get(i)).getLength();

                buildBound = buildPos + buildLength;
                if (position < buildBound && position >= buildPos) {
                    build = frontStreet.get(i);
                    break;
                }
            }
        } else if (sideChoice == 2) { // backStreet
            for (int i = 0; i < backStreet.size(); i++) {
                buildPos = (backStreet.get(i) instanceof Playground)
                        ? ((Playground) backStreet.get(i)).getPosition()
                        : ((Building) backStreet.get(i)).getPosition();
                buildLength = (backStreet.get(i) instanceof Playground)
                        ? ((Playground) backStreet.get(i)).getLength()
                        : ((Building) backStreet.get(i)).getLength();

                buildBound = buildPos + buildLength;
                if (position < buildBound && position >= buildPos) {
                    build = backStreet.get(i);
                    break;
                }
            }
        }

        System.out.println();

        if (build instanceof House)
            System.out.println("--House owner: " + ((House) build).getOwner());

        else if (build instanceof Office)
            System.out.println("--Job type: " + ((Office) build).getJobType());

        else if (build instanceof Playground)
            System.out.println("--Playground length: " + ((Playground) build).getLength());

        else if (build instanceof Market)
            System.out.println("--Market closing time: " + ((Market) build).getClosingTime());

        else
            System.out.println("--No building at this position.");
        System.out.println();

    }

    /**
     * Add a building to the street with entering side choice and building
     * properties
     * 
     * @param sideChoice the selection of side on the street
     * @param build      the building
     */
    public void addBuilding(int sideChoice, Object build) {

        switch (sideChoice) {
            case 1:
                if (checkEnoughLand(frontStreet, build))
                    System.out.println("--Building has added!");
                else
                    System.out.println("--Building cannot be added to this position.");
                break;

            case 2:
                if (checkEnoughLand(backStreet, build))
                    System.out.println("--Building has added!");
                else
                    System.out.println("--Building cannot be added to this position.");
                break;

            default:
                System.out.println("--Invalid choice!");
                break;
        }

        displayBuildings();

    }

    /**
     * Check whether enough land on the street for adding a building
     * 
     * @param streetArray the front of the street or back of the street
     * @param build       the building
     * @throws IndexOutOfBoundsException
     */
    private boolean checkEnoughLand(LinkedList<Object> streetArray, Object build) {

        int buildPos = 0;
        int buildLength = 0;
        int buildBound = 0;

        buildPos = (build instanceof Playground)
                ? ((Playground) build).getPosition()
                : ((Building) build).getPosition();

        buildLength = (build instanceof Playground)
                ? ((Playground) build).getLength()
                : ((Building) build).getLength();

        if (buildPos >= streetLength || buildLength > streetLength || buildPos < 0 || buildLength <= 0) {
            System.out.println("--Invalid build property!");
            throw new IndexOutOfBoundsException();
        }

        if (streetArray.isEmpty()) {
            constructBuilding(streetArray, build);
            System.out.println("\n" + build);
            return true;
        }

        for (int i = 0; i < streetArray.size(); i++) {
            buildPos = (streetArray.get(i) instanceof Playground)
                    ? ((Playground) streetArray.get(i)).getPosition()
                    : ((Building) streetArray.get(i)).getPosition();
            buildLength = (streetArray.get(i) instanceof Playground)
                    ? ((Playground) streetArray.get(i)).getLength()
                    : ((Building) streetArray.get(i)).getLength();

            buildBound = buildPos + buildLength;
            if (build instanceof Building) {
                if (((Building) build).getPosition() < buildBound &&
                        ((Building) build).getPosition() >= buildPos) {
                    System.out.println("\n" + build);
                    return false;
                }
            } else if (build instanceof Playground) {
                if (((Playground) build).getPosition() < buildBound &&
                        ((Playground) build).getPosition() >= buildPos) {
                    System.out.println("\n" + build);
                    return false;
                }
            }
        }
        // Position is empty
        constructBuilding(streetArray, build);
        System.out.println("\n" + build);
        return true;

    }

    /**
     * If there is space on the street, it adds the building to the street
     * 
     * @param streetArray the front of the street or back of the street
     * @param build       the building
     */
    private void constructBuilding(LinkedList<Object> streetArray, Object build) {

        streetArray.add(build); // Adding building to the street

        /* Changing total playground length and number */
        if (build instanceof Playground) {
            int oldLength = Playground.getPlaygroundLength();
            int buildLength = ((Playground) build).getLength();
            int oldNum = Playground.getPlaygroundNum();
            Playground.setPlaygroundLength(oldLength + buildLength);
            Playground.setPlaygroundNum(oldNum + 1);
        }

    }

    /**
     * Delete building from the street according to the entered position
     * 
     * @param sideChoice the selection of side on the street
     * @param position   the position of building on the street
     * @throws IndexOutOfBoundsException
     */
    public void deleteBuilding(int sideChoice, int position) {

        Object build = findBuilding(sideChoice, position);

        int buildPos = 0;
        int buildLength = 0;

        if (!(build instanceof Playground) && !(build instanceof Building)) {
            System.out.println("--There is no building.");
            return;
        }

        buildPos = (build instanceof Playground)
                ? ((Playground) build).getPosition()
                : ((Building) build).getPosition();

        buildLength = (build instanceof Playground)
                ? ((Playground) build).getLength()
                : ((Building) build).getLength();

        if (buildPos < 0 || buildPos >= streetLength || buildLength <= 0 || buildLength > streetLength) {
            System.out.println("--Invalid build property!");
            throw new IndexOutOfBoundsException();
        }

        switch (sideChoice) {
            case 1:
                if (checkDeletion(frontStreet, build)) {
                    System.out.println("\n" + build);
                    System.out.println("--Building has deleted.");
                } else
                    System.out.println("--There is no building.");

                break;

            case 2:
                if (checkDeletion(backStreet, build)) {
                    System.out.println("\n" + build);
                    System.out.println("--Building has deleted.");
                } else
                    System.out.println("--There is no building.");

                break;

            default:
                System.out.println("--Invalid choice!");
                break;
        }

        displayBuildings();

    }

    /**
     * Find building according to the side choice and position
     * 
     * @param sideChoice the selection of side on the street
     * @param position   the position of building on the street
     */
    private Object findBuilding(int sideChoice, int position) {

        int buildPos = 0;
        int buildLength = 0;
        int buildBound = 0;

        Object build = new Object();

        if (sideChoice == 1) { // frontStreet
            for (int i = 0; i < frontStreet.size(); i++) {
                buildPos = (frontStreet.get(i) instanceof Playground)
                        ? ((Playground) frontStreet.get(i)).getPosition()
                        : ((Building) frontStreet.get(i)).getPosition();
                buildLength = (frontStreet.get(i) instanceof Playground)
                        ? ((Playground) frontStreet.get(i)).getLength()
                        : ((Building) frontStreet.get(i)).getLength();

                buildBound = buildPos + buildLength;
                if (position < buildBound && position >= buildPos) {
                    build = frontStreet.get(i);
                    break;
                }
            }
        } else if (sideChoice == 2) { // backStreet
            for (int i = 0; i < backStreet.size(); i++) {
                buildPos = (backStreet.get(i) instanceof Playground)
                        ? ((Playground) backStreet.get(i)).getPosition()
                        : ((Building) backStreet.get(i)).getPosition();
                buildLength = (backStreet.get(i) instanceof Playground)
                        ? ((Playground) backStreet.get(i)).getLength()
                        : ((Building) backStreet.get(i)).getLength();

                buildBound = buildPos + buildLength;
                if (position < buildBound && position >= buildPos) {
                    build = backStreet.get(i);
                    break;
                }
            }
        }

        return build;
    }

    /**
     * If there is a building at the entered position, it returns true for feedback
     * 
     * @param streetArray the front of the street or back of the street
     * @param build       the building
     * @return boolean
     */
    private boolean checkDeletion(LinkedList<Object> streetArray, Object build) {

        boolean flag = false;
        int temp, temp2;

        if (build instanceof Playground) {
            temp = Playground.getPlaygroundNum();
            temp2 = Playground.getPlaygroundLength();
            Playground.setPlaygroundNum(temp - 1);
            Playground.setPlaygroundLength(temp2 - ((Playground) build).getLength());
        }

        if (streetArray.remove(build)) {
            flag = true;
        }

        return flag;
    }

    /**
     * Display total remaining length on the street
     * 
     * @return the remaining length on the street
     */
    public int remainingLength() {

        int count = 0;
        for (int i = 0; i < frontStreet.size(); i++) {
            if (frontStreet.get(i) instanceof Building)
                count += ((Building) frontStreet.get(i)).getLength();
            else if (frontStreet.get(i) instanceof Playground)
                count += ((Playground) frontStreet.get(i)).getLength();
        }
        for (int i = 0; i < backStreet.size(); i++) {
            if (backStreet.get(i) instanceof Building)
                count += ((Building) backStreet.get(i)).getLength();
            else if (backStreet.get(i) instanceof Playground)
                count += ((Playground) backStreet.get(i)).getLength();
        }

        return streetLength * 2 - count;
    }

    /**
     * Display the list of buildings
     * 
     * @return boolean value that indicates street is empty or not
     */
    public boolean displayBuildings() {

        boolean emptyFlag = false;
        boolean emptyFlag2 = false;

        System.out.println("\nFront of street: ");

        if (frontStreet.isEmpty()) {
            System.out.println("--This side is empty.");
            emptyFlag = true;
        } else {
            for (int i = 0; i < frontStreet.size(); i++) {
                System.out.println(frontStreet.get(i));
            }
        }

        System.out.println("\nBack of street: ");

        if (backStreet.isEmpty()) {
            System.out.println("--This side is empty.\n");
            emptyFlag2 = true;
        } else {
            for (int i = 0; i < backStreet.size(); i++) {
                System.out.println(backStreet.get(i));
            }
            System.out.println();
        }

        if (emptyFlag && emptyFlag2)
            return false;
        else
            return true;

    }

    /**
     * Shows playground number in the street
     * 
     * @return the playgroundNumber
     */
    public int playgroundNumber() {
        return Playground.getPlaygroundNum();
    }

    /**
     * Shows ratio of length of playgrounds in the street
     * 
     * @return the playgroundRatio
     */
    public String playgroundRatio() {
        return Playground.getPlaygroundLength() + "/" + (streetLength * 2);
    }

    /**
     * Calculate total building length (market, office, house) on the street
     * 
     * @return the totalBuildingLength
     */
    public int totalBuildingLength() {
        int result = 0;

        for (int i = 0; i < backStreet.size(); i++) {
            if (backStreet.get(i) instanceof Building)
                result += ((Building) backStreet.get(i)).getLength();
        }
        for (int i = 0; i < frontStreet.size(); i++) {
            if (frontStreet.get(i) instanceof Building)
                result += ((Building) frontStreet.get(i)).getLength();
        }

        return result;
    }

    /**
     * Display the skyline silhouette of the street
     */
    public void displaySilhouette() {

        boolean flag = true;
        int index = 0;
        int maxHeight = 0;
        int lastHeight = 0;
        int frontBuilding = 0;
        int backBuilding = 0;
        int column = 0;
        int temp = 0;
        boolean check = false;

        int frontHeight = 0;
        int backHeight = 0;
        int maxSize = (frontStreet.size() >= backStreet.size()) ? frontStreet.size() : backStreet.size();

        for (int i = 0; i < maxSize; i++) {
            if (i < frontStreet.size()) {
                frontHeight = (frontStreet.get(i) instanceof Building)
                        ? ((Building) frontStreet.get(i)).getHeight()
                        : (frontStreet.get(i) instanceof Playground) ? Playground.getHeight() : 0;
            } else
                frontHeight = 0;

            if (i < backStreet.size()) {
                backHeight = (backStreet.get(i) instanceof Building)
                        ? ((Building) backStreet.get(i)).getHeight()
                        : (backStreet.get(i) instanceof Playground) ? Playground.getHeight() : 0;
            } else
                backHeight = 0;

            column = (frontHeight >= backHeight) ? frontHeight : backHeight;
            column = (column > temp) ? column : temp;
            temp = column;

        }

        int bound = (streetLength > (column + 1)) ? streetLength : (column + 1);

        List<List<Character>> silhouette = new LinkedList<List<Character>>();

        for (int i = 0; i < bound; i++) {
            silhouette.add(new LinkedList<Character>());
        }

        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                silhouette.get(i).add(j, ' ');
            }
        }

        Object build = new Object();
        Object build2 = new Object();

        for (int i = 0; i < streetLength; i++) {

            check = false;
            if (checkPosition(i) == 1) {

                if (flag) {
                    index = i;
                    flag = false;
                }

                build = findBuilding(1, i);
                build2 = findBuilding(2, i);
                if ((!(build instanceof Playground) && !(build instanceof Building))
                        && !(build2 instanceof Playground) && !(build2 instanceof Building)) {
                    check = true;
                }

                if (check)
                    continue;

                frontBuilding = (build instanceof Building)
                        ? ((Building) build).getHeight()
                        : (build instanceof Playground) ? Playground.getHeight() : 0;
                backBuilding = (build2 instanceof Building)
                        ? ((Building) build2).getHeight()
                        : (build2 instanceof Playground) ? Playground.getHeight() : 0;

                maxHeight = frontBuilding >= backBuilding ? frontBuilding : backBuilding;

                if (lastHeight == maxHeight) {
                    silhouette.get(index).set(maxHeight, '_');
                    index++;
                } else {
                    if (lastHeight < maxHeight) {
                        for (int j = lastHeight; j < maxHeight; j++) {
                            silhouette.get(index).set(j, '|');
                            if (j == maxHeight - 1) {
                                silhouette.get(index + 1).set(j + 1, '_');
                                index += 2;
                            }
                        }
                    }

                    else if (lastHeight > maxHeight) {
                        for (int j = lastHeight - 1; j >= maxHeight; j--) {
                            silhouette.get(index).set(j, '|');
                            if (j == maxHeight) {
                                silhouette.get(index + 1).set(maxHeight, '_');
                                index += 2;
                            }
                        }
                    }
                    lastHeight = maxHeight;
                }

            }

            else {
                if (lastHeight == 0 && index < bound - 1) {
                    silhouette.get(index).set(0, '_');
                    index++;
                } else {
                    for (int j = lastHeight; lastHeight != 0 && j > 0; j--) {
                        silhouette.get(index).set(j - 1, '|');
                        if (j == 1 && index + 1 != streetLength) {
                            silhouette.get(index + 1).set(0, '_');
                            index += 2;
                        }
                    }
                    lastHeight = 0;
                }
            }

        }

        for (int i = column; i >= 0; i--) {
            for (int j = 0; j < bound; j++) {
                System.out.print(silhouette.get(j).get(i));
            }
            System.out.println();
        }

        for (int j = 0; j < bound; j++) {
            if (j == 0 || j == bound - 1)
                System.out.print('|');
            else
                System.out.print('_');
        }

        System.out.println();

    }

    /**
     * Check given position on the street
     * 
     * @param index
     * @return
     */
    private int checkPosition(int index) {

        int buildPos = 0;
        int buildLength = 0;
        int buildBound = 0;
        for (int i = 0; i < frontStreet.size(); i++) {
            buildPos = (frontStreet.get(i) instanceof Playground)
                    ? ((Playground) frontStreet.get(i)).getPosition()
                    : ((Building) frontStreet.get(i)).getPosition();
            buildLength = (frontStreet.get(i) instanceof Playground)
                    ? ((Playground) frontStreet.get(i)).getLength()
                    : ((Building) frontStreet.get(i)).getLength();

            buildBound = buildPos + buildLength;
            if (index < buildBound && index >= buildPos)
                return 1;
        }
        for (int i = 0; i < backStreet.size(); i++) {
            buildPos = (backStreet.get(i) instanceof Playground)
                    ? ((Playground) backStreet.get(i)).getPosition()
                    : ((Building) backStreet.get(i)).getPosition();
            buildLength = (backStreet.get(i) instanceof Playground)
                    ? ((Playground) backStreet.get(i)).getLength()
                    : ((Building) backStreet.get(i)).getLength();

            buildBound = buildPos + buildLength;
            if (index < buildBound && index >= buildPos)
                return 1;
        }

        return 0;
    }
}
