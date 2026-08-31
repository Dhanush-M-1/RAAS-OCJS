#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, b = 0;
  cin >> a >> b;
  int n_candles = a;
  while (a / b) {
    n_candles += a / b;
    a = (a / b) + (a % b);
  }
  cout << n_candles << endl;
  return 0;
}
