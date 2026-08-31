#include "bits/stdc++.h"
#define ll long long
#define pb push_back
using namespace std;
void solve(){
    int k, n , m; cin >> k >> n >> m;
    int a[n], b[m];
    for(int i=0; i<n; i++) cin >> a[i];
    for(int i=0; i<m; i++) cin >> b[i];
    int p1 = 0, p2 = 0;
    vector<int> v;
    while(p1 < n && p2 < m){
        if(a[p1] == 0) { v.pb(0); p1++; k++;}
        else if(b[p2] == 0){ v.pb(0); p2++; k++;}
        else{
            if(a[p1] > k && b[p2] > k){ cout << -1; return; }
            if(a[p1] < b[p2]) { v.pb(a[p1]); p1++; }
            else { v.pb(b[p2]); p2++; }
        }
    }
    while(p1 < n){
        if(a[p1] == 0) k++;
        if(a[p1] > k) { cout << -1; return; }
        v.pb(a[p1]); p1++;
    }
    while(p2 < m){
        if(b[p2] == 0) k++;
        if(b[p2] > k) { cout << -1; return; }
        v.pb(b[p2]); p2++;
    }
    for(auto it : v) cout << it << " ";
    
}
int main(){
    int  t; cin >> t;
    while(t--){
        solve();
        cout << "\n";
    }
}