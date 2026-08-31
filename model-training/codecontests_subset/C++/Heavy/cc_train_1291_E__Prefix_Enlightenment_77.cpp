#include <bits/stdc++.h>
using namespace std;
vector<int> v[600005];
int k;
int mx[600005], a[300005], fa[600005];
int find(int x) {
  if (fa[x] != x) {
    fa[x] = find(fa[x]);
  }
  return fa[x];
}
void mer(int x, int y) {
  int fx = find(x), fy = find(y);
  if (fx != fy) {
    mx[fx] += mx[fy];
    fa[fy] = fx;
  }
}
int get(int x) { return min(mx[find(x)], mx[find(x + k)]); }
int main(int argc, char** argv) {
  int n;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%1d", &a[i]);
  for (int i = 1; i <= 2 * k + 1; i++) {
    fa[i] = i;
    mx[i] = i > k;
  }
  mx[2 * k + 1] = 1e8;
  for (int i = 1; i <= k; i++) {
    int c;
    scanf("%d", &c);
    while (c--) {
      int x;
      scanf("%d", &x);
      v[x].push_back(i);
    }
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (v[i].size() == 1) {
      int f = v[i][0];
      if (a[i] == 1) {
        ans -= get(f);
        mer(f + k, 2 * k + 1);
        ans += get(f);
      } else {
        ans -= get(f);
        mer(f, 2 * k + 1);
        ans += get(f);
      }
    }
    if (v[i].size() == 2) {
      int z = v[i][0], x = v[i][1];
      if (a[i] == 1) {
        if (find(x) != find(z)) {
          ans -= get(x) + get(z);
          mer(z + k, x + k);
          mer(z, x);
          ans += get(z);
        }
      } else {
        if (find(x) != find(z + k)) {
          ans -= get(x) + get(z);
          mer(z + k, x);
          mer(z, x + k);
          ans += get(z);
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
