#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, v, l, y;
  cin >> a >> b;
  int ans = a;
  v = a;
  while (v >= b) {
    y = v % b;
    v = v / b;
    ans += v;
    v = v + y;
  }
  cout << ans << endl;
}
