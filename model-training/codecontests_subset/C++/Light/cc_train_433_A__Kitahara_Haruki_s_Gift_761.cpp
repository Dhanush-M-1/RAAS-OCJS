#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a = 0, b = 0, x;
  cin >> n;
  while (n--) {
    cin >> x;
    ((x == 100) ? ++a : ++b);
  }
  if (a & 1)
    cout << "NO";
  else {
    cout << (((a % 2 == 0 && b % 2 == 0) || ((a % 2 == 0 && a > 0) && b & 1))
                 ? "YES"
                 : "NO");
  }
  return 0;
}
