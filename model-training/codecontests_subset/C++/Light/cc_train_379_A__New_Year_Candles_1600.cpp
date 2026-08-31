#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int hr = a;
  while (a >= b) {
    hr += a / b;
    a = a / b + a % b;
  }
  cout << hr;
  return 0;
}
