#include <bits/stdc++.h>
using namespace std;
int a, b, c;
int main() {
  cin >> a >> b;
  while (a > 0) {
    if (a >= b) {
      a = a - b + 1;
      c = c + b;
    } else {
      c = c + a;
      break;
    }
  }
  cout << c;
}
