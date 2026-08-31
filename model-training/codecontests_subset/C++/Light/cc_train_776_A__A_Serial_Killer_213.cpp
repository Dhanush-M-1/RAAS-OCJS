#include <bits/stdc++.h>
const int N = 1005;
using namespace std;
string a, b, c, d;
int n;
int main() {
  cin >> a >> b;
  cin >> n;
  cout << a << ' ' << b << endl;
  for (int i = 0; i < n; i++) {
    cin >> c >> d;
    if (a == c)
      a = d;
    else if (b == c)
      b = d;
    cout << a << ' ' << b << endl;
  }
  return 0;
}
