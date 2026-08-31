#include <bits/stdc++.h>
int main() {
  int N;
  scanf("%d", &N);
  for (int i = 0; i < N; i++) {
    int l, r, d, ans = 0;
    scanf("%d %d %d", &l, &r, &d);
    if (l > d)
      ans = d;
    else
      ans = r + 1;
    if (ans % d) ans += (d - ans % d);
    printf("%d\n", ans);
  }
  return 0;
}
