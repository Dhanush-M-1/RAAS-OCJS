#include <bits/stdc++.h>
using namespace std;
#define rep(i,n,x) for(int i=n;i<x;i++)

int main() {
    int n; cin>>n;
    vector<int> a(n); rep(i,0,n) cin>>a[i];

    int sw = 0;
    rep(i,0,n){
        int minj = i;
        rep(j,i,n) if(a[j] < a[minj]) minj = j;
        if(i != minj) {
            swap(a[i], a[minj]);
            sw++;
        }
    }

    rep(i,0,n){
        if(i) cout<<" ";
        cout<<a[i];
    }
    cout<<endl;
    cout<<sw<<endl;

    return 0;
}
