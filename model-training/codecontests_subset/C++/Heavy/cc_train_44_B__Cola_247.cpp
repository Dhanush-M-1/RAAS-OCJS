#include <bits/stdc++.h>
using namespace std;
int rec(double litr, int a, int b, int c) {
  if (!litr) return 1;
  if (litr < 0) return 0;
  int ret = 0;
  if (a) ret += rec(litr - 0.5, a - 1, b, c);
  if (b) ret += rec(litr - 1, a, b - 1, c);
  if (c) ret += rec(litr - 2, a, b, c - 1);
  return ret;
}
int main() {
  int a, b, c, n;
  scanf("%d %d %d %d", &n, &a, &b, &c);
  int ans = 0, lo, hi, mid;
  for (int i = 0; i < c + 1; i++) {
    for (int j = 0; j < b + 1; j++) {
      if (i * 2 + j * 1 > n) break;
      lo = 0, hi = a;
      bool found = false;
      double compute;
      while (lo + 1 < hi) {
        mid = (lo + hi) / 2;
        compute = (i * 2 + j * 1. + mid * 0.5);
        if (compute == n) {
          found = true;
          break;
        }
        if (compute > n)
          hi = mid;
        else
          lo = mid;
      }
      compute = (i * 2 + j * 1. + lo * 0.5);
      if (compute == n) found = true;
      compute = (i * 2 + j * 1. + hi * 0.5);
      if (compute == n) found = true;
      if (found) ans++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
