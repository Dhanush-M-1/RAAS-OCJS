#include <bits/stdc++.h>
using namespace std;
#define fast                      \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);
#define ll long long
#define ld long double
#define fori(i,a,n,p) for(int i=a;i<n;i+=p)
#define forl(i,a,n,p) for(ll i=a;i<n;i+=p)
#define f first
#define s second
#define mod 1000000007
#define pb push_back
#define mp make_pair
#define PI 3.14159265358979323846
#define veci vector<int>
#define vecl vector<long long>
#define vecs vector<string>
#define vec2d vector<pair<long long,long long>>
void solve(){
    int k,n,m;cin>>k>>n>>m;
    int a[n],b[m];
    fori(i,0,n,1){
        cin>>a[i];
    }fori(i,0,m,1){
        cin>>b[i];
    }
    veci v;
    int x=0,y=0;
    while (x!=n || y!=m){
        if (x!=n && a[x]==0){
            v.pb(0);
            k++;
            x++;
        }else if(y!=m && b[y]==0){
            v.pb(0);
            k++;
            y++;
        }else if(x!=n && a[x]<=k){
            v.pb(a[x]);
            x++;
        }else if(y!=m && b[y]<=k){
            v.pb(b[y]);
            y++;
        }else{
            cout<<"-1\n";
            return;
        }
    }
    fori(i,0,v.size(),1){
        cout<<v[i]<<" ";
    }cout<<endl;
}
int main(){
    int t;cin>>t;
    fori(m,0,t,1){
        solve();
    }return 0;
}