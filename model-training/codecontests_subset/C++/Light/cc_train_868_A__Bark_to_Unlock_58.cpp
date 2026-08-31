#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b[200];
  int n;
  cin >> a;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> b[i];
  }
  int c1 = 0, c2 = 0;
  for (int i = 1; i <= n; i++) {
    if (b[i] == a) {
      cout << "YES" << endl;
      return 0;
    }
    if (b[i][0] == a[1]) c1 = 1;
    if (b[i][1] == a[0]) c2 = 1;
  }
  if (c1 + c2 == 2) {
    cout << "YES" << endl;
  } else {
    cout << "NO" << endl;
  }
}
