#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  cout << max(0, int(ceil(a * c / 100) - b)) << endl;
  return 0;
}
