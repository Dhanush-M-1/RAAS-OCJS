#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = a, new_candles = a / b, remain = a % b;
  while (new_candles) {
    ans += new_candles;
    int extra = new_candles + remain;
    new_candles = (extra) / b;
    remain = extra % b;
  }
  cout << ans;
  return 0;
}
