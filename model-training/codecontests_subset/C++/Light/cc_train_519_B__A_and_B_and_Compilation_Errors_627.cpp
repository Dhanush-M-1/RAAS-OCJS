#include <bits/stdc++.h>
using namespace std;
long long i, a, b, c, r, n;
int main() {
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> r;
    a += r;
  }
  for (i = 1; i <= n - 1; i++) {
    cin >> r;
    b += r;
  }
  for (i = 1; i <= n - 2; i++) {
    cin >> r;
    c += r;
  }
  cout << a - b << endl;
  cout << b - c << endl;
}
