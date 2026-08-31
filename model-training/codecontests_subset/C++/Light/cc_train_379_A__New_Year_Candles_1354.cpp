#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  while (cin >> a >> b) {
    int m = a;
    while (a / b > 0) {
      m += a / b;
      a = a % b + a / b;
    }
    cout << m << endl;
  }
  return 0;
}
