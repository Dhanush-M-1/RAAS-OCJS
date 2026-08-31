#include <bits/stdc++.h>
using namespace std;
#define int long long
#define pi (3.141592653589)
#define mod 1000000007
#define int long long
#define float double
#define pb push_back
#define mp make_pair
#define ff first
#define ss second
#define all(c) c.begin(), c.end()
#define min3(a, b, c) min(c, min(a, b))
#define min4(a, b, c, d) min(d, min(c, min(a, b)))
#define rrep(i, n) for (int i = n - 1; i >= 0; i--)
#define rep(i, n) for (int i = 0; i < n; i++)
#define fast ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

bool isPrime(int n)
{
    if (n == 1)
        return false;
    if (n == 2)
        return true;
    for (int i = 2; i * i <= n; i++)
    {
        if (n % i == 0)
            return false;
    }
    return true;
}

int32_t main()
{
    fast int t;
    cin >> t;
    while (t--)
    {
        int k, n, m;
        std::cin >> k >> n >> m;

        vector<int> a(n), b(m);
        for (int i = 0; i < n; i++)
            std::cin >> a[i];
        for (int i = 0; i < m; i++)
            std::cin >> b[i];

        int pos1 = 0, pos2 = 0;
        vector<int> res;
        bool ok = true;
        while (pos1 != n || pos2 != m)
        {
            if (pos1 != n && a[pos1] == 0)
            {
                res.pb(0);
                k++;
                pos1++;
            }
            else if (pos2 != m && b[pos2] == 0)
            {
                res.pb(0);
                k++;
                pos2++;
            }
            else if (pos1 != n && a[pos1] <= k)
            {
                res.pb(a[pos1++]);
            }
            else if (pos2 != m && b[pos2] <= k)
            {
                res.pb(b[pos2++]);
            }
            else
            {
                std::cout << -1 << '\n';
                ok = false;
                break;
            }
        }

        if (ok)
        {
            for (int m : res)
                std::cout << m << ' ';
            std::cout << std::endl;
        }
    }

    return 0;
}
