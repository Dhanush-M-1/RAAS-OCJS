#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, c;
  cin >> n >> c;
  int s[n], a, i, j, b;
  a = 0, b = 0;
  for (i = 0; i < n; i++) {
    cin >> s[i];
    if (i > 0) {
      a = s[i - 1] - s[i] - c;
      if (a > b) {
        b = a;
      }
    }
  }
  cout << b << endl;
}
