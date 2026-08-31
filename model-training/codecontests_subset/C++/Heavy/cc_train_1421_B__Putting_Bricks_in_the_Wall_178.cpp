#include <bits/stdc++.h>
using namespace std;
void fast() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
char mat[201][201];
int main() {
  fast();
  int n, t;
  bool p, q;
  cin >> t;
  for (int cas = 0; cas < t; cas++) {
    int x = 0;
    q = p = false;
    cin >> n;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++) cin >> mat[i][j];
    if (mat[0][1] == mat[1][0]) p = true;
    if (mat[n - 1][n - 2] == mat[n - 2][n - 1]) q = true;
    if (q && p) {
      if (mat[0][1] == mat[n - 1][n - 2])
        cout << 2 << endl << 1 << " " << 2 << endl << 2 << " " << 1 << endl;
      else
        cout << 0 << endl;
    } else if (!p && !q) {
      cout << 2 << endl;
      if (mat[0][1] == '0')
        cout << 2 << " " << 1 << endl;
      else
        cout << 1 << " " << 2 << endl;
      if (mat[n - 1][n - 2] == '0')
        cout << n << " " << n - 1 << endl;
      else
        cout << n - 1 << " " << n << endl;
    } else if (p && !q) {
      cout << 1 << endl;
      if (mat[0][1] == mat[n - 1][n - 2])
        cout << n << " " << n - 1 << endl;
      else
        cout << n - 1 << " " << n << endl;
    } else if (!p && q) {
      cout << 1 << endl;
      if (mat[0][1] == mat[n - 1][n - 2])
        cout << 1 << " " << 2 << endl;
      else
        cout << 2 << " " << 1 << endl;
    }
  }
  return 0;
}
