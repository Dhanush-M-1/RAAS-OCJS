#include <bits/stdc++.h>
using namespace std;
const int maxn = 200 + 5;
int n, m;
int he[maxn];
bool cur[maxn];
int main() {
  scanf("%d%d", &m, &n);
  memset(cur, false, 103 * sizeof(bool));
  for (int i = 1; i <= m; i++) {
    int k, kk;
    scanf("%d", &k);
    for (int j = 1; j <= k; j++) {
      scanf("%d", &kk);
      cur[kk] += 1;
    }
  }
  bool ss = 1;
  for (int i = 1; i <= n; i++) {
    if (cur[i] == 0) ss = 0;
  }
  if (ss) {
    printf("Yes");
    exit(0);
  }
  printf("No");
  return 0;
}
