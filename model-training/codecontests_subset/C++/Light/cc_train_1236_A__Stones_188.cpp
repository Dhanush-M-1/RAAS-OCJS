#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 50;
int a[MAXN];
int main() {
  ios::sync_with_stdio(false);
  int T;
  cin >> T;
  while (T--) {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = 0;
    while (1) {
      if (c >= 2 && b >= 1) {
        c -= 2;
        b -= 1;
        sum += 3;
      } else if (b >= 2 && a >= 1) {
        b -= 2;
        a -= 1;
        sum += 3;
      } else
        break;
    }
    cout << sum << endl;
  }
}
