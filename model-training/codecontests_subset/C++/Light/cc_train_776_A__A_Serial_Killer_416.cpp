#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string a, b, foo, bar;
  cin >> a >> b >> n;
  while (n--) {
    cout << a << " " << b << endl;
    cin >> foo >> bar;
    if (foo == a)
      a = bar;
    else
      b = bar;
  }
  cout << a << " " << b << endl;
  return 0;
}
