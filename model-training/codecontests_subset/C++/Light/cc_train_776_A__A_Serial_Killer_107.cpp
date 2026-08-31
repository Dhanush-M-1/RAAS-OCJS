#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, ta, tb;
  cin >> a >> b;
  int n;
  scanf("%d", &n);
  cout << a << ' ' << b << endl;
  for (int i = 0; i < n; i++) {
    cin >> ta >> tb;
    if (a == ta)
      a = tb;
    else
      b = tb;
    cout << a << ' ' << b << endl;
  }
}
