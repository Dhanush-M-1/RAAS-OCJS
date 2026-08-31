#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, x = 0, y = 0;
  string a;
  cin >> n >> a;
  for (int i = 0; i < n; i++) {
    if (a[i] == 'I') {
      x++;
      if (x == 2) {
        cout << "0";
        return 0;
      }
    } else if (a[i] == 'A') {
      y++;
    }
  }
  if (x == 1) {
    cout << "1";
  } else
    cout << y;
  return 0;
}
