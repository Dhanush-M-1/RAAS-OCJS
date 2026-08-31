#include<bits/stdc++.h>
using namespace std;
#define endl ("\n")
#define mp make_pair
#define fi first
#define se second
#define pb push_back 
#define ll long long
#define llu long long unsigned
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define inpotp freopen("input.txt", "r", stdin);     freopen("output.txt", "w", stdout);
#define fr(i,n) for(int i=0;i<n;i++)
#define fr1(i,n) for(int i=1;i<=n;i++)
#define rfr(i,n) for(int i=n-1;i>=0;i--)
#define all(x) x.begin(), x.end()
#define clr(x) memset(x, 0, sizeof(x))
#define sortall(x) sort(all(x))
#define tr(it, a) for(auto it = a.begin(); it != a.end(); it++)
#define PI 3.1415926535897932384626
#define prdb(x) cout << fixed << setprecision(10) << x
#define sc(a) scanf("%d",&a)
#define pf(a) printf("%d",a)
#define cs(a) cout<<a<<' '
#define cn(a) cout<<a<<'\n'
#define ub(a,v) upper_bound(a.begin(), a.end(), v)
#define lb(a,v) lower_bound(a.begin(), a.end(), v)

int main()
{
    fast
    int t=1;
    cin>>t;
    while(t--){
        ll n,m,a;
        cin>>n>>m;
        ll arr[n+1];
        fr1(i,n)cin>>arr[i];
        arr[0]=0;
        fr1(i,n)arr[i]+=arr[i-1];
        ll mx[n+1];
        mx[1]=arr[1];
        for(int i=2;i<=n;i++)mx[i]=max(mx[i-1],arr[i]);
        while(m--){
            cin>>a;
            if(a<=arr[1]){cout<<"0 "; continue;}
            if(a>mx[n] && arr[n]<=0){cout<<"-1 "; continue;}
            ll ans=-1;
            if(a>mx[n] && arr[n]>0){
                ans+=((a-mx[n])/arr[n])*n;
                a=a-( ((a-mx[n])/arr[n])*arr[n] );
            }
            
            // cout<<ans<<" "<<a<<endl;
            
            int l=0,r=n,mid;
            if(a>0){
                l=0; r=n;
                while(r-l>1){
                    mid=(l+r)/2;
                    if(mx[mid]>=a)r=mid;
                    else l=mid;
                }
                ans+=r;
                a=a-arr[r];
            }
            
            // cout<<ans<<" "<<a<<endl;
            
            if(a>0){
                l=0; r=n;
                while(r-l>1){
                    mid=(l+r)/2;
                    if(mx[mid]>=a)r=mid;
                    else l=mid;
                }
                ans+=r;
                a=a-arr[r];
            }
            cout<<ans<<" ";
        }
        cout<<endl;
    }
    
    return 0;
    
}