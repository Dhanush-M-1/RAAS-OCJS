#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
const int MAXM = 5e6 + 5;
const double eps = 1e-10;
const long long MOD = 998244353;
int x, y;
int cnt;
int judger(int c, int d) {
  int aa = x ^ c, bb = y ^ d;
  if (aa < bb)
    return -1;
  else if (aa == bb)
    return 0;
  else
    return 1;
}
int read() {
  int x;
  cin >> x;
  if (x == -2) {
    exit(0);
  }
  return x;
}
void q(int c, int d) {
  cout << "? " << c << " " << d << endl;
  fflush(stdout);
}
int push(int c, int d) {
  ++cnt;
  if (cnt == 63) {
    puts("WA");
    exit(0);
  }
  q(c, d);
  int res = read();
  return res;
}
int a[70];
int b[70];
int r1[70], r2[70], r3[70], r4[70];
int main() {
  x = 3;
  y = 1;
  int la = push(0, 0), pre = 0;
  for (int i = 29; i >= 0; --i) {
    int x1 = 1 << i;
    int r1 = push(pre + x1, 0);
    int r2 = push(pre, x1);
    int res;
    if (r1 != r2) {
      res = 0;
      if (r1 == -1) {
        a[i] = b[i] = 1;
      } else
        a[i] = b[i] = 0;
    } else {
      if (la == 1) {
        a[i] = 1;
        b[i] = 0;
      } else {
        a[i] = 0;
        b[i] = 1;
      }
      la = r1;
      pre += x1;
    }
  }
  int a1 = 0, b1 = 0;
  for (int i = 29; i >= 0; --i) {
    a1 = (a1 << 1) + a[i];
    b1 = (b1 << 1) + b[i];
  }
  printf("! %d %d\n", a1, b1);
  if (a1 != x || b1 != y) {
    printf("WA\n");
  }
  return 0;
}
