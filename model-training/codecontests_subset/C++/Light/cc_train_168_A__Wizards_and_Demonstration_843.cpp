#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, x;
  cin >> a >> b >> c;
  if (a * c % 100 == 0)
    x = (a * c) / 100;
  else
    x = (a * c) / 100 + 1;
  if (x < b)
    cout << "0" << endl;
  else
    cout << x - b << endl;
  return 0;
}
