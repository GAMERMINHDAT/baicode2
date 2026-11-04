import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String danhSachDat(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "KHONG CO";
        }

        String[] items = s.split(",");

        class SinhVien {
            String ma;
            double diem;

            public SinhVien(String ma, double diem) {
                this.ma = ma;
                this.diem = diem;
            }
        }

        List<SinhVien> dsDat = new ArrayList<>();

        for (String item : items) {
            item = item.trim();
            if (item.isEmpty()) continue;

            String[] parts = item.split(":");
            if (parts.length == 2) {
                String ma = parts[0].trim();
                try {
                    double diem = Double.parseDouble(parts[1].trim());
                    if (diem >= 5.0) {
                        dsDat.add(new SinhVien(ma, diem));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        if (dsDat.isEmpty()) {
            return "KHONG CO";
        }

        dsDat.sort((sv1, sv2) -> {
            if (Double.compare(sv2.diem, sv1.diem) != 0) {
                return Double.compare(sv2.diem, sv1.diem);
            } else {
                return sv1.ma.compareTo(sv2.ma);
            }
        });

        StringBuilder result = new StringBuilder();
        for (SinhVien sv : dsDat) {
            result.append(sv.ma).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        String input1 = "SV01:7.5,SV02:4,SV03:9,SV04:7.5";
        System.out.println("Input:  " + input1);
        System.out.println("Output: " + danhSachDat(input1));
        System.out.println("-----------------------");

        String input2 = " SV1 : 6 , SV2 : 8.5 , SV3 : 4 ";
        System.out.println("Input:  " + input2);
        System.out.println("Output: " + danhSachDat(input2));
        System.out.println("-----------------------");

        String input3 = "SV1:3,SV2:4.5,SV3:2";
        System.out.println("Input:  " + input3);
        System.out.println("Output: " + danhSachDat(input3));
    }
}