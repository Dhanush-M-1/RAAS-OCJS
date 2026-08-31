#include <bits/stdc++.h>
using namespace std;
inline long long tavan(long long a, long long n, long long mod) {
  long long p = 1;
  while (n > 0) {
    if (n % 2) {
      p = p * a;
      p %= mod;
    }
    n >>= 1;
    a *= a;
    a %= mod;
  }
  return p % mod;
}
long long n, k, a, b, q, fen[2][(201 * 1000)], in[(201 * 1000)];
long long query1(long long x) {
  long long num = 0;
  for (; x > 0; x -= x & (-x)) num += fen[0][x];
  return num;
}
long long query2(long long x) {
  long long num = 0;
  for (; x > 0; x -= x & (-x)) num += fen[1][x];
  return num;
}
void add1(long long x, long long y) {
  for (; x <= n; x += x & (-x)) fen[0][x] += y;
}
void add2(long long x, long long y) {
  for (; x <= n; x += x & (-x)) fen[1][x] += y;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long x, y;
      cin >> x >> y;
      if (in[x] < b) add1(x, min(b - in[x], y));
      if (in[x] < a) add2(x, min(a - in[x], y));
      in[x] += y;
      continue;
    }
    long long x;
    cin >> x;
    cout << query1(x - 1) + query2(n) - query2(x + k - 1) << "\n";
  }
  return 0;
}
