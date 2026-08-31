#include <bits/stdc++.h>
using namespace std;
int main() {
  string m, n, p, q;
  int i;
  cin >> m >> n;
  cout << m << " " << n << endl;
  cin >> i;
  for (; i > 0; i--) {
    cin >> p >> q;
    if (p == m)
      m = q;
    else if (p == n)
      n = q;
    else if (q == m)
      m = p;
    else
      n = p;
    cout << m << " " << n << endl;
  }
}
