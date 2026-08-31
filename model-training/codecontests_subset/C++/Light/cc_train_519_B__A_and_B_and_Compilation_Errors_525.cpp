#include <bits/stdc++.h>
using namespace std;
int main(void) {
  ;
  int n, t;
  long long a, b, c;
  cin >> n;
  a = b = c = 0LL;
  for (int i = 0; i < n; i++) {
    cin >> t;
    a += t;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> t;
    b += t;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> t;
    c += t;
  }
  cout << a - b << endl;
  cout << b - c << endl;
  return 0;
}
