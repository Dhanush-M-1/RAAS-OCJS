#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  int d = ceil(a * c / 100 - b);
  cout << max(0, d) << endl;
  return 0;
}
