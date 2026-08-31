#include <bits/stdc++.h>
using namespace std;
int main() {
  int candle, abmged_days, counter = 0;
  cin >> candle >> abmged_days;
  while (candle--) {
    counter++;
    if (counter % abmged_days == 0) {
      candle++;
    }
  }
  cout << counter << endl;
  return 0;
}
