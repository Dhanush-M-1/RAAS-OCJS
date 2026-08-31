#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int m;
  cin >> m;
  set<int> q;
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    for (int j = 0; j < k; ++j) {
      int x;
      cin >> x;
      q.insert(x);
    }
  }
  cout << ((q.size() == m) ? "YES" : "NO") << endl;
  return 0;
}
