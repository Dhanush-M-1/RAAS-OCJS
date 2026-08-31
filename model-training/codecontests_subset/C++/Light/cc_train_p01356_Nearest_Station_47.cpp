#include <bits/stdc++.h>
#define ll long long
#define INF 1000000005
#define MOD 1000000007
#define EPS 1e-10
#define rep(i,n) for(int i=0;i<(int)(n);++i)
#define rrep(i,n) for(int i=(int)(n)-1;i>=0;--i)
#define srep(i,s,t) for(int i=(int)(s);i<(int)(t);++i)
#define each(a,b) for(auto (a): (b))
#define all(v) (v).begin(),(v).end()
#define len(v) (int)(v).size()
#define zip(v) sort(all(v)),v.erase(unique(all(v)),v.end())
#define cmx(x,y) x=max(x,y)
#define cmn(x,y) x=min(x,y)
#define fi first
#define se second
#define pb push_back
#define show(x) cout<<#x<<" = "<<(x)<<endl
#define spair(p) cout<<#p<<": "<<p.fi<<" "<<p.se<<endl
#define svec(v) cout<<#v<<":";rep(kbrni,v.size())cout<<" "<<v[kbrni];cout<<endl
#define sset(s) cout<<#s<<":";each(kbrni,s)cout<<" "<<kbrni;cout<<endl
#define smap(m) cout<<#m<<":";each(kbrni,m)cout<<" {"<<kbrni.first<<":"<<kbrni.second<<"}";cout<<endl

using namespace std;

typedef pair<int,int> P;
typedef pair<ll,ll> pll;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<ll> vl;
typedef vector<vl> vvl;
typedef vector<double> vd;
typedef vector<P> vp;
typedef vector<string> vs;

const int MAX_N = 100005;

ll lpa[40],lpb[40];
double dpa[40],dpb[40];

int main()
{
    cin.tie(0);
    ios::sync_with_stdio(false);
    ll n,m,a,b,p,q;
    cin >> n >> m >> a >> b >> p >> q;
    if(a == 1 && b == 1){
        ll cnt = m/(p+q);
        cout << min(m-min(n,cnt)*(p+q),abs(min(n,cnt+1)*(p+q)-m)) << "\n";
    }else{
        ll cnt = min(n,40LL);
        ll mid = cnt/2;
        lpa[0] = lpb[0] = dpa[0] = dpb[0] = 1;
        rep(i,cnt-1){
            lpa[i+1] = lpa[i] * a;
            lpb[i+1] = lpb[i] * b;
            dpa[i+1] = dpa[i] * a;
            dpb[i+1] = dpb[i] * b;
        }
        vl u,v;
        rep(i,(1 << mid)){
            ll val1 = 0;
            double ch1 = 0;
            rep(j,mid){
                if((i >> j) & 1){
                    val1 += p*lpa[j] + q*lpb[j];
                    ch1 += p*dpa[j] + q*dpb[j];
                }
            }
            if(ch1 <= 2*m){
                u.pb(val1);
            }
        }
        rep(i,(1 << (cnt-mid))){
            ll val2 = 0;
            double ch2 = 0;
            rep(j,cnt-mid){
                if((i >> j) & 1){
                    val2 += p*lpa[mid+j] + q*lpb[mid+j];
                    ch2 += p*dpa[mid+j] + q*dpb[mid+j];
                }
            }
            if(ch2 <= 2*m){
                v.pb(val2);
            }
        }
        // svec(u);
        // svec(v);
        sort(all(v));
        ll mn = (1LL << 60);
        rep(i,len(u)){
            int id = upper_bound(all(v),m-u[i]) - v.begin();
            if(id > 0){
                cmn(mn,m-(u[i]+v[id-1]));
            }
            if(id < len(v)){
                cmn(mn,(u[i]+v[id])-m);
            }
        }
        cout << mn << "\n";
    }
    return 0;
}