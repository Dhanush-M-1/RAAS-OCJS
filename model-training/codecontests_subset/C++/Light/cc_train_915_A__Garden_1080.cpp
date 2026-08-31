#include <bits/stdc++.h>
using namespace std;
using namespace std;
int main() {
  int n, m;
  cin >> m >> n;
  int min = INT_MAX;
  for (int i = 0; i < m; i++) {
    int q;
    cin >> q;
    if (n % q == 0) {
      if (n / q < min) {
        min = n / q;
      }
    }
  }
  cout << min;
  return 0;
}
