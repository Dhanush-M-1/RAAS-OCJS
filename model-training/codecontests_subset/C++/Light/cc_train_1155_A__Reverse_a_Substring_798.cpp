#include <bits/stdc++.h>
using namespace std;
int main() {
  int c = 0, y, n, i, j;
  string x;
  cin >> n >> x;
  for (i = 0; i < n - 1; i++) {
    if (x[i] > x[i + 1]) {
      cout << "YES\n" << i + 1 << " " << i + 2;
      c = 1;
      break;
    }
  }
  if (c == 0) cout << "NO";
  return 0;
}
