#include <bits/stdc++.h>
using namespace std;
const int max_n = 2e5 + 5;
string a, b;
int n;
int main() {
  cin >> a >> b >> n;
  cout << a << " " << b << endl;
  while (n--) {
    string x, y;
    cin >> x >> y;
    if (a == x) a = y;
    if (b == x) b = y;
    cout << a << " " << b << endl;
  }
  return 0;
}
