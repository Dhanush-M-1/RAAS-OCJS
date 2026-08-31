#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum, c;
  while (cin >> a >> b) {
    sum = a;
    while (b <= a) {
      c = a / b;
      sum += c;
      a = c + (a % b);
    }
    cout << sum << endl;
  }
}
