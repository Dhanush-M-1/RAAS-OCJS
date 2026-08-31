#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k, m, i, a;
  m = 0;
  cin >> n >> k;
  for (i = 0; i < n; i++) {
    cin >> a;
    if ((k % a == 0) && (a > m)) m = a;
  }
  a = k / m;
  cout << a;
  return 0;
}
