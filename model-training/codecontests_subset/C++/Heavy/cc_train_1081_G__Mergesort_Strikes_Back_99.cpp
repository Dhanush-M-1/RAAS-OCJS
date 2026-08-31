#include <bits/stdc++.h>
using namespace std;
const int MOD = (int)1e9 + 7;
const int MAXN = (int)1e5 + 3;
const int infint = (int)1e9 + 3;
const long long inf = (long long)1e12;
int n, k, q;
vector<int> v;
int add(int a, int b) {
  int c = a + b;
  if (c >= q) c -= q;
  if (c < 0) c += q;
  return c;
}
int mul(int a, int b) {
  int c = (1LL * a * b) % q;
  return c;
}
int pwr(int a, int b) {
  if (b == 0) return 1;
  int c = pwr(a, b >> 1);
  c = mul(c, c);
  if (b & 1) c = mul(c, a);
  return c;
}
int inv(int a) { return pwr(a, q - 2); }
void solve(int n, int k) {
  if (k <= 1 || n == 1) {
    v.push_back(n);
    return;
  }
  solve(n / 2, k - 1);
  solve((n + 1) / 2, k - 1);
}
int div2;
int inversion(int n) { return mul(n, mul(n - 1, inv(4))); }
int sum(int a, int b) {
  if (a > b) return 0;
  a--;
  int s1 = mul(a, mul(a + 1, div2)), s2 = mul(b, mul(b + 1, div2));
  s1 = add(s2, -s1);
  s1 = add(s1, a - b);
  return s1;
}
int ted[MAXN];
int f(int n1, int n2) {
  int cur = 0;
  for (int dem = 2; dem <= n1 + n2; dem++) {
    int num = sum(max(1, dem - n2), min(n1, dem - 1));
    cur = add(cur, mul(num, inv(dem)));
  }
  return mul(cur, div2);
}
int debug(int n1, int n2) {
  int cur = 0;
  for (int i = 1; i <= n1; i++)
    for (int j = 1; j <= n2; j++) cur = add(cur, mul(i - 1, inv(i + j)));
  return mul(cur, inv(2));
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k >> q;
  solve(n, k);
  sort(v.begin(), v.end());
  div2 = inv(2);
  int ans = 0;
  for (auto u : v) ans = add(ans, inversion(u)), ted[u]++;
  vector<int> diff = v;
  diff.resize(unique(diff.begin(), diff.end()) - diff.begin());
  for (int i = 0; i < diff.size(); i++)
    for (int j = 0; j < diff.size(); j++) {
      int zarib;
      if (i != j)
        zarib = mul(ted[diff[i]], ted[diff[j]]);
      else
        zarib = mul(ted[diff[i]], ted[diff[j]] - 1);
      ans = add(ans, mul(zarib, f(diff[i], diff[j])));
    }
  cout << ans;
}
