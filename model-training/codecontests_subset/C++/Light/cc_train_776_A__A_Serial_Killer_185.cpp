#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
string a, b, c, d;
int n;
int main() {
  while (cin >> a >> b) {
    cout << a << " " << b << endl;
    cin >> n;
    for (int i = 0; i < n; i++) {
      cin >> c >> d;
      if (a == c)
        a = d;
      else
        b = d;
      cout << a << " " << b << endl;
    }
  }
  return 0;
}
