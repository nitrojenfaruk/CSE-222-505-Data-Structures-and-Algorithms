
/**
 * It represents street on the city. It has two sides (front and back)
 */
public class Street implements City {

    private int streetLength;
    private int size = 10;   

    /* These can be reallocated */
    private Object[] frontStreet = new Object[size];
    private Object[] backStreet = new Object[size];

    @Override
    public int getLength() {
        return streetLength;
    }

    @Override
    public void setLength(int length) {
        this.streetLength = length;
        size = streetLength;
        frontStreet = new Object[size];
        backStreet = new Object[size];
    }

    /**
     * @return the backStreet
     */
    public Object[] getBackStreet() {
        return backStreet;
    }

    /**
     * @param backStreet the backStreet to set
     */
    public void setBackStreet(Object[] backStreet) {
        this.backStreet = backStreet;
    }

    /**
     * @return the frontStreet
     */
    public Object[] getFrontStreet() {
        return frontStreet;
    }

    /**
     * @param frontStreet the frontStreet to set
     */
    public void setFrontStreet(Object[] frontStreet) {
        this.frontStreet = frontStreet;
    }

    /**
     * Different types of information are presented on focusing on a building with
     * entering side choice and position
     * 
     * @param sideChoice the selection of side on the street
     * @param position   the position of the building
     */
    public void focuseOnBuilding(int sideChoice, int position) {

        Object build = new Object();
        build = (sideChoice == 1) ? frontStreet[position] : backStreet[position];

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
                reallocate(frontStreet);
                if (checkEnoughLand(frontStreet, build))
                    System.out.println("--Building has added!");
                else
                    System.out.println("--Building cannot be added to this position.");
                break;

            case 2:
                reallocate(backStreet);
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
     * @throws ArrayIndexOutOfBoundsException
     */
    private boolean checkEnoughLand(Object[] streetArray, Object build)  {

        int buildPos = 0;
        int buildLength = 0;
        int buildBound = 0;

        buildPos = (build instanceof Playground)
                ? ((Playground) build).getPosition()
                : ((Building) build).getPosition();

        buildLength = (build instanceof Playground)
                ? ((Playground) build).getLength()
                : ((Building) build).getLength();

        buildBound = buildPos + buildLength;

        if (buildPos < 0 || buildPos >= streetLength || buildLength <= 0 || buildLength > streetLength) {
            System.out.println("--Invalid build property!");
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = buildPos; i < buildBound; i++) {

            if (streetArray[i] == null) {
                if (i == buildBound - 1) {
                    constructBuilding(streetArray, build, buildPos, buildBound);
                    System.out.println("\n" + build);
                    return true;
                } else
                    continue;
            }

            else {
                System.out.println("\n" + build);
                return false;
            }
        }

        return false;

    }

    /**
     * If there is space on the street, it adds the building to the street
     * 
     * @param streetArray the front of the street or back of the street
     * @param build       the building
     * @param position    the position of building on the street
     * @param buildBound  the final position of building on the street
     */
    private void constructBuilding(Object[] streetArray, Object build, int position, int buildBound) {

        for (int i = position; i < buildBound; i++)
            streetArray[i] = build;

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
     * @throws ArrayIndexOutOfBoundsException
     */
    public void deleteBuilding(int sideChoice, int position)  {

        Object build = findBuilding(sideChoice, position);

        int buildPos = 0;
        int buildLength = 0;
        
      
        	buildPos = (build instanceof Playground)
                    ? ((Playground) build).getPosition()
                    : ((Building) build).getPosition();

            buildLength = (build instanceof Playground)
                    ? ((Playground) build).getLength()
                    : ((Building) build).getLength();
		
        

        if (buildPos < 0 || buildPos >= streetLength || buildLength <= 0 || buildLength > streetLength) {
            System.out.println("--Invalid build property!");
            throw new ArrayIndexOutOfBoundsException();
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

        Object build = new Object();
        build = (sideChoice == 1) ? frontStreet[position] : backStreet[position];
        return build;
    }

    /**
     * If there is a building at the entered position, it returns true for feedback
     * 
     * @param streetArray the front of the street or back of the street
     * @param build       the building
     * @return boolean
     */
    private boolean checkDeletion(Object[] streetArray, Object build) {

        boolean flag = false;
        boolean check = true;
        int temp, temp2;

        for (int i = 0; i < streetArray.length; i++) {
            if (build != null && streetArray[i] == build) {
                if (build instanceof Playground && check) {
                    temp = Playground.getPlaygroundNum();
                    temp2 = Playground.getPlaygroundLength();
                    Playground.setPlaygroundNum(temp - 1);
                    Playground.setPlaygroundLength(temp2 - ((Playground) build).getLength());
                    check = false;
                }
                streetArray[i] = null; // deleting operation
                flag = true;

            }
        }

        return flag;
    }

    /**
     * Reallocate frontStreet or backStreet to hold new buildings
     * 
     * @param streetArray the front of the street or back of the street
     */
    private void reallocate(Object[] streetArray) {

        int length = 0;

        for (Object obj : streetArray) {
            if (obj != null)
                length++;
        }

        if (length < size)
            return;

        int newSize = size * 2;
        Object[] oldArray = streetArray;
        streetArray = new Object[newSize];

        for (int i = 0; i < oldArray.length; i++)
            streetArray[i] = oldArray[i];

        size = newSize;

    }

    /**
     * Display total remaining length on the street
     * 
     * @return the remaining length on the street
     */
    public int remainingLength() {

        int count = 0;
        for (int i = 0; i < streetLength; i++) {
            if (backStreet[i] == null)
                count++;
            if (frontStreet[i] == null)
                count++;
        }

        return count;
    }

    /**
     * Display the list of buildings
     * 
     * @return boolean value that indicates street is empty or not
     */
    public boolean displayBuildings() {

        boolean emptyFlag = true;
        boolean emptyFlag2 = true;

        System.out.println("\nFront of street: ");

        for (int i = 0; i < size; i++) {
            if (frontStreet[i] != null) {
                System.out.println(frontStreet[i]);
                if (frontStreet[i] instanceof Building)
                    i += ((Building) frontStreet[i]).getLength();
                else
                    i += ((Playground) frontStreet[i]).getLength();
                emptyFlag = false;
            }
        }

        if (emptyFlag)
            System.out.println("--This side is empty.");

        System.out.println("\nBack of street: ");
        for (int i = 0; i < size; i++) {
            if (backStreet[i] != null) {
                System.out.println(backStreet[i]);
                if (backStreet[i] instanceof Building)
                    i += ((Building) backStreet[i]).getLength();
                else
                    i += ((Playground) backStreet[i]).getLength();
                emptyFlag2 = false;
            }
        }

        if (emptyFlag2)
            System.out.println("--This side is empty.\n");
        else
            System.out.println();

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

        for (Object obj : backStreet) {
            if (obj instanceof Building)
                result++;
        }
        for (Object obj : frontStreet) {
            if (obj instanceof Building)
                result++;
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

        int frontHeight = 0;
        int backHeight = 0;
        for (int i = 0; i < streetLength; i++) {

            frontHeight = (frontStreet[i] instanceof Building)
                    ? ((Building) frontStreet[i]).getHeight()
                    : (frontStreet[i] instanceof Playground) ? Playground.getHeight() : 0;

            backHeight = (backStreet[i] instanceof Building)
                    ? ((Building) backStreet[i]).getHeight()
                    : (backStreet[i] instanceof Playground) ? Playground.getHeight() : 0;

            column = (frontHeight >= backHeight) ? frontHeight : backHeight;
            column = (column > temp) ? column : temp;
            temp = column;

        }

        int bound = (streetLength > (column + 1)) ? streetLength : (column + 1);
        char[][] silhouette = new char[bound][bound];

        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                silhouette[i][j] = ' ';
            }
        }

        for (int i = 0; i < streetLength; i++) {

            if (frontStreet[i] != null || backStreet[i] != null) {

                if (flag) {
                    index = i;
                    flag = false;
                }

                frontBuilding = (frontStreet[i] instanceof Building)
                        ? ((Building) frontStreet[i]).getHeight()
                        : (frontStreet[i] instanceof Playground) ? Playground.getHeight() : 0;

                backBuilding = (backStreet[i] instanceof Building)
                        ? ((Building) backStreet[i]).getHeight()
                        : (backStreet[i] instanceof Playground) ? Playground.getHeight() : 0;

                maxHeight = frontBuilding >= backBuilding ? frontBuilding : backBuilding;

                if (lastHeight == maxHeight) {
                    silhouette[index][maxHeight] = '_';
                    index++;
                } else {
                    if (lastHeight < maxHeight) {
                        for (int j = lastHeight; j < maxHeight; j++) {
                            silhouette[index][j] = '|';
                            if (j == maxHeight - 1) {
                                silhouette[index + 1][j + 1] = '_';
                                index += 2;
                            }
                        }
                    }

                    else if (lastHeight > maxHeight) {
                        for (int j = lastHeight - 1; j >= maxHeight; j--) {
                            silhouette[index][j] = '|';
                            if (j == maxHeight) {
                                silhouette[index + 1][maxHeight] = '_';
                                index += 2;
                            }
                        }
                    }
                    lastHeight = maxHeight;
                }

            }

            else {
                if (lastHeight == 0 && index < bound - 1) {
                    silhouette[index][0] = '_';
                    index++;
                } else {
                    for (int j = lastHeight; lastHeight != 0 && j > 0; j--) {
                        silhouette[index][j - 1] = '|';
                        if (j == 1 && index + 1 != streetLength) {
                            silhouette[index + 1][0] = '_';
                            index += 2;
                        }
                    }
                    lastHeight = 0;
                }
            }
        }

        for (int i = column; i >= 0; i--) {
            for (int j = 0; j < bound; j++) {
                System.out.print(silhouette[j][i]);
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

}