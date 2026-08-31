#include <bits/stdc++.h>
using namespace std;
int a, b;
int sum;
int main() {
  cin >> a >> b;
  while (a >= b) {
    sum += a / b * b;
    a = a / b + a % b;
  }
  cout << sum + a;
  return 0;
}
