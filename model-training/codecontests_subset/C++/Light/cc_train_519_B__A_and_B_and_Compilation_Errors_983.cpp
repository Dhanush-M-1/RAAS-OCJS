#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  long long a = 0, b = 0, c = 0, m;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> m;
    a += m;
  }
  for (i = 0; i < n - 1; i++) {
    cin >> m;
    b += m;
  }
  for (i = 0; i < n - 2; i++) {
    cin >> m;
    c += m;
  }
  cout << a - b << endl << b - c;
  return 0;
}
