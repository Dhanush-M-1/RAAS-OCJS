#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, m, b;
  cin >> n >> m;
  vector<int> vn;
  set<int> s1;
  for (int i = 0; i < n; i++) {
    cin >> b;
    for (int j = 0; j < b; j++) {
      cin >> a;
      s1.insert(a);
    }
  }
  for (set<int>::iterator it = s1.begin(); it != s1.end(); it++) {
    vn.push_back(*it);
  }
  if (vn.size() != m) {
    cout << "NO";
    return 0;
  } else {
    for (int k = 0; k < n; k++) {
      if (vn[k] != k + 1) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES";
  return 0;
}
