#include <bits/stdc++.h>
using namespace std;
int main() {
  int numOfDays, lendingPrice;
  cin >> numOfDays >> lendingPrice;
  int arrOfPrices[numOfDays];
  int maxDifference = -100000000;
  int maxDifferenceStartIndex = 0;
  for (int i = 0; i < numOfDays; i++) {
    cin >> arrOfPrices[i];
  }
  for (int i = 0; i < numOfDays - 1; i++) {
    if (arrOfPrices[i] - arrOfPrices[i + 1] > maxDifference) {
      maxDifference = arrOfPrices[i] - arrOfPrices[i + 1];
      maxDifferenceStartIndex = i;
    }
  }
  int ans = arrOfPrices[maxDifferenceStartIndex] -
            arrOfPrices[maxDifferenceStartIndex + 1] - lendingPrice;
  if (ans >= 0)
    cout << ans;
  else
    cout << 0;
  return 0;
}
