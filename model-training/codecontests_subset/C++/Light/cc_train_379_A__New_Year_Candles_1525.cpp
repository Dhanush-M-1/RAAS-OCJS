#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, i, j, hour;
  cin >> a >> b;
  hour = a;
  while (a >= 1) {
    a = a / b;
    hour = hour + a;
  }
  int ans = hour;
  cout << ans;
}
