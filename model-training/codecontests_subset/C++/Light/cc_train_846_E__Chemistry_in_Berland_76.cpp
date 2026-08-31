#include <bits/stdc++.h>
struct Edge {
  long long to, dis, next;
} edge[100100];
long long n, num_edge;
long long first1[100100];
long long a[100100], b[100100];
double tem;
void dfs(long long x, long long fa, long long p) {
  long long k = first1[x];
  while (k != 0) {
    dfs(edge[k].to, x, edge[k].dis);
    k = edge[k].next;
  }
  if (a[x] < b[x])
    b[fa] += b[x] - a[x];
  else if (a[x] > b[x]) {
    tem = (double)(b[x] - a[x]) * p;
    if (tem < -110000000000000000) {
      printf("NO");
      exit(0);
    }
    b[fa] -= p * (a[x] - b[x]);
    if (b[fa] < -110000000000000000) {
      printf("NO");
      exit(0);
    }
  }
}
int main() {
  long long i, x, k;
  scanf("%lld", &n);
  for (i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (i = 1; i <= n; i++) scanf("%lld", &a[i]);
  for (i = 2; i <= n; i++) {
    scanf("%lld%lld", &x, &k);
    edge[++num_edge].to = i;
    edge[num_edge].dis = k;
    edge[num_edge].next = first1[x];
    first1[x] = num_edge;
  }
  k = first1[1];
  while (k != 0) {
    dfs(edge[k].to, 1, edge[k].dis);
    k = edge[k].next;
  }
  if (b[1] < a[1])
    printf("NO");
  else
    printf("YES");
  return 0;
}
