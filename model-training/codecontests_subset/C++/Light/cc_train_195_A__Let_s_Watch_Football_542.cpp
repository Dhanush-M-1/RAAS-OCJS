#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, res;
  cin >> a >> b >> c;
  res = (a - b) * c;
  if (res % b == 0)
    cout << res / b << endl;
  else
    cout << res / b + 1 << endl;
  return 0;
}
