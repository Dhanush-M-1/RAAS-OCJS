#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, ans, x, cnt, need;
  while (cin >> a >> b >> c) {
    need = c / 100.0;
    cnt = ceil(a * need);
    ans = cnt - b;
    x = 0;
    cout << max(x, ans) << endl;
  }
  return 0;
}
