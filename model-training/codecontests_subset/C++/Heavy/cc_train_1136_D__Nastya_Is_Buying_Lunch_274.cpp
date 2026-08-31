#include <bits/stdc++.h>
using namespace std;
int input[300005];
int input2[500005][2];
int link[300005];
unordered_set<int> front[300005];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &input[i]);
  for (int i = 0; i < m; i++) {
    scanf("%d%d", &input2[i][0], &input2[i][1]);
    front[input2[i][0]].insert(input2[i][1]);
  }
  for (int i = 1; i <= n; i++) link[i] = i + 1;
  int ans = 0;
  for (int i = n - 1; i > 0; i--) {
    bool isok = true;
    for (int now = link[i]; now <= n; now = link[now]) {
      if (!front[input[i]].count(input[now])) {
        isok = false;
        break;
      }
    }
    if (isok) {
      ans++;
      link[i - 1] = link[i];
    }
  }
  printf("%d\n", ans);
  return 0;
}
