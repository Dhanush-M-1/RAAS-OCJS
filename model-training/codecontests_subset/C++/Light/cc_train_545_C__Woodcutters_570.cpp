#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int x[n];
  int h[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  if (n == 1) {
    cout << 1 << "\n";
  } else if (n == 2) {
    cout << 2 << "\n";
  } else {
    int fall[n];
    fall[0] = x[0];
    fall[n - 1] = x[n - 1];
    int cnt = 2;
    for (int i = 1; i < n - 1; i++) {
      if (h[i] < (x[i] - fall[i - 1])) {
        fall[i] = x[i];
        cnt++;
      } else if (h[i] < x[i + 1] - x[i]) {
        fall[i] = x[i] + h[i];
        cnt++;
      } else {
        fall[i] = x[i];
      }
    }
    cout << cnt << "\n";
  }
}
