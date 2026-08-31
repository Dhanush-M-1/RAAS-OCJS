#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, num = 0;
  cin >> a >> b;
  num += a;
  while (a / b > 0) {
    num += a / b;
    a = a / b + a % b;
  }
  cout << num << endl;
  return 0;
}
