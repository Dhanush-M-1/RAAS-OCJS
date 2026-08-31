#include<bits/stdc++.h>
using namespace std;

#define ll long long int
#define pb push_back
#define mp make_pair
#define all(x) x.begin(), x.end()
#define fr first
#define sc second
#define pii pair<ll,ll>
#define vi  vector<ll>
#define vvi vector<vector<ll>>
#define rep(i,a,b) for(ll i=a;i<b;i++)

// const ll mod = 1000000007;
const ll mod = 998244353;

ll z = 1000000000;
#define PI 3.14159265

int gcd(int a, int b)
{
    if (!a)
        return b;
    return gcd(b % a, a);
}

ll powe(ll x, ll y)
{
    if (y == 0) return 1;
    if (y == 1) return x;

    ll t = powe(x, y / 2);
    t = (t * t) % mod;

    if (y % 2 == 1) t = (t * x) % mod;

    return t;
}

ll binomialCoeff(ll n, ll k)
{
    ll C[n + 1][k + 1];
    ll i, j;

    for (i = 0; i <= n; i++)
    {
        for (j = 0; j <= min(i, k); j++)
        {
            if (j == 0 || j == i)
                C[i][j] = 1;
            else
                C[i][j] = C[i - 1][j - 1] +
                          C[i - 1][j];
        }
    }

    return C[n][k];
}


// bool checkSubset(vi &nums, int sum)
// {
//     vector<vector<bool>> dp(nums.size()+1, vector<bool> (sum+1));

//     for(int i=0;i<=nums.size();i++)
//         dp[i][0] = true;

//     for(int i=0;i<= sums;i++)
//         dp[0][i] = false;


//     for(int i=1;i<=nums.size();i++)
//     {
//         for(int j=1;j<=sums;j++)
//         {
//             if(j<nums[i-1])
//                 dp[i][j] = dp[i-1][j];
//             else
//                 dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
//         }
//     }

//     return dp[nums.size()][sum];
// }

vi primeFactors(ll n)
{
    // Print the number of 2s that divide n

    vi res;
    while (n % 2 == 0)
    {
        res.pb(2);
        n = n / 2;
    }

    // n must be odd at this point. So we can skip
    // one element (Note i = i +2)
    for (int i = 3; i <= sqrt(n); i = i + 2)
    {
        // While i divides n, print i and divide n
        while (n % i == 0)
        {
            res.pb(i);
            n = n / i;
        }
    }

    // This condition is to handle the case when n
    // is a prime number greater than 2
    if (n > 2)
        return {n};
    return res;
}

void precal()
{
    int invFact[400005], fact[400005], intermediate[400005];
    invFact[1] = invFact[0] = 1;
    fact[1] = fact[0] = 1;
    intermediate[1] = intermediate[0] = 1;

    rep(i, 2, 200001)
    {
        intermediate[i] = intermediate[mod % i] * (mod - mod / i) % mod;
    }
    rep(i, 2, 200001)
    {
        fact[i] = (fact[i - 1] * i) % mod;
        invFact[i] = (intermediate[i] * invFact[i - 1]) % mod;
    }
}



// ll dfs(vector<int> &x, vector<bool> &vis, int i)
// {
//     ll len = 1;
//     while (x[i] != 0)
//     {
//         if (vis[x[i]] == 1)
//             return len + 1;
//         vis[x[i]] = 1;
//         i = x[i];
//         len++;
//     }
//     return len;
// }

int dfs(vector<vector<int>> &graph, int u, vector<vector<int>> &reducedGraph)
{
    if (graph[u].size() == 0)
        return u;
    if (graph[u].size() == 1)
    {
        int child = dfs(graph, graph[u][0], reducedGraph);
        reducedGraph[u].pb(child);
        return child;
    }

    for (int i = 0; i < graph[u].size(); i++)
    {
        int child = dfs(graph, graph[u][i], reducedGraph);
        reducedGraph[u].pb(child);
    }
    return u;
}

ll calc(vector<vector<int>> &reducedGraph, int u, int w, map<pair<int, int>, int> &mp)
{
    if (mp.find({u, w}) != mp.end())
        return mp[ {u, w}];

    int childs = reducedGraph[u].size();
    if ( childs == 0)
        return 0;
    if (w % childs != 0)
        return w;

    ll val = 0;

    for (int i = 0; i < reducedGraph[u].size(); i++)
    {
        val += calc(reducedGraph, reducedGraph[u][i], w / childs, mp);
    }
    return mp[ {u, w}] = val;
}

vector<bool> SieveOfEratosthenes(int n)
{
    vector<bool> prime(n + 1, true);

    for (int p = 2; p * p <= n; p++)
    {
        if (prime[p] == true)
        {
            for (int i = p * p; i <= n; i += p)
                prime[i] = false;
        }
    }
    prime[1] = false;
    return prime;
}

int count(int a, int b)
{
    int c = 0;
    while (a * 2 < b)
    {
        a = a * 2;
        c++;
    }
    return c;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);


#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int test = 1;
    cin >> test;
    while (test--)
    {
        ll n, m;
        cin >> n >> m;

        vector<ll> a(n), sum(n, 0);
        ll maxa = INT_MIN;
        rep(i, 0, n)
        {
            cin >> a[i];

        }

        sum[0] = a[0];
        maxa = max(maxa, a[0]);
        rep(i, 1, n)
        {
            sum[i] += (sum[i - 1] + a[i]);
            maxa = max(maxa, sum[i]);
        }

        vector<ll> pref;

        pref.pb(sum[0]);
        ll pre = sum[0];
        map<ll, ll> mp;
        mp[sum[0]] = 0;
        rep(i, 1, n)
        {
            if (sum[i] > pre)
            {
                pref.pb(sum[i]);
                pre = sum[i];
                mp[sum[i]] = i;
            }
        }

        while (m--)
        {
            ll x;
            cin >> x;

            ll ans = 0;
            if (x > maxa && sum[n - 1] <= 0)
                cout << "-1 ";
            else
            {
                if (x > maxa)
                {
                    ll z = (x - maxa) / sum[n - 1];
                    while ((z * sum[n - 1]) + maxa < x)
                        z++;

                    x = x - (z * sum[n - 1]);
                    ans += (z * n);
                    // cout << "hi";
                }

                ll ind = (lower_bound(all(pref), x) - pref.begin());

                cout << ans + mp[pref[ind]] << " ";
            }

        }
        cout << "\n";
    }
    return 0;
}



