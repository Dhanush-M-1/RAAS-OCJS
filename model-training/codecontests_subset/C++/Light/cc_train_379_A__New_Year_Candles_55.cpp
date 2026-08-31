#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, count = 0;
  cin >> a >> b;
  count += a;
  while (a / b > 0) {
    count += (a / b);
    a = (a / b) + (a % b);
  }
  cout << count;
  return 0;
}
