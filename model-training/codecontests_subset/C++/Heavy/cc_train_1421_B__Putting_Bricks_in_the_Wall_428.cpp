#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const ll mod = 1e9 + 7;
ll fac[1000001];
void pre() {
  fac[0] = fac[1] = 1;
  for (int i = 2; i <= 1000001; i++) {
    fac[i] = (fac[i - 1] * 1LL * i) % mod;
  }
}
ll binpower(ll a, ll n) {
  ll res = 1;
  while (n) {
    if (n % 2) res = (res * 1LL * a) % mod;
    n /= 2;
    a = (a * 1LL * a) % mod;
  }
  return res;
}
ll nCrmod(ll n, ll r) {
  ll res = fac[n];
  res = (res * 1LL * binpower(fac[r], mod - 2)) % mod;
  res = (res * 1LL * binpower(fac[n - r], mod - 2)) % mod;
  return res;
}
long long ncr(int n, int r) {
  if (r > n - r) r = n - r;
  long long ans = 1;
  int i;
  for (i = 1; i <= r; i++) {
    ans *= n - r + i;
    ans /= i;
  }
  return ans;
}
ll modexp(ll a, ll b, ll m) {
  if (b == 0) return 1;
  if (b % 2 == 0) {
    ll y = modexp(a, b / 2, m);
    return (y * y) % m;
  } else {
    return ((a % m) * modexp(a, b - 1, m)) % m;
  }
}
ll modinv(ll a, ll m) { return modexp(a, m - 2, m); }
void SieveOfEratosthenes(ll n) {
  bool prime[n + 1];
  memset(prime, true, sizeof(prime));
  for (ll p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (ll i = p * p; i <= n; i += p) prime[i] = false;
    }
  }
  for (ll p = 2; p <= n; p++)
    if (prime[p]) cout << p << " ";
}
vector<int> Centroid(vector<int> g[], int n) {
  vector<int> centroid;
  vector<int> sz(n + 1);
  function<void(int, int)> dfs = [&](int u, int prev) {
    sz[u] = 1;
    bool is_centroid = true;
    for (auto v : g[u])
      if (v != prev) {
        dfs(v, u);
        sz[u] += sz[v];
        if (sz[v] > n / 2) is_centroid = false;
      }
    if (n - sz[u] > n / 2) is_centroid = false;
    if (is_centroid) centroid.push_back(u);
  };
  dfs(1, 0);
  return centroid;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char grid[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      string s;
      cin >> s;
      for (int j = 1; j <= n; j++) {
        grid[i][j] = s[j - 1];
      }
    }
    char a = grid[1][2], b = grid[2][1], c = grid[n][n - 1], d = grid[n - 1][n];
    if (a == b) {
      int ans = 0;
      vector<pair<int, int>> v;
      if (a == '0') {
        if (c == '0') {
          ans++;
          v.push_back({n, n - 1});
        }
        if (d == '0') {
          ans++;
          v.push_back({n - 1, n});
        }
      }
      if (a == '1') {
        if (c == '1') {
          ans++;
          v.push_back({n, n - 1});
        }
        if (d == '1') {
          ans++;
          v.push_back({n - 1, n});
        }
      }
      cout << ans << "\n";
      for (auto x : v) {
        cout << x.first << " " << x.second << "\n";
      }
    } else {
      int ans = 0;
      vector<pair<int, int>> v;
      if (c == d) {
        if (c == '0') {
          if (a == '0') {
            ans++;
            v.push_back({1, 2});
          }
          if (b == '0') {
            ans++;
            v.push_back({2, 1});
          }
        } else {
          if (a == '1') {
            ans++;
            v.push_back({1, 2});
          }
          if (b == '1') {
            ans++;
            v.push_back({2, 1});
          }
        }
      } else {
        if (c == '1') {
          ans++;
          v.push_back({n, n - 1});
          if (a == '0') {
            ans++;
            v.push_back({1, 2});
          }
          if (b == '0') {
            ans++;
            v.push_back({2, 1});
          }
        } else {
          ans++;
          v.push_back({n, n - 1});
          if (a == '1') {
            ans++;
            v.push_back({1, 2});
          }
          if (b == '1') {
            ans++;
            v.push_back({2, 1});
          }
        }
      }
      cout << ans << "\n";
      for (auto x : v) {
        cout << x.first << " " << x.second << "\n";
      }
    }
  }
  return 0;
}
