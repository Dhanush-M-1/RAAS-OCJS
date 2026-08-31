#include <bits/stdc++.h>
using namespace std;

int main(){
    int q, n;
    cin >> q;
    while(q--){
        cin >> n;
        int cnt = 0;
        while(n >= 10){
            int tmp = n, k = 0;
            while(tmp >= 10){
                tmp /= 10;
                k++;
            }
            tmp = n, n = 0;
            for(int i = 0; i < k; i++){
                int dig = 10;
                for(int j = 0; j < i; j++) dig *= 10;
                n = max(n, (tmp / dig) * (tmp % dig));
            }
            cnt++;
        }
        cout << cnt << endl;
    }
    return 0;
}
