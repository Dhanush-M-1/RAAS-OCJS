#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  while (cin >> n) {
    int minn = 0;
    for (int i = 1; i <= n; i++) {
      cin >> x;
      int a = x - 1;
      int b = 1000000 - x;
      int tm = min(a, b);
      minn = max(minn, tm);
    }
    cout << minn << endl;
  }
  return 0;
}
