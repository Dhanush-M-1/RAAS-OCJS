#include <bits/stdc++.h>
using namespace std;
#define ios ios_base::sync_with_stdio(false);cin.tie(NULL);
#define ll long long int
#define pb push_back
#define max3(a,b,c) max(max((a),(b)),(c))
#define max4(a,b,c,d) max(max((a),(b)),max((c),(d)))
#define min3(a,b,c) min(min((a),(b)),(c))
#define min4(a,b,c,d) min(min((a),(b)),min((c),(d)))
#define all(v) (v).begin(),(v).end()
#define endl "\n"
#define pii pair<int,int>
ll mod =1e9 +7;
ll power(ll x,int y, int p)
{
    ll res = 1;
    x = x % p;
    while (y > 0)
    {
        if (y & 1)
            res = (res * x) % p;
        y = y >> 1;
        x = (x * x) % p;
    }
    return res;
}
ll modInverse(ll n,int p)
{
    return power(n, p - 2, p);
}
ll ncr(ll n,int r, int p)       //Combination
{
    if (n < r)
        return 0;
    if (r == 0)
        return 1;
    unsigned long long fac[n + 1];
    fac[0] = 1;
    for (int i = 1; i <= n; i++)
        fac[i] = (fac[i - 1] * i) % p;
    return (fac[n] * modInverse(fac[r], p) % p
            * modInverse(fac[n - r], p) % p)% p;
}
int gcd(int a,int b)                  //gcd function
{
    if(b==0)
    return a;
    else return gcd(b,a%b);
}
ll _ceil(ll a,ll b)              //ceil
{
    if(a%b==0) return a/b;
    else return a/b+1;
}
int _pow(int a, int b){
    if(!b)
        return 1;
    int temp = _pow(a, b / 2);
    temp = (temp * temp);
    if(b % 2)
        return (a * temp);
    return temp;
}
bool isPrime(int n)              //Check Prime
{
    if (n <= 1)  return false;
    if (n <= 3)  return true;
    if (n%2 == 0 || n%3 == 0) return false;

    for (int i=5; i*i<=n; i=i+6)
        if (n%i == 0 || n%(i+2) == 0)
           return false;
    return true;
}
int mx = 2e5 +5;
int main()
{
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif
    ios
    vector<ll> dp(mx,2);
    dp[9]=3;
    for(int i=10;i<mx;i++)
    {
        dp[i] = (dp[i-9]%mod+dp[i-10]%mod)%mod;
    }
    int t;
    cin>>t;
    while(t--)
    {
        int n,k;
        cin>>n>>k;
        ll sum =0;
        while(n>0)
        {
            int d = n%10;
            if(d+k<10)
            sum++;
            else
            {
                sum+=dp[d+k-10]%mod;
            }
            sum%=mod;
            n/=10;
        }
        cout<<sum<<endl;
    }
}
