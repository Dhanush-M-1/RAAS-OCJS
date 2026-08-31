#include <bits/stdc++.h>
using namespace std;
int read(int &x) {
  int dat = 0, oko = 1;
  char chc = getchar();
  while (chc < '0' || chc > '9') {
    if (chc == '-') oko = -1;
    chc = getchar();
  }
  while (chc >= '0' && chc <= '9') {
    dat = dat * 10 + chc - '0';
    chc = getchar();
  }
  x = dat * oko;
  return x;
}
int T, a, b, c, ans, t1, t2;
int main() {
  read(T);
  while (T--) {
    read(a), read(b), read(c);
    t1 = min(b, c >> 1);
    c -= t1 << 1;
    b -= t1;
    t2 = min(a, b >> 1);
    printf("%d\n", (t1 + t2) * 3);
  }
  return 0;
}
