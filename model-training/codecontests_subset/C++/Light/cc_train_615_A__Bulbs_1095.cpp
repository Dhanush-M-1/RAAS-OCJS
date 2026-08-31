#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  set<int> a;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    for (int j = 0; j < x; j++) {
      int v;
      cin >> v;
      a.insert(v);
    }
  }
  if (a.size() == m) {
    cout << "YES";
    return 0;
  }
  cout << "NO";
}
