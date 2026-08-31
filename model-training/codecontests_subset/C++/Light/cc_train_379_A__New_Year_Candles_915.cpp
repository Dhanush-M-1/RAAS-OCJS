#include <bits/stdc++.h>
using namespace std;
const double PI =
    3.14159265358979323846264338327950288419716939937510582097494459230;
int main() {
  int a, b, i, n, j, k;
  cin >> a >> b;
  int cond = (a / b + a % b) / b;
  int sum = a + a / b;
  while (cond) {
    cond = (a / b + a % b) / b;
    sum += cond;
    a = a / b + a % b;
  }
  cout << sum;
  return 0;
}
