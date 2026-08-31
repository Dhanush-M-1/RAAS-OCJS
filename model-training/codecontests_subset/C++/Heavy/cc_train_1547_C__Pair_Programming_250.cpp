#include<bits/stdc++.h>
#define ll long long
#define ull unsigned long long
#define pll pll<ll,ll>
#define vpll vector< pll >
#define vvi vector<vector<int> > 
#define vi vector<int> 
#define vb vector<bool>
#define vll vector<ll> 
#define pb push_back
#define m_p make_pair
#define rep(i,a,b) for(ll (i) = (a); (i)<(b); (i)++)
#define rrep(i,a,b) for(ll (i)=(a); (i) >= (b) ; (i)--)
#define all(v) (v).begin(),(v).end()
#define ff first
#define ss second
#define endl "\n"
#define nl cout<<"\n"
#define in(a,n) for(ll i=0;i<(n);i++) cin>>(a)[i]
#define print(a) for(auto &it:a) cout<<it<<" "
template<typename T,typename T1>T amax(T a,T1 b){if(b>a)a=b;return a;}
template<typename T,typename T1>T amin(T a,T1 b){if(b<a)a=b;return a;}
using namespace std;
int mod=1e9+7;


int main() {  
    
    int t;
    cin>>t;
    while(t--) {
        int k,n,m,ans=0;
        cin>>k>>n>>m;
        vi a(n),b(m),c(n+m);
        in(a,n);
        in(b,m);
        int i=0,j=0,p=0;
        while(p<n+m) {
            if(a[i]==0&&i<n) {
                c[p++]=0;
                i++;
                k++;
            }
            else if(b[j]==0&&j<m) {
                c[p++]=0;
                j++;
                k++;
            }
            else if((a[i]<b[j]&&i<n&&j<m)||(j==m&&i<n)) {
                if(a[i]>k) {
                    ans=1;
                    break;
                }
                c[p++]=a[i++];
            }
            else if((a[i]>=b[j]&&i<n&&j<m)||(i==n&&j<m)) {
                if(b[j]>k) {
                    ans=1;
                    break;
                }
                c[p++]=b[j++];
            }
        }
        if(ans) cout<<"-1";
        else print(c);
        nl;
    }
    
}   