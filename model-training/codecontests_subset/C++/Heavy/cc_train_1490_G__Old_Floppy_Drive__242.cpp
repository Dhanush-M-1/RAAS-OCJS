#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define all(x) x.begin(), x.end()
#define pb push_back
#define mp make_pair
#define ps push
#define in insert
#define f first
#define s second
#define ca(v) for(auto i:v) cout<<i<<" ";
#define nl cout<<"\n"
#define gcd(a, b) __gcd(a, b)
#define lcm(a, b) (a*b/gcd(a, b))
int xm[4] = {-1, 1, 0, 0};
int ym[4] = {0, 0, -1, 1};
const int MOD = 1e9 + 7;
const int MAXN = 5e5 + 5;
const ll POW = 9973;

int main()
{
    ios_base::sync_with_stdio(0); cin.tie(0);
    int t;
    cin>>t;
    while(t--){
        int n, m;
        cin>>n>>m;
        ll ar[n];
        vector<ll> sm(n, 0);
        vector<ll> mx(n, 0);
        for(int i=0; i<n; i++) cin>>ar[i];
        for(int i=0; i<n; i++){
            if(i) {
                sm[i] = sm[i-1];
                mx[i] = mx[i-1];
            }
            sm[i] += ar[i];
            mx[i] = max(mx[i], sm[i]);
        }
        for(int i=0; i<m; i++){
            ll x; cin>>x;
            ll ans = -1;
            if(sm[n-1]>0 && (x-mx[n-1])>0){
               ans += n * (((x-mx[n-1]+sm[n-1]-1)/sm[n-1]));
                x -= sm[n-1] * ((x-mx[n-1]+sm[n-1]-1)/sm[n-1]); 
            }
            if(x==0) {cout<<ans<<" "; continue;}
            auto it = lower_bound(all(mx), x);
            if(it==mx.end()) cout<<-1<<" ";
            else cout<<ans + (it - mx.begin())+1<<" ";
            
        }
        nl;
    }
}

