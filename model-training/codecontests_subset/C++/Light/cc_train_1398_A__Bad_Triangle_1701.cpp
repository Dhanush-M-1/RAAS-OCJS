#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    int a, b, c;
    cin >> a;
    cin >> b;
    for (int i = 0; i < n - 2; i++) {
      cin >> c;
    }
    if (a + b <= c) {
      cout << "1 2 " << n << endl;
    } else {
      cout << -1 << endl;
    }
  }
}
