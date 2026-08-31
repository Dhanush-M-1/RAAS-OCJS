#include <bits/stdc++.h>
using namespace std;
long long fac[2000005];
void pre() {
  fac[0] = 1;
  fac[1] = 1;
  for (int i = 2; i < 200005; i++) fac[i] = (i * fac[i - 1]) % 1000000007;
}
long long power(long long a, long long b) {
  long long res = 1;
  while (b) {
    if (b & 1) res = (res * a) % 1000000007;
    a = (a * a) % 1000000007;
    b = b / 2;
  }
  return res % 1000000007;
}
long long ncr(long long n, long long r) {
  return ((fac[n] * power(fac[r], 1000000007 - 2)) % 1000000007 *
          power(fac[n - r], 1000000007 - 2)) %
         1000000007;
}
long long visa[200005];
long long visb[200005];
vector<long long> adj[2000005];
long long a, b;
void dfs1(long long s) {
  visa[s] = 1;
  for (auto it : adj[s])
    if (!visa[it] && it != b) dfs1(it);
}
void dfs2(long long s) {
  visb[s] = 1;
  for (auto it : adj[s])
    if (!visb[it] && it != a) dfs2(it);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    map<long long, long long> mp1;
    map<long long, long long> mp2;
    long long n, m;
    cin >> n >> m >> a >> b;
    for (int i = 0; i < m; i++) {
      long long a1, b1;
      cin >> a1 >> b1;
      adj[a1].push_back(b1);
      adj[b1].push_back(a1);
    }
    dfs1(a);
    dfs2(b);
    long long c1 = 0, c2 = 0;
    for (int i = 1; i <= n; i++)
      if (visa[i] && !visb[i] && i != a && i != b) c1++;
    for (int i = 1; i <= n; i++)
      if (visb[i] && i != b && i != a && !visa[i]) c2++;
    long long ans = c1 * c2;
    cout << ans << endl;
    for (int i = 1; i <= n; i++) {
      adj[i].clear();
      visa[i] = 0;
      visb[i] = 0;
    }
  }
}
