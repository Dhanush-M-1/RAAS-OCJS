#include <bits/stdc++.h>
using namespace std;
const int maxn = 300010;
int cnt[maxn];
vector<int> c[maxn];
int a[maxn];
int main() {
  int n, m, x, y;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &x, &y);
    c[y].push_back(x);
  }
  for (int i = 0; i < c[a[n]].size(); i++) cnt[c[a[n]][i]]++;
  int ans = 0;
  for (int i = n - 1; i >= 1; i--) {
    if (n - i - ans == cnt[a[i]])
      ans++;
    else {
      for (int j = 0; j < c[a[i]].size(); j++) cnt[c[a[i]][j]]++;
    }
  }
  printf("%d\n", ans);
}
