#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int sum = 0, x = a, r = 0;
  while (x >= b) {
    sum = sum + x / b;
    x = x / b + x % b;
  }
  cout << sum + a;
}
