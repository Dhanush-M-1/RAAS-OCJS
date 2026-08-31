#include <bits/stdc++.h>
using namespace std;
const long long int INF = (long long int)1e9 + 10;
const long long int INFLL = (long long int)1e18 + 10;
const long double EPS = 1e-12;
const long long int MOD = 1e9 + 7;
template <class T>
T &chmin(T &a, const T &b) {
  return a = min(a, b);
}
template <class T>
T &chmax(T &a, const T &b) {
  return a = max(a, b);
}
template <class T>
inline T sq(T a) {
  return a * a;
}
long long int in() {
  long long int x;
  scanf("%lld", &x);
  return x;
}
char yuyushiki[1000010];
string stin() {
  scanf("%s", yuyushiki);
  return yuyushiki;
}
struct BIT {
  vector<long long int> bit;
  int size;
  void init(int n) {
    size = 1;
    while (size < n) size *= 2;
    bit = vector<long long int>(size, 0);
  }
  void add(int k, long long int v) {
    for (int i = k + 1; i <= size; i += i & -i) bit[i - 1] += v;
  }
  long long int sum(int k) {
    long long int res = 0;
    for (int i = k; i > 0; i -= i & -i) res += bit[i - 1];
    return res;
  }
  long long int sum(int l, int r) { return sum(r) - sum(l); }
  long long int get(int k) { return sum(k + 1) - sum(k); }
  long long int update(int k, long long int x) { add(k, x - get(k)); }
};
BIT bita, bitb;
long long int n, k, a, b, q;
long long int c[200010];
int main() {
  n = in();
  k = in();
  a = in();
  b = in();
  q = in();
  bita.init(n);
  bitb.init(n);
  for (long long int qc = (0); qc < (long long int)(q); qc++) {
    int t = in();
    if (t == 1) {
      long long int x = in() - 1;
      long long int y = in();
      c[x] += y;
      bitb.update(x, min(b, c[x]));
      bita.update(x, min(a, c[x]));
    } else if (t == 2) {
      long long int x = in() - 1;
      long long int bb = bitb.sum(x);
      long long int aa = bita.sum(n) - bita.sum(x + k);
      long long int ans = aa + bb;
      printf("%lld\n", ans);
    } else {
      assert(false);
    }
  }
  return 0;
}
