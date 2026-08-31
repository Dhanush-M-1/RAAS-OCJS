#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  int n;
  cin >> n;
  cout << a << " " << b << endl;
  while (n-- > 0) {
    string old, nw;
    cin >> old >> nw;
    if (a == old)
      a = nw;
    else
      b = nw;
    cout << a << " " << b << endl;
  }
}
