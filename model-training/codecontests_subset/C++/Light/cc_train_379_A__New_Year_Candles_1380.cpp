#include <bits/stdc++.h>
using namespace std;
int new_year_candles(int a, int b) {
  int new_a;
  if (a / b >= 1) {
    new_a = a / b + a % b;
  } else {
    new_a = a;
  }
  return new_a;
}
int main(int argc, char** argv) {
  int a, b, result;
  cin >> a;
  cin >> b;
  result = 0;
  result += a;
  for (;;) {
    int res;
    res = a / b;
    a = new_year_candles(a, b);
    result += res;
    if (a < b) {
      break;
    }
  }
  cout << result;
  return 0;
}
