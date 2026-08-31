#include <bits/stdc++.h>
int main() {
  long long in[100005];
  long long n, i, j, m, t;
  memset(in, 0, sizeof(in));
  scanf("%lld", &n);
  for (i = 1; i <= n - 1; i++) {
    long long u, v;
    scanf("%lld %lld", &u, &v);
    in[u]++;
    in[v]++;
  }
  long long num = 0;
  long long ans = 0;
  int flag = 1;
  for (i = 1; i <= n; i++) {
    if (in[i] == 1) num++;
    if (in[i] == 2) flag = 0;
  }
  num--;
  ans = (1 + num) * num / 2;
  if (ans >= n - 1 && flag)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
