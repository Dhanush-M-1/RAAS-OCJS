#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  while (cin >> n >> m) {
    vector<int> puedo(m, 0);
    for (int i = 0; i < n; ++i) {
      int a;
      cin >> a;
      for (int j = 0; j < a; ++j) {
        int b;
        cin >> b;
        puedo[b - 1] = 1;
      }
    }
    bool no_puedo = false;
    for (int i = 0; i < m; ++i) {
      if (puedo[i] == 0) {
        no_puedo = true;
        break;
      }
    }
    if (no_puedo)
      cout << "NO" << endl;
    else
      cout << "YES" << endl;
  }
  return 0;
}
