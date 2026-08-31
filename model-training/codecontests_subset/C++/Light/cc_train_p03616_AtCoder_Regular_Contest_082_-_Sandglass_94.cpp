#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5+5;
int X, K, Q, r[maxn], t[maxn], a[maxn], ub, lb, b, t1, t2, add, tmp, diff, sgn;
void Add(int &n, int num){
    n+=num;
    n = max(0, min(X, n));
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> X >> K;
    for(int i = 1; i <= K; i++) cin >> r[i];
    cin >> Q;
    for(int i = 1; i <= Q; i++) cin >> t[i] >> a[i];
    t1 = 0, t2 = 1;
    lb = b = 0, ub = X, sgn = -1;
    while(t2 <= Q){
        if(t[t2] > r[t1+1] && t1 < K){
            t1++;
            add = sgn*(r[t1] - r[t1-1]);
            Add(lb, add); Add(ub, add);
            b+=add;
            sgn*=-1;
        }
        else{
            diff = (t[t2] - r[t1]);
            tmp = max(lb, min(ub, a[t2]+b));
            Add(tmp, diff*sgn);
            cout << tmp << "\n";
            t2++;
        }
    }
    return 0;
}