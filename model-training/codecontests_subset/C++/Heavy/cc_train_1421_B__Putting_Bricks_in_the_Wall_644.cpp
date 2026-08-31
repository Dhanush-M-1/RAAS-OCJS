#include <bits/stdc++.h>
using namespace std;
const int maax = 300001;
const long long mod = 998244353;
long long prime[maax];
long long fact[maax];
long long inv[maax];
long long nCr(long long n, long long r) {
  return (((fact[n] * inv[r]) % mod) * inv[n - r]) % mod;
}
void make() {
  prime[1] = 1;
  for (long long i = 2; i < (long long)maax; i++) {
    if (!prime[i]) {
      for (int j = i + i; j < maax; j += i) prime[j] = 1;
    }
  }
  fact[0] = 1;
  for (long long i = 0; i < (long long)maax; i++) {
    fact[i] *= fact[i - 1];
    if (fact[i] > mod) fact[i] %= mod;
  }
}
long long power(long long x, long long y) {
  long long res = 1;
  while (y) {
    if (y & 1) res = (res * x) % mod;
    y >>= 1;
    x = (x * x) % mod;
  }
  return res;
}
long long inverse(long long a) { return power(a, mod - 2); }
bool findpath(vector<vector<char> > &v, int a, int b, vector<vector<int> > vis,
              char c) {
  if (a < 0 || b < 0 || a >= v.size() || b >= v.size() || vis[a][b]) return 0;
  if (v[a][b] == 'F') {
    return 1;
  }
  if (v[a][b] != c) return 0;
  vis[a][b] = 1;
  int ans = 0;
  ans |= findpath(v, a - 1, b, vis, c);
  if (ans) return ans;
  ans |= findpath(v, a + 1, b, vis, c);
  if (ans) return ans;
  ans |= findpath(v, a, b - 1, vis, c);
  if (ans) return ans;
  ans |= findpath(v, a, b + 1, vis, c);
  vis[a][b] = 0;
  return ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<vector<char> > v(n, vector<char>(n));
    for (long long i = 0; i < (long long)n; i++) {
      for (long long j = 0; j < (long long)n; j++) cin >> v[i][j];
    }
    int z1 = 0;
    int z2 = 0;
    if (v[0][1] == '0') z1++;
    if (v[1][0] == '0') z1++;
    if (v[n - 1][n - 2] == '0') z2++;
    if (v[n - 2][n - 1] == '0') z2++;
    vector<pair<long long, long long> > ans;
    if (z1 == 2) {
      if (z2 == 2) {
        ans.push_back({n - 1, n - 2});
        ans.push_back({n - 2, n - 1});
      } else if (z2 == 1) {
        if (v[n - 1][n - 2] == '0')
          ans.push_back({n - 1, n - 2});
        else
          ans.push_back({n - 2, n - 1});
      }
    } else if (z1 == 1) {
      if (z2 == 2) {
        if (v[0][1] == '0')
          ans.push_back({0, 1});
        else
          ans.push_back({1, 0});
      } else if (z2 == 1) {
        if (v[0][1] == '0')
          ans.push_back({0, 1});
        else
          ans.push_back({1, 0});
        if (v[n - 1][n - 2] == '1')
          ans.push_back({n - 1, n - 2});
        else
          ans.push_back({n - 2, n - 1});
      } else {
        if (v[0][1] == '1')
          ans.push_back({0, 1});
        else
          ans.push_back({1, 0});
      }
    } else {
      if (z2 == 0) {
        ans.push_back({n - 1, n - 2});
        ans.push_back({n - 2, n - 1});
      } else if (z2 == 1) {
        if (v[n - 1][n - 2] == '1')
          ans.push_back({n - 1, n - 2});
        else
          ans.push_back({n - 2, n - 1});
      }
    }
    cout << ans.size() << "\n";
    for (int i = 0; i < ans.size(); i++)
      cout << ans[i].first + 1 << " " << ans[i].second + 1 << "\n";
  }
  return 0;
}
