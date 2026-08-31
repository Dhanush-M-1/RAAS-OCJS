#include <bits/stdc++.h>
using namespace std;
int64_t mod = 1e9 + 7;
int64_t mod1 = 1e9 + 5;
int64_t power(int64_t a, int64_t b) {
  if (b == 0)
    return 1;
  else if (b % 2 == 0)
    return power(((((a) % mod) * ((a) % mod)) % mod), b / 2) % mod;
  else
    return (((a) % mod) *
            (power(((((a) % mod) * ((a) % mod)) % mod), b / 2) % mod)) %
           mod;
}
inline int64_t inverse(int64_t a, int64_t md) {
  a %= md;
  if (a < 0) a += md;
  int64_t b = md, u = 0, v = 1;
  while (a) {
    int64_t t = b / a;
    b -= t * a;
    swap(a, b);
    u -= t * v;
    swap(u, v);
  }
  assert(b == 1);
  if (u < 0) u += md;
  return u;
}
const int64_t ce = 1e9 + 7;
int64_t fast_mod(int64_t input) { return input < ce ? input : input % ce; }
int64_t b[100001];
int64_t a[100001];
int64_t cost[100001];
int64_t dp[100001];
vector<int64_t> v[100001];
int64_t ch = 1e17 + 100;
void dfs(int64_t u, int64_t par) {
  int64_t sum = b[u];
  for (auto i : v[u])
    if (i == par)
      continue;
    else {
      dfs(i, u);
      int64_t f = dp[i];
      int64_t req = a[i] - dp[i];
      if (abs(req) > ch) {
        cout << "NO";
        exit(0);
      }
      if (req < 0)
        sum += abs(req);
      else {
        if ((sum + ch + cost[i] - 1) / cost[i] <= req) {
          cout << "NO";
          exit(0);
        }
        sum -= cost[i] * req;
      }
    }
  dp[u] = sum;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int64_t n;
  cin >> n;
  for (int64_t i = 1; i <= n; i++) cin >> b[i];
  for (int64_t i = 1; i <= n; i++) cin >> a[i];
  for (int64_t i = 1; i <= n - 1; i++) {
    int64_t u;
    cin >> u;
    v[u].push_back(i + 1);
    cin >> cost[i + 1];
  }
  dfs(1, 0);
  if (dp[1] >= a[1])
    cout << "YES";
  else
    cout << "NO";
}
