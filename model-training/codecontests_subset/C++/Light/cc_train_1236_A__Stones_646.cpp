#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int op2 = min(b, c / 2);
    b -= op2;
    c -= op2 * 2;
    int op1 = min(a, b / 2);
    int res = (op1 + op2) * 3;
    cout << res << "\n";
  }
  return 0;
}
