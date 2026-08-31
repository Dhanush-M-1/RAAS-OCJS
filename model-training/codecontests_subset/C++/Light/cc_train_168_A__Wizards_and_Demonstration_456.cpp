#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, w, p;
  cin >> n >> w >> p;
  int m = n * 0.01 * p;
  if (((n * p) % 100) != 0) m++;
  if (m == w || m < w) {
    cout << 0;
    return 0;
  } else
    cout << m - w;
}
