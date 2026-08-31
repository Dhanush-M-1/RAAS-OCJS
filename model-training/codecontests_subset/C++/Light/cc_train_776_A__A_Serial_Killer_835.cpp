#include <bits/stdc++.h>
using namespace std;
int main() {
  string k1, k2;
  cin >> k1 >> k2;
  int n;
  cin >> n;
  cout << k1 << " " << k2 << endl;
  for (int i = 0; i < n; i++) {
    string m, a;
    cin >> m >> a;
    if (m == k1) {
      cout << a << " " << k2 << endl;
      k1 = a;
    } else {
      cout << a << " " << k1 << endl;
      k2 = a;
    }
  }
}
