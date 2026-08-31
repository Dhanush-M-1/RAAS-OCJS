#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  cout << int(c * (a - b) / b + 0.99999) << endl;
  return 0;
}
