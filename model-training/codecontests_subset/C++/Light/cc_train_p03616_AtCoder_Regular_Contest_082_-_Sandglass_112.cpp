#include <bits/stdc++.h>
using namespace std;

int main(){
    int X, K;
    cin >> X >> K;
    vector<int> R(K+2);
    for(int i=1; i<=K; i++) cin >> R[i];
    R[K+1] = 1e9;
    int Q;
    cin >> Q;
    vector<int> T(Q), A(Q);
    for(int i=0; i<Q; i++) cin >> T[i] >> A[i];

    int q = 0;
    int mni = 0, mn = 0, mxi = X, mx = X;
    bool rev = false;
    for(int i=0; i<=K; i++){
        //cerr << mni << " " << mn << " " << mxi << " " << mx << endl;
        while(q < Q && T[q] <= R[i+1]){
            int a = (rev ? X-A[q] : A[q]), t = T[q] - R[i];
            int ans = max(min(mx, max(mn, mn+a-mni)) - t, 0);
            if(rev) ans = X-ans;
            cout << ans << endl;
            q++;
        }
        mn -= R[i+1] - R[i];
        mx -= R[i+1] - R[i];
        if(mx <= 0){
            mni = mxi = mn = mx = 0;
        }else if(mn <= 0){
            mni -= mn;
            mn = 0;
        }
        mni = X-mni;
        mxi = X-mxi;
        mn  = X-mn;
        mx  = X-mx;
        swap(mni, mxi);
        swap(mn, mx);
        rev = !rev;
    }
}