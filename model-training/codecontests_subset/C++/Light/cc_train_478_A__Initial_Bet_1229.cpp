#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, sum = 0;
  cin >> c1 >> c2 >> c3 >> c4 >> c5;
  sum += c1;
  sum += c2;
  sum += c3;
  sum += c4;
  sum += c5;
  if (sum % 5 == 0 && sum > 0) {
    cout << sum / 5;
  } else {
    cout << -1;
  }
  return 0;
}
