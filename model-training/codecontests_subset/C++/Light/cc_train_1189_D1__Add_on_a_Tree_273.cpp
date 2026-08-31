#include <bits/stdc++.h>
const double eps = 1e-7;
using namespace std;
int n;
int deg[100010];
int main() {
  while (~scanf("%d", &n)) {
    int a = 0, b = 0;
    memset(deg, 0, sizeof(deg));
    for (int i = 0; i < n - 1; ++i) {
      scanf("%d%d", &a, &b);
      deg[a] += 1;
      deg[b] += 1;
    }
    bool isOk = 1;
    for (int i = 1; i <= n; ++i) {
      if (deg[i] == 2) {
        isOk = 0;
        break;
      }
    }
    printf("%s\n", isOk ? "YES" : "NO");
  }
  return 0;
}
