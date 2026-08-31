#include <bits/stdc++.h>
using namespace std;
void FastInputOutput() {
  ios_base ::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
inline int D() {
  int t;
  scanf("%d", &t);
  return t;
}
inline long long LLD() {
  long long t;
  scanf("%lld", &t);
  return t;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
long long power(long long x, long long p, long long m) {
  long long res = 1;
  while (p) {
    if (p & 1) res = (res * x) % m;
    x = ((x % m) * (x % m)) % m;
    p >>= 1ll;
  }
  return res;
}
long double ModLog(long double base, long double x) {
  return (logl(x) / logl(base));
}
int mod(int a, int m) { return (((a % m) + m) % m); }
const int N = 2e5 + 5, MOD = 998244353;
struct BIT {
  int n;
  vector<long long> sum;
  BIT(int n) {
    this->n = n;
    sum.resize(n + 5);
    for (int i = 1; i < n; ++i) sum[i] = 0;
  }
  long long get(int r) {
    long long ret = 0;
    while (r) {
      ret += sum[r];
      r -= (r & -r);
    }
    return ret;
  }
  long long get(int l, int r) { return get(r) - get(l - 1); }
  void update(int l, long long x) {
    while (l < n) {
      sum[l] += x;
      l += (l & -l);
    }
  }
};
int id[N], x[N], v[N];
bool cmp(int s, int f) { return x[f] > x[s]; }
void solve() {
  int n = D();
  for (int i = 0; i < n; ++i) {
    id[i] = i;
    x[i] = D();
  }
  vector<int> compress(n);
  for (int i = 0; i < n; ++i) {
    v[i] = D();
    compress[i] = v[i];
  }
  sort(id, id + n, cmp);
  sort(compress.begin(), compress.end());
  compress.erase(unique(compress.begin(), compress.end()), compress.end());
  for (int i = 0, idx; i < n; ++i) {
    idx = id[i];
    v[idx] = lower_bound(compress.begin(), compress.end(), v[idx]) -
             compress.begin();
    ++v[idx];
  }
  BIT inv(n + 1), sum(n + 1);
  long long ans = 0;
  for (int i = 0, idx; i < n; ++i) {
    idx = id[i];
    long long cnt = inv.get(v[idx]);
    long long curr = cnt * x[idx] - sum.get(v[idx]);
    ans += curr;
    inv.update(v[idx], 1);
    sum.update(v[idx], x[idx]);
  }
  printf("%lld\n", ans);
}
int main() {
  int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
