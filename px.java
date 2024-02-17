public class px {
    public static void main(String[] args) {
        TvDVD tvDVD = new TvDVD(); // TvDVD 객체 생성
        tvDVD.channel = 10;        // TvDVD 객체를 통해 channel에 값을 설정
        tvDVD.channela();          // TvDVD 객체를 통해 channela 메서드 호출
        tvDVD.dvd.play();
    }
    Tv t;
    
}

class Tv {
    int channel;

    void channela() {
        ++channel;
    }
}

class TvDVD extends Tv {
    DVD dvd = new DVD();
}

class DVD {
    void play() {}
}

// public class px {
//     public static void main(String[] args) {
        
//     }
// }

// class TvDVD extends Tv{
//         DVD dvd = new DVD();

//             TvDVD.channel = 10;
//             TvDVD.channela();
//         }

// class Tv {
//         int channel;

//         void channela() {++channel;}
//     }

// class DVD{
//     void play(){}
// }