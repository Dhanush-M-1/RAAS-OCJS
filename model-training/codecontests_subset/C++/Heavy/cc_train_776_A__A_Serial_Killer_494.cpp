#include <bits/stdc++.h>
using namespace std;
string a[1005], b[1005], p1, p2;
int main() {
  int n, i;
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> a[0] >> b[0];
  cin >> n;
  cout << a[0] << " " << b[0] << endl;
  p1 = a[0];
  p2 = b[0];
  for (i = 1; i <= n; i++) {
    cin >> a[i] >> b[i];
    if (a[i] == p1) {
      p1 = p2;
      p2 = b[i];
    } else {
      if (a[i] == p2) {
        p2 = p1;
        p1 = b[i];
      } else {
        if (b[i] == p1) {
          p1 = p2;
          p2 = a[i];
        } else {
          p2 = p1;
          p1 = a[i];
        }
      }
    }
    cout << p1 << " " << p2 << endl;
  }
  return 0;
}
