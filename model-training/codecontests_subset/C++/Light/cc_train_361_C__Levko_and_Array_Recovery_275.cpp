#include <bits/stdc++.h>
using namespace std;
struct q {
  int t, l, r, v;
} A[10001];
int mx[10001];
int sum[10001];
int B[10001];
int n, m;
bool valid() {
  for (int i = 1; i <= n; ++i) B[i] = mx[i];
  for (int i = 1; i <= m; ++i) {
    if (A[i].t == 1) {
      for (int j = A[i].l; j <= A[i].r; ++j) B[j] += A[i].v;
    } else {
      int mx = -1000000001;
      for (int j = A[i].l; j <= A[i].r; ++j) mx = max(mx, B[j]);
      if (mx != A[i].v) return false;
    }
  }
  return true;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; ++i) sum[i] = -1000000000, mx[i] = 2000000000;
  bool ok = 1;
  for (int i = 1; i <= m; ++i) {
    scanf("%d %d %d %d", &A[i].t, &A[i].l, &A[i].r, &A[i].v);
    if (A[i].t == 1) {
      for (int j = A[i].l; j <= A[i].r; ++j) {
        sum[j] += A[i].v;
      }
    } else {
      for (int j = A[i].l; j <= A[i].r; ++j) {
        mx[j] = min(mx[j], A[i].v - sum[j]);
        if (mx[j] < 0) {
          ok = 0;
          break;
        }
      }
      if (!ok) break;
    }
  }
  for (int i = 1; i <= n; ++i) mx[i] -= 1000000000;
  if (!ok || !valid())
    printf("NO");
  else {
    printf("YES\n");
    for (int i = 1; i <= n; ++i) printf("%d ", mx[i]);
  }
  return 0;
}
