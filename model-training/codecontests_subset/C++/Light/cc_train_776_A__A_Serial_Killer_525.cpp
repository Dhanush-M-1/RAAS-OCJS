#include <bits/stdc++.h>
using namespace std;
const int maxn = 100050;
string a, b, c;
int n;
int main() {
  cin.sync_with_stdio(false);
  cin >> a >> b >> n;
  for (int i = 1; i <= n; ++i) {
    cout << a << ' ' << b << endl;
    cin >> c;
    if (c == a)
      cin >> a;
    else
      cin >> b;
  }
  cout << a << ' ' << b << endl;
  return 0;
}
