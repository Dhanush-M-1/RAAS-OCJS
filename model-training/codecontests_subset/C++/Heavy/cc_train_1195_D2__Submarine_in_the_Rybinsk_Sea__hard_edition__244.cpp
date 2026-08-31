#include <bits/stdc++.h>
using namespace std;
using llong = long long;
using VI = vector<llong>;
const llong Mod = 998244353;
llong p10[20];
llong Calc(VI& a, llong cif) {
  llong len = a.size() + cif - 1;
  llong pl = a.size() - cif;
  llong Pow = p10[len];
  llong ans = 0;
  if (pl < 0) {
    llong p = 0;
    for (int i = a.size() - 1; i >= 0; --i) {
      ans = (ans + p10[p] * a[i]) % Mod;
      ++p;
      ans = (ans + p10[p] * a[i]) % Mod;
      ++p;
    }
    return ans;
  }
  for (int i = 0; i < pl; ++i) {
    ans = (ans + Pow * a[i]) % Mod;
    ans = (ans + Pow * a[i]) % Mod;
    Pow = p10[--len];
  }
  for (int i = pl; i < a.size(); ++i) {
    ans = (ans + Pow * a[i]) % Mod;
    Pow = p10[--len];
    ans = (ans + Pow * a[i]) % Mod;
    Pow = p10[--len];
  };
  return ans;
}
llong ncif(llong x) {
  llong s = 0;
  while (x) ++s, x /= 10;
  return s;
}
llong n, sol, nr[20], x[100000 + 5];
VI v;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  p10[0] = 1;
  for (int i = 1; i <= 19; ++i) p10[i] = p10[i - 1] * 10 % Mod;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> x[i];
    ++nr[ncif(x[i])];
  }
  for (int i = 1; i <= n; ++i) {
    v.clear();
    while (x[i]) {
      v.push_back(x[i] % 10);
      x[i] /= 10;
    }
    reverse(v.begin(), v.end());
    for (int j = 1; j <= 10; ++j)
      sol = (sol + nr[j] % Mod * Calc(v, j) % Mod) % Mod;
  }
  cout << sol;
}
