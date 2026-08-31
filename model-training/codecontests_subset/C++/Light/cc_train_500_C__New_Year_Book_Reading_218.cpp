#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 100;
int w[N];
int flag[N];
int b[N];
int coc[N];
int n, m;
int sum;
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &w[i]);
  }
  for (int j = 0; j < m; j++) {
    scanf("%d", &b[j]);
    if (!flag[b[j]]) {
      coc[sum++] = b[j];
      flag[b[j]] = 1;
    }
  }
  int ans = 0;
  for (int i = 0; i < m; i++) {
    int pos = 0;
    while (coc[pos] != b[i]) {
      ans += w[coc[pos]];
      pos++;
    }
    for (int j = pos; j > 0; j--) {
      coc[j] = coc[j - 1];
    }
    coc[0] = b[i];
  }
  printf("%d\n", ans);
  return 0;
}
