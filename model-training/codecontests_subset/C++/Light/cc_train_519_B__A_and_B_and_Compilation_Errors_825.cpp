#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, x, sum1 = 0, sum2 = 0, sum3 = 0, i;
  cin >> t;
  for (i = 0; i < t; i++) {
    cin >> x;
    sum1 = sum1 + x;
  }
  for (i = 0; i < t - 1; i++) {
    cin >> x;
    sum2 = sum2 + x;
  }
  for (i = 0; i < t - 2; i++) {
    cin >> x;
    sum3 = sum3 + x;
  }
  cout << sum1 - sum2 << endl << sum2 - sum3 << endl;
  return 0;
}
