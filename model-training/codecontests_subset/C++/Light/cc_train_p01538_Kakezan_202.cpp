#include <iostream>
#include <algorithm>
#include <vector>
#include <array>
#include <string>
using namespace std;

int Q;

int max_kakezan(int n){
    int dec = 1;
    int front,back;
    int max = -1000;
    while(n/dec != 0) {
        front = n/dec;
        back = n%dec;
        if (max < front * back){
            max = front * back;
        }
        dec *= 10;
    }
    return max;
}

int  how_many_kakezan(int n){
    int times = 0;
    while (n/10 != 0) {    //もしnが1桁ならば、終了,それ以外は続行
        n = max_kakezan(n);
        times++;
    }
    return times;
}

int main(){
    cin >> Q;
    for (int q = 0; q < Q; q++){
        int n;
        cin >> n;
        cout << how_many_kakezan(n) << endl;
    }
}

