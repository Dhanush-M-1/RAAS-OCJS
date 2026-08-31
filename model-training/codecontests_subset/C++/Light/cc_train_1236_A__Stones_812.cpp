#include <bits/stdc++.h>
using namespace std;
int a, b, c, res, A, B, C, T;
void inp() { scanf("%d %d %d", &a, &b, &c); }
void proc() {
  A = a, B = b, C = c;
  c -= min(b, c / 2) * 2;
  b -= min(b, C / 2);
  a -= min(a, b / 2);
  b -= min(A, b / 2) * 2;
  res = A - a + B - b + C - c;
  printf("%d\n", res);
}
int main() {
  scanf("%d", &T);
  while (T--) {
    inp();
    proc();
  }
  return 0;
}
