#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int inf = 1e9;
int d[maxn], fa[maxn];
int n, k;
char s[maxn];
vector<int> vec[maxn];
int get(int x) {
  if (x == fa[x]) return x;
  return fa[x] = get(fa[x]);
}
void merge(int x, int y) {
  int fx = get(x), fy = get(y);
  if (fx != fy) {
    fa[fx] = fy;
    d[fy] += d[fx];
  }
}
int val(int x) { return min(d[get(x)], d[get(x + k)]); }
int main() {
  scanf("%d%d%s", &n, &k, s + 1);
  for (int i = 1; i <= k; i++) {
    int t, x;
    scanf("%d", &t);
    while (t--) scanf("%d", &x), vec[x].push_back(i);
  }
  for (int i = 1; i <= 2 * k; i++) fa[i] = i, d[i] = i > k;
  fa[2 * k + 1] = 2 * k + 1;
  d[2 * k + 1] = inf;
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (vec[i].size() == 1) {
      int x = vec[i][0];
      ans -= val(x);
      merge(x + (s[i] == '1' ? k : 0), 2 * k + 1);
      ans += val(x);
    } else if (vec[i].size() == 2) {
      int x = vec[i][0], y = vec[i][1];
      if (s[i] == '1' && get(x) != get(y)) {
        ans -= val(x) + val(y);
        merge(x, y), merge(x + k, y + k);
        ans += val(x);
      } else if (s[i] == '0' && get(x) != get(y + k)) {
        ans -= val(x) + val(y);
        merge(x, y + k), merge(x + k, y);
        ans += val(x);
      }
    }
    printf("%d\n", ans);
  }
}
