#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(T x) {
  return x * x;
}
struct sa {
  int x, y, z;
  sa(int x, int y, int z) : x(x), y(y), z(z) {}
  sa() {}
};
vector<sa> ans;
vector<int> a[110000];
int v[110000], d[110000];
int n, m;
int dfs(int x, int dep) {
  int i, y, z, last = 0;
  v[x] = 1;
  d[x] = dep;
  for (i = 0; i < a[x].size(); i++) {
    y = a[x][i];
    if (v[y] && d[y] < d[x]) continue;
    if (!v[y] && (z = dfs(y, dep + 1)) && z) {
      sa t(x, y, z);
      ans.push_back(t);
    } else {
      sa t(last, x, y);
      last = last ? ans.push_back(t), 0 : y;
    }
  }
  return last;
}
int main() {
  int i, x, y, flag;
  scanf("%d%d", &n, &m);
  for (i = 0; i < m; i++) {
    scanf("%d%d", &x, &y);
    a[x].push_back(y);
    a[y].push_back(x);
  }
  flag = 1;
  for (i = 1; i <= n; i++)
    if (!v[i] && dfs(i, 0)) flag = 0;
  if (!flag) return puts("No solution"), 0;
  for (i = 0; i < ans.size(); i++)
    printf("%d %d %d\n", ans[i].x, ans[i].y, ans[i].z);
}
