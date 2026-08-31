#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  scanf("%d %d", &n, &c);
  int prev;
  scanf("%d", &prev);
  int profit = 0;
  for (int i = 1; i < n; i++) {
    int curr;
    scanf("%d", &curr);
    profit = max(profit, prev - curr - c);
    prev = curr;
  }
  printf("%d\n", profit);
  return 0;
}
