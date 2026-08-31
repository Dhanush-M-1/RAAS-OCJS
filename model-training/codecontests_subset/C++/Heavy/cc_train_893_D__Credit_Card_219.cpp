#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int a[N];
int main() {
  bool flag;
  int n, d;
  int minn, maxn, sum, y;
  while (cin >> n >> d) {
    flag = 0;
    maxn = 0;
    minn = 0;
    y = 0;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      if (!flag) {
        if (a[i] == 0) {
          if (minn < 0) minn = 0;
          if (maxn < 0) {
            y++;
            minn = 0;
            maxn = d;
          }
        } else {
          minn += a[i];
          maxn += a[i];
          maxn = min(d, maxn);
          if (minn > d) {
            flag = 1;
          }
        }
      }
    }
    if (flag)
      cout << "-1" << endl;
    else
      cout << y << endl;
  }
}
