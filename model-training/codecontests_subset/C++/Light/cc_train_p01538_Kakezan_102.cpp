#include<bits/stdc++.h>
using namespace std;

int main(){
    unsigned long Q;
    cin >> Q;
    for(unsigned long iter = 0; iter < Q; ++iter){
        unsigned long N;
        cin >> N;
        unsigned long cnt{0};
        while(N > 9){
            unsigned long mx{0};
            for(unsigned long i = 10; i <= N; i *= 10)mx = max(mx, (N / i) * (N % i));
            ++cnt;
            N = mx;
        }
        cout << cnt << endl;
    }
}
