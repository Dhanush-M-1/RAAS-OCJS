#include <bits/stdc++.h>
//#include <ext/pb_ds/assoc_container.hpp>
//#include <ext/pb_ds/tree_policy.hpp>

//#pragma GCC optimize("unroll-loops")
//#pragma GCC optimize("-O3")
//#pragma GCC optimize("Ofast")

#define N 205000
#define NN 10000005
#define PB push_back
#define M ll(1e9 + 7)
#define all(x) x.begin(), x.end()
#define sz(x) int(x.size())
#define pri(x) cout << x << endl
#define endl '\n'
#define _ << " " <<
#define F first
#define S second

using namespace std;
//using namespace __gnu_pbds;

//typedef tree <int, null_type, less <int>, rb_tree_tag, tree_order_statistics_node_update> oredered_set;

typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;
typedef short int si;

int main()
{
    ios_base::sync_with_stdio(0); istream::sync_with_stdio(0); cin.tie(0); cout.tie(0);

//    freopen("1.in", "r", stdin);

    int q;

    cin >> q;

    for (; q > 0; q--)
    {
        int n;

        cin >> n;

        int a[n], tg[n];

        for (int i = 0; i < n; i++)
            cin >> tg[i];

        for (int i = 0; i < n; i++)
            cin >> a[i];

        ll dp[n];

        for (int i = 0; i < n; i++)
            dp[i] = 0;

        for (int i = 1; i < n; i++)
            for (int j = i - 1; j >= 0; j--)
                if (tg[i] != tg[j])
                    {
                        ll vl = dp[j];

                        dp[j] = max(dp[j], dp[i] + abs(a[j] - a[i]));

                        dp[i] = max(dp[i], vl + abs(a[j] - a[i]));
                    }

        ll ans = 0;

        for (int i = 0; i < n; i++)
            ans = max(ans, dp[i]);

        pri(ans);
    }
}
