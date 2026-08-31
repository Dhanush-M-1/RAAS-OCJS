#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 0, c, A, m, B;
  cin >> n >> c >> m;
  for (int i = 1; i < n; i++) {
    cin >> A;
    B = m - A - c;
    if (B > s) s = B;
    m = A;
  }
  cout << s;
}
