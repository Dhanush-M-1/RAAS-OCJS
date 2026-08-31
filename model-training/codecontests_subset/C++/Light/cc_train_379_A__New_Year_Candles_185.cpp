#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int sum = a;
  while (a >= b) {
    sum += a / b;
    a = a / b + a % b;
  }
  cout << sum;
}
