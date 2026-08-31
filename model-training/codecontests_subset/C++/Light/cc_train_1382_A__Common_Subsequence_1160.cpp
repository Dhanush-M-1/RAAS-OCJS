#include <bits/stdc++.h>
using namespace std;
const int N = 1005;
int n, m;
int main() {
  int task;
  for (scanf("%d", &task); task--;) {
    scanf("%d%d", &n, &m);
    unordered_set<int> S;
    for (int i = 1, x; i <= n; i++) scanf("%d", &x), S.insert(x);
    bool flag = true;
    for (int i = 1, x; i <= m; i++) {
      scanf("%d", &x);
      if (flag && S.count(x)) {
        puts("YES");
        printf("1 %d\n", x);
        flag = false;
      }
    }
    if (flag) puts("NO");
  }
  return 0;
}
