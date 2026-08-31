#include <bits/stdc++.h>
using namespace std;
const long long N = 5e5 + 10;
long long n, m, a[N], p[N], tmp1, tmp2, ans, t, Q;
bool mark[N], pass[N];
vector<long long> adj[N];
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    p[a[i]] = i;
  }
  for (long long i = 1; i <= m; i++) {
    cin >> tmp1 >> tmp2;
    if (tmp2 == a[n]) {
      mark[tmp1] = true;
    } else if (p[tmp1] < p[tmp2]) {
      adj[tmp1].push_back(tmp2);
    }
  }
  for (long long i = n - 1; i >= 1; i--) {
    if (mark[a[i]] == true) {
      long long c = 0, d = 0;
      for (auto x : adj[a[i]]) {
        if (mark[x] == true && pass[x] != true) {
          d++;
        } else if (mark[x] != true) {
          c++;
        }
      }
      if (c == t && Q == d) {
        pass[a[i]] = true;
        ans++;
      } else {
        Q++;
      }
    } else {
      t++;
    }
  }
  cout << ans;
  return 0;
}
