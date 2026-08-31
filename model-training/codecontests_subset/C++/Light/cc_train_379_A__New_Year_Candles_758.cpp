#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, count;
  cin >> a >> b;
  count = a;
  if (b > a) {
    cout << count << endl;
    return 0;
  }
  while (a > 1 && a >= b) {
    count += a / b;
    a = a / b + a % b;
  }
  cout << count << endl;
  return 0;
}
