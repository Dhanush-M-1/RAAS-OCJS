#include <bits/stdc++.h>
using namespace std;
struct RR {
  long long to, k, nex;
} r[211111];
int hea[111111] = {0}, cnt = 0;
long long n, a[111111], t;
double tem;
void R(long long &x) { scanf("%I64d", &x); }
void dfs(int x, int f, long long kk) {
  int y;
  for (int i = hea[x]; i > 0; i = r[i].nex) {
    y = r[i].to;
    dfs(y, x, r[i].k);
  }
  if (a[x] >= 0) {
    a[f] += a[x];
  } else {
    if (f != 0) {
      tem = (double)a[x] * kk;
      if (tem < -110000000000000000) {
        printf("NO\n");
        exit(0);
      }
      a[f] += a[x] * kk;
      if (a[f] < -110000000000000000) {
        printf("NO\n");
        exit(0);
      }
    } else {
      if (a[x] < 0) {
        printf("NO\n");
        exit(0);
      }
    }
  }
}
int main() {
  R(n);
  for (int i = 1; i <= n; i++) R(a[i]);
  for (int i = 1; i <= n; i++) {
    R(t);
    a[i] -= t;
  }
  long long x, y;
  for (int i = 2; i <= n; i++) {
    R(x);
    R(y);
    r[++cnt] = (RR){i, y, hea[x]};
    hea[x] = cnt;
  }
  dfs(1, 0, 0);
  printf("YES\n");
}
