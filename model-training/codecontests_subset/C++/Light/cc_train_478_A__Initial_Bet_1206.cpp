#include <bits/stdc++.h>
using namespace std;
int main() {
  int c, sum = 0;
  for (int i = 1; i <= 5; i++) {
    cin >> c;
    sum += c;
  }
  if (sum % 5 != 0 || sum == 0) {
    cout << -1;
    return 0;
  }
  cout << sum / 5;
  return 0;
}
