package com.runupstdio.culturenesia;

public class Quizionaire {
    public String questions1[] = {
            "Apa nama ibukota provinsi Jawa Timur?",
            "Apa nama rumah adat provinsi Kalimantan Selatan?",
            "Apa senjata khas dari provinsi DIY?",
            "Tari Merak berasal dari provinsi?",
            "Bahasa Abui adalah bahasa yang digunakan masyarakat di provinsi?"
    };
    public String choices1[][] = {
            {"Surabaya", "Lamongan", "Jombang"},
            {"Betang", "Joglo", "Bubungan Tinggi"},
            {"Golok", "Tombak", "Sumpit/Sipet"},
            {"Daerah Istimewa Yogyakarta", "Kalimantan Timur", "Jawa Barat"},
            {"Nusa Tenggara Timur", "Jawa Timur", "Kalimantan Selatan"}
    };
    public String correctAnswer1[] = {
            "Surabaya",
            "Bubungan Tinggi",
            "Tombak",
            "Jawa Barat",
            "Nusa Tenggara Timur"
    };

    public String questions2[] = {
            "Wisata Kawah Putih berada di provinsi?",
            "Monumen Nasional berada di provinsi?",
            "Pulau Derawan berada di provinsi?",
            "Baloy Mayo adalah nama rumah adat yang berasal dari provinsi?",
            "Sumpit atau Sipet adalah senjata yang berasal dari provinsi?",
            "Rumah adat yang menyerupai Gapura adalah rumah adat yang terdapat di provinsi?",
            "Kujang adalah nama senjata tradisional dari provinsi?",
            "Baduy adalah nama suku yang mendiami provinsi?",
            "Wisata Gunung Karang terdapat di provinsi?",
            "Apa nama Rumah Adat Jawa Tengah?"
    };
    public String choices2[][] = {
            {"Banten", "Nusa tenggara Timur", "Jawa Barat"},
            {"Yogyakarta", "Jawa Tengah", "DKI Jakarta"},
            {"Jawa Tengah", "Kalimantan Timur", "Bali"},
            {"Kalimantan Utara", "Nusa Tenggara Timur", "DKI Jakarta"},
            {"Yogyakarta", "Bali", "Kalimantan tengah"},
            {"Bali", "Kalimantan Utara", "Nusa Tenggara Barat"},
            {"Kalimantan Selatan", "Kalimantan Timur", "Jawa Barat"},
            {"Papua", "Kalimantan Tengah", "Banten"},
            {"Banten", "Jawa Timur", "Jawa Tengah"},
            {"Betang Radakng", "Joglo", "Mbaru Niang"}
    };
    public String correctAnswer2[] = {
            "Jawa Barat",
            "Dki Jakarta",
            "Kalimantan Timur",
            "Kalimantan Utara",
            "Kalimantan Tengah",
            "Bali",
            "Jawa Barat",
            "Banten",
            "Banten",
            "Joglo"
    };

    public String questions3[] = {
            "Apa Nama Senjata Provinsi Maluku Utara?",
            "Suku Ambon mendiami provinsi?",
            "Rumah Tambi adalah Rumah Adat Provinsi?",
            "Badi adalah senjata tradisional provinsi?",
            "Wisata Danau Tahai terdapat di provinsi?",
            "Apa nama rumah adat yang mempunyai struktur panggung dengan tiang tiang penyangga bulat?",
            "Bahasa Banjar adalah bahasa yang digunakan masyarakat provinsi?",
            "Kabeala adalah senjata tradisional yang berasal dari provinsi?",
            "Bahasa Tidung adalah bahasa sehari hari masyarakat provinsi?",
            "Pulau Komodo Berada di provinsi?",
            "Belati adalah senjata tradisional provinsi?",
            "Bangunan Angkul Angkul adalah rumah adat provinsi?",
            "Suku Menyuke mendiami provinsi?",
            "Bahasa Sasak adalah bahasa sehari hari masyarakat provinsi?",
            "Suku Asmat mendiami provinsi?"
    };
    public String choices3[][] = {
            {"Kujang", "Parang Salawaku", "Keris"},
            {"Maluku", "Maluku Utara", "Sulawesi Selatan"},
            {"Maluku", "Sulawesi Tengah", "Sulawesi Tenggara"},
            {"Banten", "Maluku", "Gorontalo"},
            {"Kalimantan Selatan", "Kalimantan Timur", "Kalimantan tengah"},
            {"Rumah Tongkonan", "Rumah Tambi", "Rumah Boyang"},
            {"Kalimantan Selatan", "Maluku Utara", "Sulawesi Selatan"},
            {"Nusa Tenggara Timur", "Papua Barat", "Papua"},
            {"Banten", "Maluku Utara", "Kalimantan Utara"},
            {"Nusa Tenggara Timur", "Banten", "Maluku"},
            {"Papua", "Papua Barat", "Maluku"},
            {"Bali", "Sulawesi Selatan", "Sulawesi Tenggara"},
            {"Papua Barat", "Kalimantan Barat", "Bali"},
            {"Kalimantan Timur", "Nusa Tenggara Timur", "Nusa Tenggara Barat"},
            {"Papua", "Banten", "Maluku"}
    };
    public String correctAnswer3[] = {
            "Parang Salawaku",
            "Maluku",
            "Sulawesi Tengah",
            "Gorontalo",
            "Kalimantan Tengah",
            "Rumah Tongkonan",
            "Jawa Barat",
            "Nusa Tenggara Timur",
            "Kalimantan Utara",
            "Nusa Tenggara Timur",
            "Papua",
            "Bali",
            "Kalimantan Barat",
            "Nusa Tenggara Barat",
            "Papua"
    };

    public String getQuestionLv1(int a){
        String question = questions1[a];
        return question;
    }
    public String getChoice1Lv1(int a){
        String choice = choices1[a][0];
        return choice;
    }
    public String getChoice2Lv1(int a){
        String choice = choices1[a][1];
        return choice;
    }
    public String getChoice3Lv1(int a){
        String choice = choices1[a][2];
        return choice;
    }
    public String getCorrectAnswerLv1(int a){
        String answer = correctAnswer1[a];
        return answer;
    }

    public String getQuestionLv2(int a){
        String question = questions2[a];
        return question;
    }
    public String getChoice1Lv2(int a){
        String choice = choices2[a][0];
        return choice;
    }
    public String getChoice2Lv2(int a){
        String choice = choices2[a][1];
        return choice;
    }
    public String getChoice3Lv2(int a){
        String choice = choices2[a][2];
        return choice;
    }
    public String getCorrectAnswerLv2(int a){
        String answer = correctAnswer2[a];
        return answer;
    }

    public String getQuestionLv3(int a){
        String question = questions3[a];
        return question;
    }
    public String getChoice1Lv3(int a){
        String choice = choices3[a][0];
        return choice;
    }
    public String getChoice2Lv3(int a){
        String choice = choices3[a][1];
        return choice;
    }
    public String getChoice3Lv3(int a){
        String choice = choices3[a][2];
        return choice;
    }
    public String getCorrectAnswerLv3(int a){
        String answer = correctAnswer3[a];
        return answer;
    }
}
