#include <bits/stdc++.h>
using namespace std;
template <class T>
void minn(T &a, T b) {
  a = min(a, b);
}
template <class T>
void maxx(T &a, T b) {
  a = max(a, b);
}
void io() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
const long long MOD = 1000000007LL;
const long long PRIME = 105943LL;
const long long INF = 1e18;
long long mod;
inline long long add(long long a, long long b) { return (a + b) % mod; }
inline long long mul(long long a, long long b) { return (1LL * a * b) % mod; }
inline long long pow(long long a, long long p) {
  long long ret = 1LL;
  while (p) {
    if (p & 1LL) ret = mul(ret, a);
    a = mul(a, a), p >>= 1LL;
  }
  return ret;
}
inline long long inv(long long x) { return pow(x, mod - 2); }
void go(int l, int r, int h, map<int, int> &cnt) {
  if (l <= r)
    if (h <= 1 || l == r)
      cnt[r - l + 1]++;
    else {
      int m = (l + r) / 2;
      go(l, m, h - 1, cnt);
      go(m + 1, r, h - 1, cnt);
    }
}
long long solve(int x) { return mul(x, mul(x - 1, inv(4))); }
long long solve(int x, int y) {
  long long ret = 0;
  for (int sz = 2; sz <= (int)x + y; sz++)
    ret = add(ret, mul(mul(sz - 2, min(x, sz - 1) - max(1, sz - y) + 1),
                       mul(inv(2), inv(sz))));
  return ret;
}
int main() {
  io();
  int n, k;
  cin >> n >> k >> mod;
  map<int, int> cnt;
  go(1, n, k, cnt);
  assert(cnt.size() < 3);
  int s = cnt.size();
  vector<long long> len, num;
  for (auto en : cnt) len.push_back(en.first), num.push_back(en.second);
  long long ans = 0;
  for (int i = 0; i < (int)(s); i++) {
    long long temp = mul(num[i], solve(len[i]));
    ans = add(ans, temp);
  }
  for (int i = 0; i < (int)(s); i++) {
    long long temp = mul(num[i] * (num[i] - 1) / 2, solve(len[i], len[i]));
    ans = add(ans, temp);
  }
  for (int i = 0; i < (int)(s); i++)
    for (int j = i + 1; j < (int)(s); j++) {
      long long temp = mul(mul(num[i], num[j]), solve(len[i], len[j]));
      ans = add(ans, temp);
    }
  cout << ans << "\n";
  return 0;
}
