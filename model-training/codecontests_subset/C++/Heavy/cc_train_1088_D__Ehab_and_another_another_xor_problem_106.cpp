#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, j, k, i;
  int ans1 = 0, ans2 = 0, a = 0, b = 0;
  cout << "? " << ans1 << " " << ans2 << endl;
  cin >> k;
  for (i = 29; i >= 0; i--) {
    int op1 = ans1 + (1 << i);
    int op2 = ans2 + (1 << i);
    cout << "? " << op1 << " " << op2 << endl;
    cin >> j;
    if (j != k) {
      if (j == 1)
        b = b + (1 << i), ans2 = ans2 + (1 << i);
      else
        a = a + (1 << i), ans1 = ans1 + (1 << i);
      cout << "? " << ans1 << " " << ans2 << endl;
      cin >> k;
    } else {
      op1 = ans1 + (1 << i);
      op2 = ans2;
      cout << "? " << op1 << " " << op2 << endl;
      cin >> j;
      if (j == -1) a = a + (1 << i), b = b + (1 << i);
    }
  }
  cout << "! " << a << " " << b << '\n';
  return 0;
}
