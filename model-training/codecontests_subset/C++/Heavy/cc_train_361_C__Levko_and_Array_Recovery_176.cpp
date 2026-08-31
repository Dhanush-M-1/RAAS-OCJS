#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  vector<vector<int> > ops(m, vector<int>(4, 0));
  for (int i = 0; i < m; ++i)
    scanf("%d %d %d %d", &ops[i][0], &ops[i][1], &ops[i][2], &ops[i][3]);
  vector<int> ans(n, 1000000000);
  for (int i = m - 1; i >= 0; --i) {
    int t = ops[i][0], l = ops[i][1], r = ops[i][2], p = ops[i][3];
    if (t == 2) {
      for (int j = l - 1; j < r; ++j) {
        if (ans[j] == 1000000000)
          ans[j] = p;
        else if (ans[j] > p)
          ans[j] = p;
      }
    } else
      for (int j = l - 1; j < r; ++j)
        if (ans[j] != 1000000000) ans[j] -= p;
  }
  vector<int> temp;
  temp.assign(ans.begin(), ans.end());
  for (int i = 0; i < m; ++i) {
    int t = ops[i][0], l = ops[i][1], r = ops[i][2], p = ops[i][3];
    if (t == 2) {
      int max_e = temp[l - 1];
      for (int j = l - 1; j < r; ++j) max_e = max(max_e, temp[j]);
      if (max_e != p) {
        printf("NO\n");
        return 0;
      }
    } else
      for (int j = l - 1; j < r; ++j) temp[j] += p;
  }
  printf("YES\n");
  for (int i = 0; i < n; ++i) printf("%d ", ans[i]);
}
