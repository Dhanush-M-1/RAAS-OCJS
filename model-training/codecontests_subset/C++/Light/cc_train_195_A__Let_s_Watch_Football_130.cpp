#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int a, b, c;
  cin >> a >> b >> c;
  for (int i = 1;; i++) {
    int sum = i * b;
    bool p = true;
    for (int j = 0; j < c; j++) {
      sum += b;
      sum -= a;
      if (sum < 0) {
        p = false;
        break;
      }
    }
    if (p) {
      cout << i;
      return 0;
    }
  }
  return 0;
}
