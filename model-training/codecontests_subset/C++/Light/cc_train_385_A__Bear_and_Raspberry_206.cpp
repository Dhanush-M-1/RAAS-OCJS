#include <bits/stdc++.h>
using namespace std;
int x, y, maxx, w[101];
int main() {
  cin >> x >> y;
  for (int i = 0; i < x; i++) {
    cin >> w[i];
    if (i == 1) maxx = w[i - 1] - w[i];
    if (i > 1) maxx = max(w[i - 1] - w[i], maxx);
  }
  for (int i = 1; i < x; i++) {
    if (w[i - 1] - w[i] == maxx) {
      if (w[i - 1] - w[i] - y >= 0) {
        cout << w[i - 1] - w[i] - y;
        return 0;
      }
      if (w[i - 1] - w[i] - y < 0) {
        cout << 0;
        return 0;
      }
    }
  }
  return 0;
}
