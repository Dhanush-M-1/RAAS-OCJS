#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, fol, rem = 0;
  cin >> a >> b;
  fol = a;
  while (a >= b) {
    fol = fol + (a / b);
    a = (a / b) + (a % b);
  }
  cout << fol << endl;
}
