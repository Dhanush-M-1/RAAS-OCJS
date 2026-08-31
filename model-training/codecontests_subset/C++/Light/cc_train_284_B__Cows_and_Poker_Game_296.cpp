#include <bits/stdc++.h>
using namespace std;
long long x, y, z;
signed main() {
  long long n;
  cin >> n;
  char w;
  for (long long i = 1; i <= n; i++) {
    cin >> w;
    switch (w) {
      case 'A': {
        x++;
        break;
      }
      case 'F': {
        y++;
        break;
      }
      case 'I': {
        z++;
        break;
      }
    }
  }
  if (z == 0) {
    cout << x << endl;
    return 0;
  }
  if (z == 1) {
    cout << 1 << endl;
    return 0;
  }
  cout << 0 << endl;
  return 0;
}
