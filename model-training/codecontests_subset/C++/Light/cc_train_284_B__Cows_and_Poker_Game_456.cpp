#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  string c;
  cin >> c;
  int ans = 0;
  bool flag = true;
  for (int i = (0); i <= (c.size()); i++) {
    if (flag) {
      (c[i] == 'A') ? ++ans : 0;
      if (c[i] == 'I') {
        flag = !flag;
        ans = 1;
      }
    } else {
      if (c[i] == 'I') {
        cout << "0";
        return 0;
      }
    }
  }
  cout << ans;
}
