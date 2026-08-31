#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c[2], t;
  while (cin >> n) {
    c[0] = c[1] = 0;
    for (int i = 0; i < n; i++) cin >> t, c[t / 100 - 1]++;
    if ((c[0] & 1) || ((c[1] & 1) && !c[0]) || (n == 1))
      cout << "NO";
    else
      cout << "YES";
    cout << endl;
  }
}
