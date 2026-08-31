#include <bits/stdc++.h>
using namespace std;
int main() {
  int b, x;
  double a, c;
  cin >> a >> b >> c;
  x = ceil(a * (c / 100));
  cout << max(0, x - b) << endl;
  return 0;
}
