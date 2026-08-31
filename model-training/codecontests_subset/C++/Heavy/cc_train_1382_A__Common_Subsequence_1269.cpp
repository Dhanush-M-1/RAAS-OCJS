#include <bits/stdc++.h>
using namespace std;
int a[1050], b[1050];
set<int> brojevi;
int main() {
  int t, n, m;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> n >> m;
    brojevi.clear();
    for (int j = 0; j < n; j++) {
      cin >> a[j];
      auto pos = brojevi.find(a[j]);
      if (pos == brojevi.end()) {
        brojevi.insert(a[j]);
      }
    }
    int c = -1;
    for (int j = 0; j < m; j++) {
      cin >> b[j];
    }
    for (int j = 0; j < m; j++) {
      auto pos = brojevi.find(b[j]);
      if (pos != brojevi.end()) {
        c = b[j];
        break;
      }
    }
    if (c == -1) {
      cout << "NO" << endl;
      continue;
    }
    cout << "YES" << endl;
    cout << 1 << " " << c << endl;
  }
  return 0;
}
