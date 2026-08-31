#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, c, d;
  cin >> n;
  while (n--) {
    int i, j, k, w, q;
    cin >> a;
    long g, h, e[a], m = 0;
    for (i = 1; i <= a; i++) cin >> e[i];
    for (i = 2; i <= a - 1; i++) {
      if (e[i] + e[i - 1] <= e[a - i + 2]) {
        m++;
        g = i - 1;
        h = i;
        k = a - i + 2;
        break;
      }
    }
    if (m > 0) {
      cout << g << " " << h << " " << k << endl;
    } else {
      cout << "-1" << endl;
    }
  }
}
