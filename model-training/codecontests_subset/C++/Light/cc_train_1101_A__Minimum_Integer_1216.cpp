#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    if (c < a || c > b) {
      cout << c << endl;
    } else {
      cout << (b / c + 1) * c << endl;
    }
  }
}
