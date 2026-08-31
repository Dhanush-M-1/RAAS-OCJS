#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, hours = 0, mod = 0, i = 0;
  cin >> a >> b;
  while (a) {
    hours += a;
    mod += (a % b);
    a = a / b;
    ++i;
    if (a == 0) {
      a = (mod / b);
      mod = mod % b;
    }
  }
  cout << hours;
}
