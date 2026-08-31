#include <bits/stdc++.h>
using namespace std;
static const double EPS = 1e-9;
int ROUND(double x) { return (int)(x + 0.5); }
bool ISINT(double x) { return fabs(ROUND(x) - x) <= EPS; }
bool ISEQUAL(double x, double y) {
  return fabs(x - y) <= EPS * max(1.0, max(fabs(x), fabs(y)));
}
double SQSUM(double x, double y) { return x * x + y * y; }
template <class T>
bool INRANGE(T x, T a, T b) {
  return a <= x && x <= b;
}
const int MAX_N = 100005;
int bit[MAX_N + 1];
void bit_add(int xi, int v) {
  for (int x = xi; x <= MAX_N; x += x & -x) {
    bit[x] += v;
  }
}
long long bit_sum(int xi) {
  long long ret = 0;
  for (int x = xi; x >= 1; x -= x & -x) {
    ret += bit[x];
  }
  return ret;
}
int rev(int x) {
  int ret = 0;
  bool start = false;
  while (x) {
    if (start) ret *= 10;
    if (x % 10) start = true;
    ret += x % 10;
    x /= 10;
  }
  return ret;
}
long long gcd(long long x, long long y) {
  long long t;
  while (y != 0) {
    t = x % y;
    x = y;
    y = t;
  }
  return x;
}
int main() {
  int X, Y, W;
  scanf("%d%d%d", &X, &Y, &W);
  map<pair<int, int>, vector<int> > mp;
  for (int a = 1; a <= 100000; a++) {
    int bunshi = a;
    int bunbo = rev(a);
    int gc = (int)gcd(bunshi, bunbo);
    bunshi /= gc;
    bunbo /= gc;
    mp[make_pair(bunshi, bunbo)].push_back(a);
  }
  const long long LBIG = 98765432198765LL;
  long long ab = LBIG;
  int besta = 0;
  int bestb = 0;
  memset(bit, 0, sizeof(bit));
  for (int a = 1; a <= X; a++) {
    int bunshi = rev(a);
    int bunbo = a;
    int gc = (int)gcd(bunshi, bunbo);
    bunshi /= gc;
    bunbo /= gc;
    for (int i = 0; i < ((int)mp[make_pair(bunshi, bunbo)].size()); i++) {
      bit_add(mp[make_pair(bunshi, bunbo)][i], 1);
    }
    {
      int lo = 0;
      int hi = Y;
      while (lo < hi) {
        int mid = lo + (hi - lo) / 2LL;
        if (bit_sum(mid) >= W) {
          hi = mid;
        } else {
          lo = mid + 1;
        }
      }
      if (bit_sum(lo) >= W) {
        if (ab > (long long)a * lo) {
          ab = (long long)a * lo;
          besta = a;
          bestb = lo;
        }
      }
    }
  }
  if (ab == LBIG) {
    printf("-1\n");
  } else {
    printf("%d %d\n", besta, bestb);
  }
  return 0;
}
