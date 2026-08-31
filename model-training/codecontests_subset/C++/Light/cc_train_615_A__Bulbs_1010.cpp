#include <bits/stdc++.h>
using namespace std;
bool flag[100];
int main() {
  int n, m, x, fuck;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> x;
    for (int j = 0; j < x; j++) {
      cin >> fuck;
      flag[fuck - 1] = 1;
    }
  }
  for (int i = 0; i < m; i++)
    if (flag[i] == 0) {
      cout << "NO";
      return 0;
    }
  cout << "YES";
  return 0;
}
