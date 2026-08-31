#include <bits/stdc++.h>
using namespace std;
int n, k, pre[300005 * 2];
char s[300005];
inline int find(int x) { return x == pre[x] ? x : pre[x] = find(pre[x]); }
int val[300005 * 2], tmp, m;
vector<int> ve[300005];
int ans;
inline int getmin(int x) { return min(val[find(x)], val[find(x + k)]); }
inline void merge(int x, int y) {
  int xx = find(x), yy = find(y);
  if (xx != yy) {
    pre[xx] = yy;
    val[yy] += val[xx];
  }
}
int main() {
  scanf("%d%d%s", &n, &k, s + 1);
  for (int i = 1; i <= k; ++i) {
    scanf("%d", &m);
    while (m--) {
      scanf("%d", &tmp);
      ve[tmp].push_back(i);
    }
  }
  for (int i = 1; i <= k; ++i) {
    pre[i] = i, val[i] = 1;
    pre[i + k] = i + k, val[i + k] = 0;
  }
  pre[2 * k + 1] = 2 * k + 1, val[2 * k + 1] = 0x3f3f3f3f;
  ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (s[i] == '0') {
      if (ve[i].size() == 1) {
        int id = ve[i][0];
        ans -= getmin(id);
        merge(id + k, 2 * k + 1);
        ans += getmin(id);
      } else {
        int id1 = ve[i][0], id2 = ve[i][1];
        if (find(id1) != find(id2 + k)) {
          ans -= getmin(id1) + getmin(id2);
          merge(id1, id2 + k), merge(id1 + k, id2);
          ans += getmin(id1);
        }
      }
    } else {
      if (ve[i].size() == 1) {
        int id = ve[i][0];
        ans -= getmin(id);
        merge(id, 2 * k + 1);
        ans += getmin(id);
      } else if (ve[i].size() == 2) {
        int id1 = ve[i][0], id2 = ve[i][1];
        if (find(id1) != find(id2)) {
          ans -= getmin(id1) + getmin(id2);
          merge(id1, id2), merge(id1 + k, id2 + k);
          ans += getmin(id1);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
