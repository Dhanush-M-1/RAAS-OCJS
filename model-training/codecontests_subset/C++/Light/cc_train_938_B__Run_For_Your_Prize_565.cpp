#include <bits/stdc++.h>
int main() {
  int count;
  scanf("%d", &count);
  int lastPrize1 = 1;
  int lastPrize2 = 1000000;
  for (int i = 0; i < count; i++) {
    int prize;
    scanf("%d", &prize);
    if (prize <= 500000) {
      lastPrize1 = std::max(lastPrize1, prize);
    } else {
      lastPrize2 = std::min(lastPrize2, prize);
    }
  }
  int maxTime = std::max(lastPrize1 - 1, 1000000 - lastPrize2);
  printf("%d", maxTime);
  return 0;
}
