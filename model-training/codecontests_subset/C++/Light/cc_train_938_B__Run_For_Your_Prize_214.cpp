#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int m;
  int max = 0;
  for (int i = 1; i <= n; i++) {
    cin >> m;
    if (m > 500000) {
      m = 1000000 - m + 1;
    }
    if (m >= max) {
      max = m;
    }
  }
  cout << max - 1 << endl;
}
