#include <bits/stdc++.h>
using namespace std;
string a, b, c, d;
int main() {
  int i;
  cin >> a >> b;
  int n;
  scanf("%d", &n);
  cout << a << ' ' << b << endl;
  for (i = 1; i <= n; i++) {
    cin >> c >> d;
    if (a == c) {
      a = d;
    } else {
      b = d;
    }
    cout << a << ' ' << b << endl;
  }
  return 0;
}
