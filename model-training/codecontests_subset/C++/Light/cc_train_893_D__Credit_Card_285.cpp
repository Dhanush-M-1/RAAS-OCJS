#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, d, a[100005], b[100005], s = 0, f = 0, l = 0, k = 0;
  cin >> n >> d;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n; i++) {
    if (a[i] != 0) {
      s += a[i];
      if (s > d) {
        cout << "-1";
        f = 1;
        break;
      }
    } else {
      if (s < 0) s = 0;
    }
  }
  if (f == 0) {
    s = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] != 0) {
        if ((s + a[i]) > d) {
          s = d;
        } else
          s += a[i];
      } else {
        if (s < 0) {
          s = d;
          l++;
        }
      }
    }
    cout << l;
  }
  return 0;
}
