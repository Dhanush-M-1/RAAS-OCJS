#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, r = 0;
  cin >> a >> b;
  int rv = 0;
  while (a) {
    rv += a;
    r += a;
    a = r / b;
    r %= b;
  }
  cout << rv << endl;
  return 0;
}
