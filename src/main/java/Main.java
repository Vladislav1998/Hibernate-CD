import entities.Artist;
import entities.Cd;
import entities.Organization;
import org.hibernate.SessionFactory;
import test.HibernateUtil;
import test.doCd;
import test.doArtist;
import test.doOrganization;

import java.util.List;
import java.util.Scanner;

public class Main {

    public void MenuArtist(){
        doArtist artist = new doArtist();
        Scanner scanner = new Scanner(System.in);
        String select ="";
        artist.operationWithDB();
        while (!select.equals("0")){
            System.out.println("Action Number:");
            select=scanner.nextLine();
            switch (select) {
                case "1":
                    artist.selectArtist();
                    artist.operationWithDB();
                    break;
                case "2":
                    artist.selectArtist();
                    artist.deleteArtist();
                    artist.operationWithDB();
                    break;
                case "3":
                    artist.selectArtist();
                    artist.updateArtist();
                    artist.operationWithDB();
                    break;
                case "4":
                    artist.selectArtist();
                    artist.insertArtist();
                    artist.operationWithDB();
                    break;
                case "0":
                    MainMenu();
                    break;
                default:
                    break;

            }

        }
    }
    public void MenuOrg(){
        doOrganization organization = new doOrganization();
        Scanner scanner = new Scanner(System.in);
        String select ="";
        organization.operationWithDB();
        while (!select.equals("0")){
            System.out.println("Action Number:");
            select=scanner.nextLine();
            switch (select) {
                case "1":
                    organization.selectOrg();
                    organization.operationWithDB();
                    break;
                case "2":
                    organization.selectOrg();
                    organization.deleteOrg();
                    organization.operationWithDB();
                    break;
                case "3":
                    organization.selectOrg();
                    organization.updateOrg();
                    organization.operationWithDB();
                    break;
                case "4":
                    organization.selectOrg();
                    organization.insertOrg();
                    organization.operationWithDB();
                    break;
                case "0":
                    MainMenu();
                    break;
                default:
                    break;

            }

        }
    }
    public void MenuCd(){
        doCd cd = new doCd();
        Scanner scanner = new Scanner(System.in);
        String select ="";
        cd.operationWithDB();
        while (!select.equals("0")){
            System.out.println("Action Number:");
            select=scanner.nextLine();
            switch (select) {
                case "1":
                    cd.selectCd();
                    cd.operationWithDB();
                    break;
                case "2":
                    cd.selectCd();
                    cd.deleteCd();
                    cd.operationWithDB();
                    break;
                case "3":
                    cd.selectCd();
                    cd.updateCd();
                    cd.operationWithDB();
                    break;
                case "4":
                    cd.selectCd();
                    cd.insertCd();
                    cd.operationWithDB();
                    break;
                case "5":
                    cd.selectGenreCd();
                    cd.operationWithDB();
                    break;
                case "0":
                    MainMenu();
                    break;
                default:
                    break;

            }

        }
    }
    void MainMenu (){
        System.out.println("__________________________________________\n"+
                "Список таблиц БД:\n" +
                "1. Artist-музыкальные испольнители;\n" +
                "2. Orzanization - организация по выпуску CD-дисков;\n"+
                "3. CD - музыкальные диски;\n\n" +
                "Для завершения работы программы введите цифру 0.\n" +
                "Введите номер таблицы, с которой хотите продолжить работу (1,2,3).\n" +
                " ___________________________________________");
    }
    public static void main(String[] args) {
        System.out.println("Start work with DB");
        doArtist artist = new doArtist();
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        main.MainMenu();
        String numTable = "";
        while (numTable!="0"){
            System.out.println("Action Number:");
            numTable = scanner.nextLine();
            switch (numTable)
            {
                case "1":
                    System.out.println( "(Enter for select Artist)Вы работаете с таблицей Artist: \n");
                    main.MenuArtist();
                    break;
                case "2":
                    System.out.println( "Вы работаете с таблицей Orzanization: \n");
                  main.MenuOrg();
                    break;
                case "3":
                    System.out.println( "Вы работаете с таблицей CD: \n");
                  main.MenuCd();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Некоректные данные,повторите ввод");
                    break;
            }
        }
    }
}
