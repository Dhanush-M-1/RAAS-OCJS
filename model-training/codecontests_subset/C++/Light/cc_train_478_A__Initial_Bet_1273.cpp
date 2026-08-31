#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, c3, c4, c5, sum;
  while (cin >> c1 >> c2 >> c3 >> c4 >> c5) {
    sum = c1 + c2 + c3 + c4 + c5;
    if (sum % 5 != 0 || sum == 0)
      cout << "-1" << endl;
    else
      cout << sum / 5 << endl;
  }
  return 0;
}
