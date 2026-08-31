#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum = 0;
  cin >> a >> b;
  sum += a;
  while (a > 0) {
    sum += a / b;
    a = a / b + a % b;
    if (a < b) break;
  }
  cout << sum;
  return 0;
}
