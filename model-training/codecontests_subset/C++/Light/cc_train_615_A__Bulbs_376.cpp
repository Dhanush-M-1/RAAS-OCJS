#include <bits/stdc++.h>
using namespace std;
bool ans[100];
int main() {
  int n, m, k, l;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> k;
    for (int j = 0; j < k; j++) {
      cin >> l;
      for (int y = 0; y < m; y++) {
        if (l == y + 1) ans[y] = true;
      }
    }
  }
  for (int i = 0; i < m; i++) {
    if (ans[i] == false) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
}
