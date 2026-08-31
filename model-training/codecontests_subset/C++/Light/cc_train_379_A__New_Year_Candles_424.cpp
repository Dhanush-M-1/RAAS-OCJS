#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum, mod;
  cin >> a >> b;
  sum = a;
  while (a >= b) {
    int div = a / b;
    sum = sum + div;
    mod = a % b;
    a = mod + div;
  }
  cout << sum;
}
