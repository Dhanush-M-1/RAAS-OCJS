#include <bits/stdc++.h>
using namespace std;
const int N = 5005;
const int INF = 1000000000;
int n, m;
int t[N], l[N], r[N], v[N];
int add[N], atmost[N], sol[N];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) atmost[i] = INF;
  for (int i = 1; i <= m; i++) {
    scanf("%d %d %d %d", t + i, l + i, r + i, v + i);
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) add[j] += v[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++)
        atmost[j] = min(atmost[j], v[i] - add[j]);
    }
  }
  for (int i = 1; i <= n; i++) {
    sol[i] = atmost[i];
  }
  for (int i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) sol[j] += v[i];
    } else {
      int mx = sol[l[i]];
      for (int j = l[i] + 1; j <= r[i]; j++) mx = max(mx, sol[j]);
      if (mx != v[i]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (int i = 1; i <= n; i++) {
    printf("%d", atmost[i]);
    if (i < n) printf(" ");
  }
  printf("\n");
}
