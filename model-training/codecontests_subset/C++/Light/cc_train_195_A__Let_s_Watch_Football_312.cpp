#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, t, k;
  while (cin >> a >> b >> c) {
    t = a * c;
    if (t % b == 0)
      k = t / b;
    else
      k = t / b + 1;
    cout << k - c << endl;
  }
}
