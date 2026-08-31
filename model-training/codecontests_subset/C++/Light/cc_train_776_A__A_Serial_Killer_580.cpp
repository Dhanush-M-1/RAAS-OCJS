#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  int n;
  cout << a << ' ' << b << endl;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    string c, d;
    cin >> c >> d;
    if (a == c)
      a = d;
    else if (b == c)
      b = d;
    cout << a << ' ' << b << endl;
  }
  return 0;
}
