#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  cin >> n >> k;
  int m, min = 100000;
  while (n--) {
    cin >> m;
    if (k % m == 0 && (k / m) < min) min = k / m;
  }
  cout << min;
}
