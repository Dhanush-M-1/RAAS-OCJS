#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int n = 0;
    if (b < c / 2) {
      n += 3 * b;
      b = 0;
    } else {
      n += c / 2 + c - ((c % 2 == 0) ? 0 : 1);
      b -= c / 2;
    }
    if (a < b / 2) {
      n += 3 * a;
    } else {
      n += b / 2 + b - ((b % 2 == 0) ? 0 : 1);
    }
    cout << n;
    cout << endl;
  }
  return 0;
}
