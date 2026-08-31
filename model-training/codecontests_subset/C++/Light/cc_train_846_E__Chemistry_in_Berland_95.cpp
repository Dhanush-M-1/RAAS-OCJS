#include <bits/stdc++.h>
using namespace std;
const int Inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3fll;
int n;
long long b[1 << 17], a[1 << 17];
int fa[1 << 17], k[1 << 17];
vector<int> nei[1 << 17];
void inline dfs(int now) {
  for (int i = 0; i < (((int)(nei[now]).size())); ++i) {
    int to = nei[now][i];
    dfs(to);
  }
  if (now == 1) {
    puts(b[1] >= a[1] ? "YES" : "NO");
    return;
  }
  if (a[now] < -5e17) {
    puts("NO");
    exit(0);
  }
  if (b[now] > a[now]) {
    b[fa[now]] += b[now] - a[now];
    b[now] = a[now];
  } else {
    long long ls = a[now] - b[now];
    if ((5e17 - b[fa[now]]) / k[now] < ls) {
      puts("NO");
      exit(0);
    }
    b[fa[now]] -= 1ll * k[now] * ls;
    b[now] = a[now];
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= (n); ++i) scanf("%lld", b + i);
  for (int i = 1; i <= (n); ++i) scanf("%lld", a + i);
  for (int i = (2); i <= (n); ++i)
    scanf("%d%d", fa + i, k + i), nei[fa[i]].push_back(i);
  dfs(1);
}
