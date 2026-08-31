#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define ios ios_base::sync_with_stdio(false);cin.tie(NULL);
#define int long long int
#define ii pair<int, int>
#define mp make_pair
#define F first
#define S second
#define all(x) x.begin(), x.end()
#define pb push_back
#define fo(i, n) for(int i=0;i<n;i++)
typedef vector<int> vi;
typedef vector<ll> vll;

void SieveOfEratosthenes(int n)
{
    bool prime[n+1];
    memset(prime, true, sizeof(prime));
    for (int p = 2; p * p <= n; p++)
    {
        if (prime[p] == true)
        {
            for (int i = p * p; i <= n; i += p)
                prime[i] = false;
        }
    }
}

int cl(int n, int a){
    return n/a + ((n%a)!=0);
}

bool isPrime(int n){
    static int i = 2;
    if (n == 0 || n == 1) {
        return false;
    }
    if (n == i)
        return true;
    if (n % i == 0) {
        return false;
    }
    i++;
    return isPrime(n);
}

bool sortbysec(const pair<int,int> &a, const pair<int,int> &b) {
    return (a.second < b.second);
}

void solve(){
    int n;
    cin >> n;
    vi t(n);
    vi s(n);
    fo(i, n) cin >> t[i];
    fo(i, n) cin >> s[i];
    vi dp(n, 0);
    int p = 0;
    for(int j=1;j<n;j++){
        for(int i=j-1;i>=0;i--){
            if (t[i] == t[j]) continue;
            if (s[i]-s[j] >= 0){
                p = s[i]-s[j];
            }
            else{
                p = s[j] - s[i];
            }
            int temp = dp[i];
            dp[i] = max(dp[i], dp[j]+p);
            dp[j] = max(dp[j], temp+p);
        }
    }
    cout << *max_element(all(dp)) << '\n';
}

signed main(){
    ios
    int t;
    cin >> t;
    while(t--){
        solve();
    }
}