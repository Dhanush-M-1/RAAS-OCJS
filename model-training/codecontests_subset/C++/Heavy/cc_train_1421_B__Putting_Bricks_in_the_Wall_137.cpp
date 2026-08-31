#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, o = 0, c = 0;
    cin >> n;
    vector<vector<char>> V(n, vector<char>(n));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) cin >> V[i][j];
    }
    if (V[1][0] == V[0][1] && V[n - 1][n - 2] == V[n - 2][n - 1]) {
      if (V[1][0] == V[n - 1][n - 2]) {
        cout << "2" << endl;
        cout << "1"
             << " "
             << "2" << endl;
        cout << "2"
             << " "
             << "1";
      } else
        cout << "0";
    } else if (V[0][1] == V[1][0]) {
      cout << "1" << endl;
      if (V[n - 1][n - 2] != V[0][1])
        cout << n - 1 << " " << n;
      else
        cout << n << " " << n - 1;
    } else if (V[n - 1][n - 2] == V[n - 2][n - 1]) {
      cout << "1" << endl;
      if (V[n - 1][n - 2] != V[0][1])
        cout << "2"
             << " "
             << "1";
      else
        cout << "1"
             << " "
             << "2";
    } else {
      cout << "2" << endl;
      cout << "1"
           << " "
           << "2" << endl;
      if (V[n - 2][n - 1] == V[0][1])
        cout << n << " " << n - 1;
      else
        cout << n - 1 << " " << n;
    }
    cout << endl;
  }
  return 0;
}
