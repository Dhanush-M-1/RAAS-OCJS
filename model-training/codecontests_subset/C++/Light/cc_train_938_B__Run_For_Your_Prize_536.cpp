#include <bits/stdc++.h>
int main() {
  int ans = 0;
  int count;
  scanf("%d", &count);
  for (int i = 0; i < count; i++) {
    int prize;
    scanf("%d", &prize);
    int minTimeToPrize = std::min(prize - 1, 1000000 - prize);
    ans = std::max(ans, minTimeToPrize);
  }
  printf("%d", ans);
  return 0;
}
