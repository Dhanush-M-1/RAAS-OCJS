#include <bits/stdc++.h>
using namespace std;

int Q,N,s,m,i;

int main(){
    cin.tie(0);
    ios::sync_with_stdio(false);
    cin >> Q;
    for (;Q--;){
        cin >> N;
        for(i=0;N>10;++i){
            s=10,m=0;
            while(s<N){
                m=max(m,(N/s)*(N%s));
                s*=10;
            }
            N=m;
        }
        cout << i << '\n';
    }
}
