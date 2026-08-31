#include <bits/stdc++.h>
using namespace std;
int main() {
  int t = 1;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    if (a * c % b == 0)
      cout << a * c / b - c;
    else
      cout << a * c / b + 1 - c;
  }
}
