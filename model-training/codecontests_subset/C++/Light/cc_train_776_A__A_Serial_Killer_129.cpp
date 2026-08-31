#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  string a, b;
  cin >> a >> b;
  if (a > b) swap(a, b);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cout << a << " " << b << "\n";
    string c, d;
    cin >> c >> d;
    if (c > d) swap(c, d);
    if (a == c) {
      a = d;
    } else if (a == d) {
      a = c;
    } else if (b == c) {
      b = d;
    } else {
      b = c;
    }
  }
  cout << a << " " << b << "\n";
  return 0;
}
