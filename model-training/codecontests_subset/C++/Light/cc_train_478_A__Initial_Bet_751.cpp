#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  int sum = a + b + c + d + e;
  if (sum % 5 == 0) {
    if (sum == 0)
      cout << "-1" << endl;
    else
      cout << sum / 5 << endl;
  } else
    cout << "-1" << endl;
}
