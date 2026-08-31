#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, t;
  cin >> n >> m;
  int visited[m + 1];
  for (int i = 0; i <= m; i++) {
    visited[i] = 0;
  }
  for (int i = 0; i < n; i++) {
    int k;
    cin >> t;
    for (int j = 0; j < t; j++) {
      cin >> k;
      visited[k] = 1;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (visited[i] == 0) {
      cout << "NO";
      return 0;
    }
  }
  cout << "YES";
  return 0;
}
