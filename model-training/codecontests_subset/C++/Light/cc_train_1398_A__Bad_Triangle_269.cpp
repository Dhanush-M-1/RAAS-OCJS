#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  vector<vector<int>> v(t);
  int n;
  int temp;
  for (int i = 0; i < t; i++) {
    cin >> n;
    v[i].reserve(n);
    for (int j = 0; j < n; j++) {
      cin >> temp;
      v[i].push_back(temp);
    }
  }
  for (int i = 0; i < t; i++) {
    if (v[i][v[i].size() - 1] >= v[i][0] + v[i][1])
      cout << 1 << " " << 2 << " " << v[i].size() << endl;
    else
      cout << -1 << endl;
  }
  return 0;
}
