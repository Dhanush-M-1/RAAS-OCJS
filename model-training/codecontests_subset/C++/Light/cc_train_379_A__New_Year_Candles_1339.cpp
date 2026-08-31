#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, cnt = 0;
  cin >> a >> b;
  cnt += a;
  while (a >= b) {
    cnt += a / b;
    a = a / b + a % b;
  }
  cout << cnt << endl;
  return 0;
}
