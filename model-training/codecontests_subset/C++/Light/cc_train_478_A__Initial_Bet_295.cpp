#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, d, e;
  int sum;
  while (cin >> a >> b >> c >> d >> e) {
    sum = a + b + c + d + e;
    if (sum % 5 == 0 && sum >= 5) {
      cout << sum / 5 << endl;
    } else {
      cout << -1 << endl;
    }
  }
  return 0;
}
