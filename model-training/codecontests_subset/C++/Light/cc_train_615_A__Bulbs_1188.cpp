#include <bits/stdc++.h>
using namespace std;
int main() {
  set<int> bulbs;
  int n, m;
  cin >> n >> m;
  int k, t;
  for (int i = 0; i < (int)n; i++) {
    cin >> k;
    for (int j = 0; j < (int)k; j++) {
      cin >> t;
      bulbs.insert(t);
    }
  }
  if (bulbs.size() == m)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
