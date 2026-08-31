#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, l;
  while (cin >> n >> l) {
    int res = 0xffff;
    int m;
    for (int i = 0; i < n; i++) {
      cin >> m;
      if (l % m == 0 && l / m < res) res = l / m;
    }
    cout << res << endl;
  }
}
