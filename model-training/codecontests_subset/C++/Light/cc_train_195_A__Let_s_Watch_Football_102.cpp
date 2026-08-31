#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int t = ceil(1.0 * a * c / b);
  cout << max(0, t - c) << endl;
  return 0;
}
