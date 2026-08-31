#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  a *= c;
  a -= b * c;
  if (a % b == 0)
    cout << a / b;
  else
    cout << a / b + 1;
  return 0;
}
