#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int rez = 0;
  int count = a;
  while (a >= b) {
    if (a % b == 0) {
      count += a / b;
      a = a / b;
    } else {
      count += a / b;
      a = a / b + a % b;
    }
  }
  cout << count;
  return 0;
}
