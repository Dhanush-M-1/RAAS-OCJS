#include <bits/stdc++.h>
using namespace std;
int a, b, sum, x;
int main() {
  cin >> a >> b;
  while (a) {
    sum += a;
    x += a % b;
    a /= b;
    a += x / b;
    x %= b;
  }
  cout << sum;
  return 0;
}
