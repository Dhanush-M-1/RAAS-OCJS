#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, a, b;
  set<int> S;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> a;
    for (int j = 0; j < a; j++) {
      cin >> b;
      S.insert(b);
    }
  }
  if (static_cast<int>(S.size()) == m) {
    cout << "YES" << endl;
  } else
    cout << "NO" << endl;
  return 0;
}
