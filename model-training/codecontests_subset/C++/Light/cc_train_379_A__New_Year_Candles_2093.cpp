#include <bits/stdc++.h>
using namespace std;
int a, b, ans;
int main() {
  cin >> a >> b;
  while (a >= b) {
    ans += (a / b) * b;
    a = (a / b) + (a % b);
  }
  ans += a;
  cout << ans;
}
