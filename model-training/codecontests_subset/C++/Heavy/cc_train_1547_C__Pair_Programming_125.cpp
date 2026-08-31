#include <bits/stdc++.h>
#define int long long
#define boost ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL)

using namespace std;

#define MOD         1000000007
#define nline       '\n'        
#define pb          push_back
#define mp          make_pair
#define fi          first
#define se          second
#define yes         cout<<"YES\n"
#define no          cout<<"NO\n"
#define vi          vector<int>
#define pii         pair<int,int>
#define sz(v)       v.size()
#define lcm(a,b)    (a*b)/(__gcd(a,b))
#define deb(x)      cout<<#x<<" = "<<x<<endl;
#define deb2(x,y)   cout<<#x<<" = "<<x<<' '<<#y<<" = "<<y<<endl;
#define deb3(x,y,z) cout<<#x<<" = "<<x<<' '<<#y<<" = "<<y<<' '<<#z<<" = "<<z<<endl;
#define PR(a,n)     cout<<#a<<" = ";for(int _=0;_<n;_++)cout<<a[_]<<' ';cout<<endl;
#define all(v)      v.begin(),v.end()
#define sortv(v)    sort(all(v));
#define sortrev(v)  sort(all(v),greater<int>())
#define maxHeap     priority_queue<int>
#define minHeap     priority_queue<int, vector<int>, greater<int>>

int pow(int a, int b, int m){
    int ans = 1;
    while(b){
        if (b&1) ans = (ans*a) % m;
        b /= 2;
        a = (a*a) % m;
    }
    return ans;
}

int SumOfDigits(int x)
{
    if (x < 0)return -1;
    int s = 0;
    while(x)
    {
        s += x%10;
        x /= 10;
    }
 
    return s;
}

//lower_bound = first element >= val, end otherwise
//upper_bound = first element > val, end otherwise
//remember 2 pointer , binary search , bits method
//always look for the edges i.e max value ad min value possible

inline void solve()
{
    int k,n,m;
    cin>>k>>n>>m;
    int a[n],b[m];
    int cnt1 = 0,cnt2=0;
    vi x,y;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    for(int i=0;i<m;i++)
    {
        cin>>b[i];
    }
    vi ans;
    int i=0,j=0;
    int total = k;
    while(1)
    {
        if(sz(ans)==n+m)
        break;
        if(a[i]==0 && i<n)
        {
            ans.pb(0);
            total++;
            i++;
            continue;
        }
        else if(b[j]==0 && j<m)
        {
            ans.pb(0);
            total++;
            j++;
            continue;
        }
        if(( a[i]<b[j] && (i<n && j<m) ) || (i<n && j>=m))
        {
            if(total>=a[i])
            {
                ans.pb(a[i]);
                i++;
            }
            else 
            {
                cout<<-1<<nline;
                return;
            }
        }
        else if( (a[i]>=b[j] && (j<m && i<n)) || (j<m && i>=n) )
        {
            if(total>=b[j])
            {
                ans.pb(b[j]);
                j++;
            }
            else 
            {
                cout<<-1<<nline;
                return;
            }
        }
    }
    if(sz(ans)==n+m)
    {
        for(auto x:ans)
        cout<<x<<' ';
        cout<<nline;
    }
    else 
    cout<<-1<<nline;

    return;
}

signed main()
{
    boost;
    int t=1;
    cin>>t;
    for(int tt=1;tt<=t;tt++)
    {
        // cout<<"Case #"<<tt<<": ";
        solve();
    }
    return 0;
}
