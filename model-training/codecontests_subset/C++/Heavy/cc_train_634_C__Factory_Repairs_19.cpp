#include <bits/stdc++.h>
using namespace std;
template <typename T>
T nextInt() {
  T x = 0, p = 1;
  char ch;
  do {
    ch = getchar();
  } while (ch <= ' ');
  if (ch == '-') {
    p = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + (ch - '0');
    ch = getchar();
  }
  return x * p;
}
const int maxN = (int)3e5 + 10;
const int mod = (int)1e9 + 7;
const int INF = (int)1e9 + 5;
const long long LLINF = (long long)1e18 + 5;
const double PI = acos(-1.0);
int k, n;
int b, a;
int q;
long long fwA[maxN];
long long fwB[maxN];
long long aC[maxN];
long long bC[maxN];
void update(long long fw[maxN], long long C[maxN], int r, long long x,
            long long lim) {
  x = min(lim - C[r], x);
  C[r] += x;
  for (; r < maxN; r |= r + 1) {
    fw[r] += x;
  }
}
long long sum(long long fw[maxN], int r) {
  long long ret = 0LL;
  for (; r >= 0; r = (r & (r + 1)) - 1) {
    ret += fw[r];
  }
  return ret;
}
int main() {
  n = nextInt<int>();
  k = nextInt<int>();
  a = nextInt<int>();
  b = nextInt<int>();
  q = nextInt<int>();
  while (q--) {
    int x, d;
    int p;
    int t;
    t = nextInt<int>();
    if (t == 1) {
      d = nextInt<int>();
      x = nextInt<int>();
      update(fwA, aC, d, x, a);
      update(fwB, bC, d, x, b);
    } else {
      long long ret = 0LL;
      p = nextInt<int>();
      ret += sum(fwB, p - 1);
      ret += sum(fwA, maxN - 1) - sum(fwA, p + k - 1);
      printf("%I64d\n", ret);
    }
  }
  return 0;
}
