#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int count = a;
  int num_of_candles = a, went_out = 0;
  while (went_out >= 0) {
    went_out += num_of_candles;
    if (went_out / b == 0) break;
    num_of_candles = went_out / b;
    went_out -= b * num_of_candles;
    count += num_of_candles;
  }
  cout << count << endl;
  return 0;
}
