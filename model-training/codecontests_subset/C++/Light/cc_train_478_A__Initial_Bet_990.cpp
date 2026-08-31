#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, f;
  cin >> a >> b >> c >> d >> f;
  int sum = a + b + c + d + f;
  if (sum == 0)
    cout << -1;
  else if (sum % 5 == 0) {
    cout << sum / 5;
  } else
    cout << -1;
  return 0;
}
