#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
struct node {
  int t;
  int l;
  int r;
  int d;
} data[10000];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  long long sum[51000];
  memset(sum, 0, sizeof(sum));
  long long lessthan[51000];
  memset(lessthan, -1, sizeof(lessthan));
  for (int i = 0; i < m; i++) {
    scanf("%d%d%d%d", &data[i].t, &data[i].l, &data[i].r, &data[i].d);
    if (data[i].t == 1) {
      for (int j = data[i].l; j <= data[i].r; j++) {
        sum[j] += data[i].d;
      }
    } else {
      for (int j = data[i].l; j <= data[i].r; j++) {
        if (lessthan[j] == -1 || lessthan[j] + sum[j] > data[i].d) {
          lessthan[j] = data[i].d - sum[j];
        }
      }
    }
  }
  memset(sum, 0, sizeof(sum));
  bool ok = 1;
  for (int i = 0; i < m; i++) {
    if (data[i].t == 1) {
      for (int j = data[i].l; j <= data[i].r; j++) {
        sum[j] += data[i].d;
      }
    } else {
      bool isok = 0;
      for (int j = data[i].l; j <= data[i].r; j++) {
        if (lessthan[j] + sum[j] == data[i].d) {
          isok = 1;
          break;
        }
      }
      if (!isok) {
        ok = 0;
        break;
      }
    }
  }
  if (!ok) {
    printf("NO\n");
  } else {
    printf("YES\n");
    printf("%d", lessthan[1]);
    for (int i = 2; i <= n; i++) printf(" %d", lessthan[i]);
    printf("\n");
  }
  return 0;
}
