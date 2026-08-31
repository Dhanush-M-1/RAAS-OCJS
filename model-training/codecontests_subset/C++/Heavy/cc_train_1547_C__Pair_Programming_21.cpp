#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll MAX=1e18+1;
const int NN=1e5+5;
const int mod=1e9+7;
#define pb push_back
//s1=string(3,'a')
//s1="aaa"
// use long double for precision not double
void solve(){
    int k,n,m;
    cin>>k>>n>>m;
    int a[n],b[m];
    for(int i=0;i<n;i++)
        cin>>a[i];
    for(int i=0;i<m;i++)
        cin>>b[i];
    vector<int> v;
    int ai=0,bi=0,turn=1;
    while(ai<n || bi<m){
        if(turn){
            if(ai<n && a[ai]==0){
                v.pb(0);
                k++,ai++;
            }
            else if(ai<n && a[ai]<=k){
                v.pb(a[ai]);
                ai++;
            }
            else if(bi>=m || b[bi]>k){
                cout<<-1<<endl;
                return;
            }
        }
        else{
            if(bi<m && b[bi]==0){
                v.pb(0);
                k++,bi++;
            }
            else if(bi<m && b[bi]<=k){
                v.pb(b[bi]);
                bi++;
            }
            else if(ai>=n || a[ai]>k){
                cout<<-1<<endl;
                return;
            }
        }
        turn ^= 1;
    }
    if(v.size()!=n+m){
        cout<<-1<<endl;
    }
    else{
        for(auto it: v)
            cout<<it<<" ";
        cout<<endl;
    }
}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int t=1;
    cin>>t;
    while(t--) solve();
    return 0;
}
//#ifndef ONLINE_JUDGE
//cout<<"\nTime Elapsed: " << 1.0*clock() / CLOCKS_PER_SEC << " sec\n";
//#endif
// always check for long long
// vector<int> v[30]; -> vector inside array of fixed sized 30
// 2LL
//cout << fixed << setprecision(6) << pi <<" "<<npi<<endl;
