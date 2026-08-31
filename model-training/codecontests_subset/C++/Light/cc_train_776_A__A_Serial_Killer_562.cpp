#include <bits/stdc++.h>
using namespace std;
const int maxn = 20;
string a;
string b;
string x;
string y;
int main() {
  int n;
  cin >> a;
  cin >> b;
  cout << a << ' ' << b << endl;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x >> y;
    if (x == a)
      a = b, b = y;
    else
      b = y;
    cout << a << ' ' << b << endl;
  }
  return 0;
}
