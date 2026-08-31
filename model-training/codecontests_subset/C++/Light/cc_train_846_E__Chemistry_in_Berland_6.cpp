#include <bits/stdc++.h>
using namespace std;
const long long oo = 1e17 + 10;
long long mul(long long a, long long b) {
  if ((double)a * (double)b > oo) return oo;
  return a * b;
}
long long sum(long long a, long long b) {
  if ((double)a + (double)b > oo) return oo;
  return a + b;
}
const int N = 100010;
int deg[N];
long long extra[N], need[N], b[N], a[N];
int x[N], k[N];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", b + i);
  for (int i = 1; i <= n; i++) scanf("%lld", a + i);
  for (int i = 2; i <= n; i++) scanf("%d %d", x + i, k + i);
  for (int i = n; i >= 1; i--) {
    if (b[i] < a[i])
      need[i] += a[i] - b[i];
    else
      extra[i] += b[i] - a[i];
    if (need[i] <= extra[i]) {
      extra[i] -= need[i];
      need[i] = 0;
    } else {
      need[i] -= extra[i];
      extra[i] = 0;
    }
    if (i > 1) {
      if (extra[i]) {
        extra[x[i]] += extra[i];
        extra[i] = 0;
      } else {
        need[x[i]] = sum(need[x[i]], mul(need[i], k[i]));
        need[i] = 0;
      }
    }
  }
  printf("%s\n", need[1] ? "NO" : "YES");
  return 0;
}
