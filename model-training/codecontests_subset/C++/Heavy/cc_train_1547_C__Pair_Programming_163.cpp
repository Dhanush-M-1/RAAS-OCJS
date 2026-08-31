#include <bits/stdc++.h>
//#pragma GCC optimize("O3")
#define ll long long
#define ull unsigned long long
#define pii pair<int, int>
#define FASTIO cin.tie(0); cout.tie(0); ios_base::sync_with_stdio(0);
#define FILES freopen("in", "r", stdin); freopen("out", "w", stdout);
#define vec vector<int>
using namespace std;

void tc() {
    int k, n, m;
    cin >> k >> n >> m;
    int a[n + 1], b[m + 1];
    for(int i = 1; i <= n; i++)
        cin >> a[i];
    for(int i = 1; i <= m; i++)
        cin >> b[i];
    vector <int> v(1);
    int i = 1, j = 1;
 
    while (i<=n && j <=m)
    {
        if (a[i] < b[j])
            v.push_back(a[i++]);
        else
            v.push_back(b[j++]);
    }
    while (i <= n)
        v.push_back(a[i++]);
    while (j <= m)
        v.push_back(b[j++]);

    int cnt = k;
    for(int i = 1; i < v.size(); i++)
        if(v[i] != 0 && v[i] > cnt) {
            cout << -1 << '\n';
            return;
        } else if(v[i] == 0)
            cnt++;
    for(int i = 1; i < v.size(); i++)
        cout << v[i] << ' ';
    cout << '\n';
}

signed main() {
    int t;
    cin >> t;
    while(t--)
        tc();
    return 0;
}