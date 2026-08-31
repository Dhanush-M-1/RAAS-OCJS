#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  int a[105];
  while (cin >> n) {
    int u = 0;
    int e = 0;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      if (a[i] == 100) {
        u++;
      }
    }
    if (u % 2 == 1 || (n % 2 == 1 && u == 0)) {
      cout << "NO" << endl;
    } else {
      cout << "YES" << endl;
    }
  }
  return 0;
}
