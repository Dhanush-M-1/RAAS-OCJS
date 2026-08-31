#include <bits/stdc++.h>
using namespace std;
int main() {
  long long i, j, n, k, l, m, b, c;
  string s, h, o;
  cin >> s >> h;
  cin >> n;
  for (i = 0; i <= n; i++) {
    cout << s << " " << h << endl;
    if (i == n) return 0;
    cin >> o;
    if (o == s) {
      cin >> o;
      s = o;
    } else {
      cin >> o;
      h = o;
    }
  }
}
