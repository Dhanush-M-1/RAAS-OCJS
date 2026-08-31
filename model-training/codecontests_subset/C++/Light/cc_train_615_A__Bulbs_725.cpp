#include <bits/stdc++.h>
using namespace std;
int bu[30000];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    for (int j = 0; j < x; j++) {
      int y;
      scanf("%d", &y);
      bu[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (bu[i] != 1) {
      printf("NO");
      return 0;
    }
  }
  printf("YES");
  return 0;
}
