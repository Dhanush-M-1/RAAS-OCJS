#include <bits/stdc++.h>
int main() {
  int n, c, amount = 0, i = 0, element, max = 0, tmp;
  std::vector<int> prices;
  std::cin >> n >> c;
  do {
    std::cin >> element;
    prices.push_back(element);
    i++;
  } while (i < n);
  for (int j = 0; j < prices.size() - 1; j++) {
    amount = prices[j];
    if (prices[j + 1] <= amount) {
      tmp = amount - prices[j + 1] - c;
      if (tmp > max) max = tmp;
    }
  }
  std::cout << max;
  return 0;
}
