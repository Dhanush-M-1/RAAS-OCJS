#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    if (b >= a)
      cout << c << endl;
    else {
      int temp = a * c / b;
      if (temp * b != a * c)
        cout << temp - c + 1 << endl;
      else
        cout << temp - c << endl;
    }
  }
  return 0;
}
