#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 11;
const long long INF = 1e9;
long long arr[N], limit[N];
int oper[N][4];
int n, m;
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; ++i) limit[i] = INF;
  for (int i = 0; i < m; ++i) {
    int op, l, r, d;
    scanf("%d %d %d %d", &op, &l, &r, &d);
    oper[i][0] = op, oper[i][1] = l, oper[i][2] = r, oper[i][3] = d;
    if (op == 1) {
      for (int j = l; j <= r; ++j) arr[j] += d;
    } else {
      for (int j = l; j <= r; ++j) limit[j] = min(limit[j], d - arr[j]);
    }
  }
  memset(arr, 0, sizeof(arr));
  for (int i = 0; i < m; ++i) {
    if (oper[i][0] == 1) {
      for (int j = oper[i][1]; j <= oper[i][2]; ++j) arr[j] += oper[i][3];
    } else {
      long long ans = limit[oper[i][1]] + arr[oper[i][1]];
      for (int j = oper[i][1]; j <= oper[i][2]; ++j) {
        ans = max(ans, limit[j] + arr[j]);
      }
      if (ans != oper[i][3]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i <= n; ++i) {
    printf("%lld", limit[i]);
    if (i != n)
      printf(" ");
    else
      printf("\n");
  }
}
