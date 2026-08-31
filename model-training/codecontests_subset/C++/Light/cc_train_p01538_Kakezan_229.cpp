#include <iostream>
#include <algorithm>

using namespace std;

int main(void){
    int q, n;
    cin >> q;
    for(int i = 0; i < q; i++){
        cin >> n;
        int cnt = 0;
        while(n >= 10){
            int d = 10;
            int ma = 0;
            while(int s = n / d){
                ma = max(s * (n - s * d), ma);
                d *= 10;
            }
            n = ma;
            cnt++;
        }
        cout << cnt << endl;
    }
}