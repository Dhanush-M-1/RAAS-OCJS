#include <bits/stdc++.h>
using namespace std;
void Solve() {
  int a, b, c, s = 0;
  cin >> a >> b >> c;
  while (c >= 2 && b >= 1) {
    c = c - 2;
    b--;
    s += 3;
  }
  while (a >= 1 && b >= 2) {
    b -= 2;
    a--;
    s += 3;
  }
  cout << s << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) Solve();
}
