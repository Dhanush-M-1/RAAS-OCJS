#include <bits/stdc++.h>
using namespace std;
int N, D, mx, mn, ans;
int main() {
  scanf("%d %d", &N, &D);
  for (int i = 0; i < N; i++) {
    int l;
    scanf("%d", &l);
    if (l == 0) {
      if (mn < 0) mn = 0;
      if (mx < 0) {
        mx = D;
        ans++;
      }
    }
    mx += l;
    mn += l;
    if (mx > D) mx = D;
    if (mn > D) {
      printf("-1\n");
      return 0;
    }
  }
  printf("%d\n", ans);
  return 0;
}
