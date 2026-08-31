#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, x, y, z, a, b, sum = 0, sum1 = 0, sum2 = 0;
  cin >> t;
  a = t - 1;
  b = t - 2;
  for (int i = 0; i < t; i++) {
    cin >> x;
    sum += x;
  }
  for (int i = 0; i < a; i++) {
    cin >> y;
    sum1 += y;
  }
  for (int i = 0; i < b; i++) {
    cin >> z;
    sum2 += z;
  }
  cout << sum - sum1 << endl;
  cout << sum1 - sum2 << endl;
  return 0;
}
