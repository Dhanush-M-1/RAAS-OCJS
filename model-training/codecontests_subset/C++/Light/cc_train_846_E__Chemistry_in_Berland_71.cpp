#include <bits/stdc++.h>
using namespace std;
const long long lim = 1e18;
int n;
long long a[100100], b[100100];
vector<pair<int, int> > v[100100];
long long ksc(long long x, int y) {
  long long z = 0;
  for (; y; y >>= 1, x *= 2) {
    if (x < -lim) {
      puts("NO");
      exit(0);
    }
    if (y & 1) {
      z += x;
      if (z < -lim) {
        puts("NO");
        exit(0);
      }
    }
  }
  return z;
}
long long dfs(int x) {
  long long ret = 0;
  for (auto y : v[x]) {
    long long tmp = dfs(y.first);
    if (tmp >= 0)
      ret += tmp;
    else {
      tmp = ksc(tmp, y.second);
      ret += tmp;
      if (ret < -lim) {
        puts("NO");
        exit(0);
      }
    }
  }
  ret += b[x] - a[x];
  if (ret < -lim) {
    puts("NO");
    exit(0);
  }
  return ret;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i]);
  for (int i = 2, x, y; i <= n; i++)
    scanf("%d%d", &x, &y), v[x].push_back(make_pair(i, y));
  long long tmp = dfs(1);
  puts(tmp >= 0 ? "YES" : "NO");
  return 0;
}
