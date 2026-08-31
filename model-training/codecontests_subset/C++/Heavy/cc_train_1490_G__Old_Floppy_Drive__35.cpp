#include <bits/stdc++.h>
using namespace std;
#define int long long
int get(vector<int> &a, int n, int k)
{
    int low = 0, high = n - 1, ans = -1 ;
    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (a[mid] >= k)
        {
            ans = mid + 1;
            high = mid - 1;
        }
        else
            low = mid + 1;
    }
    return ans;
}
void solve()
{
    int n, m, sum = 0;
    cin >> n >> m;
    vector<int> a(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> a[i];
        sum += a[i];
        a[i] = sum;
        if (i)
            a[i] = max(a[i], a[i - 1]);
    }
    for (int i = 0; i < m; ++i)
    {
        int k;
        cin >> k;
        int ans = get(a, n, k);
        if (ans != -1)
            cout << ans - 1 << ' ';
        else
        {
            if (sum <= 0)
                cout << -1 << ' ';
            else
            {
                int low = 1, high = k / sum + (k % sum), ans = n * k;
                while (low <= high)
                {
                    int mid = (low + high) / 2;
                    int x = get(a, n, k - mid * sum);
                    if (x != -1)
                    {
                        ans = min(mid * n + x, ans);
                        high = mid - 1;
                    }
                    else
                        low = mid + 1;
                }
                cout << ans - 1 << ' ';
            }
        }
        
    }
    cout << '\n';
}
int32_t main(int32_t argc, char const *argv[])
{
    int t;
    cin >> t;
    while (t --)
        solve();
    return 0;
}