#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int a, b, c;
  while (cin >> n) {
    int cnt;
    for (int i = 0; i < n; i++) {
      cin >> a >> b >> c;
      if (a <= c) {
        if (b >= c) {
          cnt = b / c + 1;
        } else {
          cnt = 1;
        }
      } else {
        cnt = 1;
      }
      cout << cnt * c << endl;
    }
  }
  return 0;
}
