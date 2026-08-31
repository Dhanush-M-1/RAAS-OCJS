#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  vector<int> v(m + 1, 0);
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    for (int j = 0; j < x; j++) {
      int y;
      scanf("%d", &y);
      v[y] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (v[i] == 0) {
      printf("NO");
      return 0;
    }
  }
  printf("YES");
  return 0;
}
