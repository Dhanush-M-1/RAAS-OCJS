#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, i, j, k, l, m, n, t, ans = 0;
  cin >> n >> a >> b >> c;
  double aa = a * .5;
  t = 0;
  for (j = 0; j <= b; j++) {
    for (k = 0; k <= c; k++) {
      t = j * 1 + k * 2;
      m = n - t;
      if (m < 0) {
        continue;
      } else if (m >= 0) {
        if (aa >= m) ans++;
      }
    }
  }
  long long int answ = (double)(ans);
  cout << answ << endl;
}
