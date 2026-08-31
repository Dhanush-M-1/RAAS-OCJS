#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int color[n][2];
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &color[i][0], &color[i][1]);
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (i != j) {
        if (color[i][0] == color[j][1]) ans++;
      }
    }
  }
  printf("%d\n", ans);
}
