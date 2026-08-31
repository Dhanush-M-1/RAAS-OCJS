#include <bits/stdc++.h>
using namespace std;
void solve() {
  int a, b;
  cin >> a >> b;
  int n = a, r = 0, s = 0;
  while (n || r >= b) {
    s += n;
    r += n;
    n = 0;
    n += r / b;
    r = r % b;
  }
  cout << s;
}
int main() {
  solve();
  return 0;
}
