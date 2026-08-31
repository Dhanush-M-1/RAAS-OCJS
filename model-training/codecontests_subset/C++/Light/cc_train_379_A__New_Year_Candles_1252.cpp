#include <bits/stdc++.h>
using namespace std;
int main() {
  int candles, candleshr, rem = 0;
  cin >> candles >> candleshr;
  int totalcandles = candles;
  while (candles >= candleshr) {
    totalcandles += (candles / candleshr);
    rem = candles % candleshr;
    candles /= candleshr;
    candles += rem;
  }
  cout << totalcandles << endl;
}
