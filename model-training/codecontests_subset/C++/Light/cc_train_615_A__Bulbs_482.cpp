#include <bits/stdc++.h>
using namespace std;
bool ma[500];
int main() {
  int n, m;
  cin >> n >> m;
  while (n--) {
    int q;
    cin >> q;
    while (q--) {
      int y;
      cin >> y;
      ma[y] = true;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!ma[i]) {
      cout << "NO\n";
      return 0;
    }
  }
  cout << "YES\n";
  return 0;
}
