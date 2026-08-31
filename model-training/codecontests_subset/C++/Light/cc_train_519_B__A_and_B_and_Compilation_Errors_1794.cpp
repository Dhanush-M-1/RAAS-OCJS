#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (cin >> n) {
    long s = 0, t = 0, tt = 0, a;
    for (__typeof(n) i = 0; i < (n); i++) {
      cin >> a;
      s += a;
    }
    for (__typeof(n - 1) i = 0; i < (n - 1); i++) {
      cin >> a;
      t += a;
    }
    for (__typeof(n - 2) i = 0; i < (n - 2); i++) {
      cin >> a;
      tt += a;
    }
    cout << s - t << "\n" << t - tt << endl;
  }
  return 0;
}
