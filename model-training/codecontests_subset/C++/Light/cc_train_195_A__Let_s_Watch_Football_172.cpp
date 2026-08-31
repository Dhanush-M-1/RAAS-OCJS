#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, a, b, c, s;
  while (cin >> a >> b >> c) {
    s = a * c;
    int min = b * c;
    int n = s - min;
    if (n % b == 0)
      n = n / b;
    else
      n = n / b + 1;
    cout << n << endl;
  }
}
