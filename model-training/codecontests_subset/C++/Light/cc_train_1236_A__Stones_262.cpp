#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, res = 0, tem;
    cin >> a >> b >> c;
    tem = min(b, c / 2);
    res = tem + tem * 2;
    b -= tem;
    tem = min(a, b / 2);
    res += tem + tem * 2;
    cout << res << endl;
  }
  return 0;
}
