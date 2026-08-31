#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, h = 1e9;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    if (k % x == 0) {
      int y = k / x;
      if (y < h) {
        h = y;
      }
    }
  }
  cout << h;
}
