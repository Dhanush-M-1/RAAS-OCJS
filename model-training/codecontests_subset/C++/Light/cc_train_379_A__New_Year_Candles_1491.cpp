#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, i, j, k, sum = 0;
  cin >> a >> b;
  if (a < b)
    sum = a;
  else if (a == b)
    sum = a + 1;
  else {
    sum = a;
    int x = 0;
    while (a >= b) {
      sum = sum + (a / b);
      x = a % b;
      a = a / b + x;
    }
  }
  cout << sum;
  return 0;
}
