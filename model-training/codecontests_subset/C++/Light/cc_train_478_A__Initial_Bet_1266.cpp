#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e, sum = 0;
  cin >> a >> b >> c >> d >> e;
  sum = a + b + c + d + e;
  if (sum == 0) {
    cout << "-1" << endl;
  } else if (sum % 5 == 0) {
    cout << sum / 5 << endl;
  } else
    cout << "-1" << endl;
  return 0;
}
