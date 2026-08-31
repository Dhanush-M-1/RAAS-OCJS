#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  cin >> a >> b;
  int ans = a;
  while (a >= b) {
    int tmp = 0;
    if (a % b != 0) tmp = a % b;
    a /= b;
    ans += a;
    a += tmp;
  }
  cout << ans;
}
