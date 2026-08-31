#include <bits/stdc++.h>

using namespace std;
#define vi vector<int>
#define pb push_back
#define sv(v) sort(v.begin(), v.end())
#define rsv(v) sort(v.rbegin(), v.rend())
#define pv(v)        \
    for (auto x : v) \
    cout << x << ' '
#define tv(v)         \
    for (auto &x : v) \
    cin >> x
typedef long long int ll;

void solve()
{
    int k, n, m;
    cin >> k >> n >> m;
    vi a(n), b(m), ans;
    tv(a);
    tv(b);
    int i = 0, j = 0;
    while (i < n && j < m)
    {
        if (a[i] == 0)
        {
            ans.pb(a[i]);
            i++;
            k++;
            continue;
        }
        if (b[j] == 0)
        {
            ans.pb(b[j]);
            j++;
            k++;
            continue;
        }
        if (a[i] <= k)
        {
            ans.pb(a[i]);
            i++;
            continue;
        }
        if (b[j] <= k)
        {
            ans.pb(b[j]);
            j++;
            continue;
        }
        cout << -1 << endl;
        return;
    }
    while (i < n)
    {
        if (a[i] == 0)
        {
            ans.pb(a[i]);
            i++;
            k++;
            continue;
        }
        if (a[i] <= k)
        {
            ans.pb(a[i]);
            i++;
            continue;
        }
        cout << -1 << endl;
        return;
    }
    while (j < m)
    {

        if (b[j] == 0)
        {
            ans.pb(b[j]);
            j++;
            k++;
            continue;
        }
        if (b[j] <= k)
        {
            ans.pb(b[j]);
            j++;
            continue;
        }
        cout << -1 << endl;
        return;
    }
    pv(ans);
    cout << endl;
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int testCase;
    cin >> testCase;
    while (testCase--)
    {
        solve();
    }
    return 0;
}