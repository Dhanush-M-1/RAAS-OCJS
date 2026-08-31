#include <bits/stdc++.h>
using namespace std;
struct node {
  long long to, next, w;
} e[100010];
long long n, cnt = 0, x, y, a[100010], head[100010];
double tmp;
void add(long long i) {
  e[++cnt] = {i, head[x], y};
  head[x] = cnt;
}
void dfs(long long u, long long f, long long k) {
  for (long long i = head[u]; i; i = e[i].next) dfs(e[i].to, u, e[i].w);
  if (a[u] >= 0)
    a[f] += a[u];
  else {
    tmp = double(k) * double(a[u]);
    if (!f || tmp < -1000000000007) {
      puts("NO");
      exit(0);
    }
    a[f] += k * a[u];
    if (a[f] < -1000000000007) {
      puts("NO");
      exit(0);
    }
  }
}
int main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i];
  for (long long i = 1; i <= n; i++) {
    cin >> x;
    a[i] -= x;
  }
  for (long long i = 2; i <= n; i++) {
    cin >> x >> y;
    add(i);
  }
  dfs(1, 0, 0);
  puts("YES");
  return 0;
}
