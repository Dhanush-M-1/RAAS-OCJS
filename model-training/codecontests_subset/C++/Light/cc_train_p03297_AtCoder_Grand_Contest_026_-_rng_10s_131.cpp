#include <bits/stdc++.h>
using namespace std;

int64_t gcd(int64_t a, int64_t b){
    return b==0 ? a : gcd(b, a%b);
}

bool solve(){
    int64_t A, B, C, D;
    cin >> A >> B >> C >> D;
    if(A < B || B > D) return false;
    int64_t g = gcd(B, D);
    int64_t r = A%g;
    int64_t k = (C+g-r)/g;
    int64_t lim = g*k+r;
    return (lim >= B);
}

int main(){
    int T;
    cin >> T;
    while(T--) cout << (solve() ? "Yes" : "No") << endl;
}