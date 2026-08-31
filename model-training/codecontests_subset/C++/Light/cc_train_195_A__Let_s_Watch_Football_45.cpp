#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  while (cin >> a >> b >> c) {
    double m = a * c;
    cout << ceil(m / b) - c << endl;
  }
}
