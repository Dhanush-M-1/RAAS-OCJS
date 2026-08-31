#include <bits/stdc++.h>
using namespace std;
int main() {
  int q, a, b, c, num1, num2;
  cin >> q;
  while (q--) {
    cin >> a >> b >> c;
    num1 = min(a, b / 2);
    num2 = min(b, c / 2);
    int sum = 0;
    sum += num2;
    sum += min(a, (b - num2) / 2);
    cout << sum * 3 << endl;
  }
  return 0;
}
