#include <bits/stdc++.h>
using namespace std;

int main() {
  cin.tie(nullptr);
  ios::sync_with_stdio(false);
  int n;
  while (cin >> n, n) {
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
      string w;
      cin >> w;
      a[i] = w.size();
    }
    for (int i = 0; i < n; ++i) {
      int s = 0;
      set<int> se;
      for (int j = i; j < n; ++j) {
        se.insert(s += a[j]);
      }
      if (se.count(5) and se.count(12) and se.count(17) and se.count(24) and se.count(31)) {
        cout << i + 1 << '\n';
        break;
      }
    }
  }
}

