#include<bits/stdc++.h>
#define read(arr, n) vector<int> arr(n); for(int i=0; i<n; i++)  cin>>arr[i];
#define fastio ios_base::sync_with_stdio(0);    cin.tie(0); cout.tie(0);
#define fr(i, m, n)   for(int i=m;i<n;i++)
#define frr(i, a, b)    for(int i=a; i>b; i--)
#define w(tt) int tt;   cin>>tt; while(tt--)
#define w1(tt)  if(true)
#define vi(ty) vector<ty> 
#define vvi(ty) vector<vector<ty>> 
#define umap(ty) unordered_map<ty, ty> 
#define umapp(ty, tyy) unordered_map<ty, tyy>
#define pii pair<int, int> 
#define ll long long int
#define yes cout<<"YES"<<endl
#define no cout<<"NO"<<endl
#define len(x) x.size()
#define pb push_back
#define F first
#define S second
#define I insert
#define mod 1000000007
using namespace std;

void file(){
    #ifndef ONTLINE_JUDGE
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif
}

void solve()    // return 1 -> it did it's purpose properly.
{
        ll n, q, cnt = 0, maxi = INT_MIN, prev = -1;       cin>>n>>q;
        map<ll, ll> hash;

        fr(i, 0, n)
        {
                ll x;   cin>>x; cnt += x;

                if(cnt >= 0 && cnt > prev)
                        {hash[cnt] = i;      prev = cnt;}
        }
        maxi = prev;

        ll query[q];
        fr(i, 0, q)     cin>>query[i];

        fr(i, 0, q)
        {
                ll x = query[i];
                auto it = hash.lower_bound(x);

                if(it != hash.end())
                {
                        //cout << "&";
                        cout << it->S <<" ";
                }
                else if( it == hash.end() && cnt > 0)
                {
                        ll temp = x - maxi;
                        ll t = ceil(temp/(cnt*1.0));
                        temp = x - t*cnt;
                        it = hash.lower_bound(temp);
                        //if(it==hash.end())
                        //        cout<<"^"<<it->S<<"^";
                        cout << it->S + t*n << " ";
                }
                else
                        {cout<<-1<<" ";}
                
        }
        cout<<endl;
 
}

int main(){
    fastio //file();
    w(tt){
        solve();
    }
}

// -1 -1
// 1 1