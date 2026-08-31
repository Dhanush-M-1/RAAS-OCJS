#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e, s = 0;
  cin >> a >> b >> c >> d >> e;
  s = a + b + c + d + e;
  if (s == 0)
    cout << "-1";
  else if (s % 5 == 0)
    cout << s / 5;
  else
    cout << "-1";
  return 0;
}
