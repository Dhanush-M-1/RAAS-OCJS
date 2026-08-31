#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, total = 0;
  cin >> n;
  int m = 0;
  for (int i = 0; i < n; i++) {
    cin >> a;
    total += a;
    m = max(m, a);
  }
  while (true) {
    int t = n * m;
    if (t - total > total) {
      cout << m << endl;
      return 0;
    }
    m += 1;
  }
}
