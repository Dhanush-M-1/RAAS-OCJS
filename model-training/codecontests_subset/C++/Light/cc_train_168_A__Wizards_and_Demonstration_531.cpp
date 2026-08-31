#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, w, p, i = 0;
  cin >> n >> w >> p;
  for (;; i++) {
    if (double(double(w + i) / n) >= double(double(p) / double(100))) {
      cout << i;
      break;
    }
  }
}
