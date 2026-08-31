#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long p) {
  long long res = 1;
  x = x % p;
  while (y > 0) {
    if (y & 1) res = (res * x) % p;
    y = y >> 1;
    x = (x * x) % p;
  }
  return res;
}
inline long long add(long long a, long long b) { return (a + b) % 1000000007; }
inline long long mul(long long a, long long b) { return (a * b) % 1000000007; }
long long f[4000010], iv[4000010];
long long C(long long n, long long r) {
  return mul(f[n], mul(iv[r], iv[n - r]));
}
void prep_fac() {
  f[0] = 1;
  for (int i = 1; i < 4000010; i++) f[i] = mul(i, f[i - 1]);
  iv[4000010 - 1] = power(f[4000010 - 1], 1000000007 - 2, 1000000007);
  for (long long i = 4000010 - 2; i >= 0; --i) iv[i] = mul(i + 1, iv[i + 1]);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, k;
  cin >> n >> k;
  int c1 = 0, c2 = 0;
  vector<long long> v[4];
  v[1].push_back(0), v[2].push_back(0), v[3].push_back(0);
  for (int i = 0; i < n; i++) {
    int t, a, b;
    cin >> t >> a >> b;
    v[2 * a + b].push_back(t);
  }
  for (int i = 1; i < 4; i++) {
    sort(v[i].begin(), v[i].end());
    for (int j = 1; j < v[i].size(); j++) {
      v[i][j] += v[i][j - 1];
    }
  }
  long long ans = INT_MAX;
  for (int i = 0; i < v[3].size(); i++) {
    if (v[2].size() > k - i && v[1].size() > k - i)
      ans = min(v[3][i] + v[2][k - i] + v[1][k - i], ans);
  }
  if (ans == INT_MAX) ans = -1;
  cout << ans;
}
