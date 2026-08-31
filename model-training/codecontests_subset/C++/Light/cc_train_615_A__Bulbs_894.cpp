#include <bits/stdc++.h>
using namespace std;
bool A[102];
int main() {
  int n, m, x, y;
  cin >> n >> m;
  bool flag = true;
  for (int i = 0; i < n; ++i) {
    cin >> x;
    for (int j = 0; j < x; ++j) {
      cin >> y;
      A[y - 1] = 1;
    }
  }
  for (int i = 0; i < m; ++i) {
    if (!A[i]) flag = false;
  }
  if (flag)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
