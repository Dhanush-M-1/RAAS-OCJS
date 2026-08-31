#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, m, x[102] = {};
  bool ch = true;
  cin >> n >> m;
  for (i = 0; i < n; i++) {
    int tmp;
    cin >> tmp;
    for (j = 0; j < tmp; j++) {
      int tmp2;
      cin >> tmp2;
      x[tmp2] = 1;
    }
  }
  for (i = 1; i <= m; i++)
    if (x[i] == 0) ch = false;
  if (ch == true)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
