#include <bits/stdc++.h>
using namespace std;
#define INF 10000000000000LL
typedef long long int ll;
typedef pair<ll,ll> ii;
typedef pair<ii,ll> iii;
typedef pair<ii,ii> ii2;
typedef vector<ll> vi;
typedef vector<ii> vii;
#define getbit(n,i) (((n)&(1LL<<(i)))!=0)
#define setbit0(n,i) ((n)&(~(1LL<<(i))))
#define setbit1(n,i) ((n)|(1LL<<(i)))
#define lastone(n) ((n)&(-(n)))
#define read freopen("debug//in.txt","r",stdin)
#define write freopen("debug//out.txt","w",stdout)
#define DBG(a) cerr<<#a<<" ->->->-> "<<a<<"\n"
#define fi first
#define se second
#define PI (acos(-1))
#define fastread ios::sync_with_stdio(false);cin.tie(NULL)
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
#define mod (1000000007)
#define asz 500005
template<class T,class V> ostream& operator<<(ostream &s,pair<T,V> a)
{
    s<<a.fi<<' '<<a.se;
    return s;
}
int p[asz];

int fnd(int i){
    if(p[i] == i)return i;
    return p[i] = fnd(p[i]);
}
int main()
{
    fastread;
#ifdef FILE_IO2
    read;
    write;
#endif
    int T=1;
//    cin>>T;
    for(int qq=1;qq<=T; qq++){
        int n,m;
        cin>>n>>m;
        for(int i=1;i<=m+1;i++)p[i] = i;
        vii v(n);
        for(int i=0;i<n;i++){
            int k;
            cin>>k;
            cin>>v[i].fi;
            if(k == 2)cin>>v[i].se;
            else v[i].se = m+1;
            if(v[i].fi>v[i].se)swap(v[i].fi,v[i].se);
        }
        vi ans;
        ll pw = 1;
        for(int i=0; i<n; i++){
            int u = fnd(v[i].fi);
            int u2 = fnd(v[i].se);
            if(u!=u2){
                p[u2] = u;
                ans.push_back(i+1);
                pw = pw*2%mod;
            }
        }
        cout<<pw<<' '<<ans.size()<<endl;
        for(auto x:ans)cout<<x<<' ';
        cout<<endl;
    }
}
