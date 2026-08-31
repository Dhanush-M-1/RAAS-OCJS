#include<bits/stdc++.h>
using namespace std;

#define Fast            ios_base::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
#define fWrite          freopen ("out.txt","w",stdout);
#define TC              int t;cin >> t;FOR(tc,1,t)
#define LL              long long
#define ULL             unsigned long long
#define ff              first
#define ss              second
#define pb              push_back
#define pii             pair<LL,int>
#define all(a)          a.begin(),a.end()
#define MEM(a,x)        memset(a,x,sizeof(a))
#define FOR(i,a,b)      for(int i=a;i<=b;i++)
#define ROF(i,a,b)      for(int i=a;i>=b;i--)
#define REP(i,b)        for(int i=0;i<b;i++)

const int N = 2e5 + 5;
int n,m;
int tree[4*N];
LL arr[N];
vector<pii>csum;

inline void build(int L,int R,int pos)
{
    if(L==R)
    {
        tree[pos] = csum[L].ss;
        return;
    }
    int mid=(L+R)/2;
    build(L,mid,pos*2+1);
    build(mid+1,R,pos*2+2);
    tree[pos]=min(tree[pos*2+1],tree[pos*2+2]);
    return;
}

inline int query(int ql,int qr,int L,int R,int pos)
{
    if(ql>R or qr<L)
        return 1e9;
    else if(ql<=L and qr>=R)
        return tree[pos];
    int mid=(L+R)/2;
    int p=query(ql,qr,L,mid,2*pos+1);
    int q=query(ql,qr,mid+1,R,2*pos+2);
    return min(p,q);
}

int call(LL x){
    int idx = lower_bound(all(csum),pii(x,-1)) - csum.begin();
    return query(idx,n-1,0,n-1,0);
}

int main()
{
    Fast
    TC{
        cin >> n >> m;
        LL sum = 0, mx = -1e18;
        csum.clear();

        REP(i,n) {
            cin >> arr[i];
            sum += arr[i];
            csum.pb({sum,i});

            if(sum>mx) {
                mx = sum;
            }
        }
        sort(all(csum));

        REP(i,4*n) tree[i] = 1e8;
        build(0,n-1,0);

        FOR(i,1,m){
            LL x;
            cin >> x;
            if(x<=mx){
                cout << call(x) << ' ';
            }
            else{
                if(sum<=0) cout << -1 << ' ';
                else{
                    LL diff = (x - mx);
                    if(diff%sum==0) diff = (diff/sum);
                    else diff = (diff/sum) + 1;

                    x -= diff * sum;
                    //cout << "=== " << mx << ' ' << sum << ' ' << x << '\n';
                    cout << n * diff + call(x) << ' ';
                }
            }
        }
        cout << '\n';
    }
}
