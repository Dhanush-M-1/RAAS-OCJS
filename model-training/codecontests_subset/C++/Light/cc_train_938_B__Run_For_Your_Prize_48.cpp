#include <bits/stdc++.h>
bool prizes[1000001];
int main() {
  int count;
  scanf("%d", &count);
  for (int i = 0; i < count; i++) {
    int prize;
    scanf("%d", &prize);
    prizes[prize] = true;
  }
  int lastPrize1 = 1;
  for (int i = 2; i <= 500000; i++) {
    if (prizes[i]) {
      lastPrize1 = i;
    }
  }
  int lastPrize2 = 1000000;
  for (int i = 999999; i >= 500001; i--) {
    if (prizes[i]) {
      lastPrize2 = i;
    }
  }
  int maxTime = std::max(lastPrize1 - 1, 1000000 - lastPrize2);
  printf("%d", maxTime);
  return 0;
}
