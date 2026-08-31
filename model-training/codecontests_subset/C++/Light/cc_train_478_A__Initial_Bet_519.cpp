#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e, sum;
  cin >> a >> b >> c >> d >> e;
  sum = a + b + c + d + e;
  if (sum % 5 == 0 && sum != 0)
    cout << sum / 5;
  else if (sum % 5 != 0 || sum == 0)
    cout << -1;
}
