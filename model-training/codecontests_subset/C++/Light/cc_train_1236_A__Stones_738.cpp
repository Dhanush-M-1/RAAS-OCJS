#include <bits/stdc++.h>
using namespace std;
int main() {
  int T, a, b, c;
  cin >> T;
  for (int t = 0; t < T; t++) {
    cin >> a >> b >> c;
    cout << (min(c / 2, b) * 3) + min(a, (b - min(c / 2, b)) / 2) * 3 << "\n";
  }
}
