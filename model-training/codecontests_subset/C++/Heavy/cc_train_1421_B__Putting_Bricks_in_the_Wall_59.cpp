#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    string s;
    int n;
    cin >> n;
    getline(cin, s);
    vector<vector<char>> v(n);
    char c;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cin >> c;
        v[i].push_back(c);
      }
      getline(cin, s);
    }
    int ctr1 = 0, ctr2 = 0;
    if (v[1][0] == v[0][1]) {
      c = v[1][0];
      if (v[n - 1][n - 2] == c) ctr1++;
      if (v[n - 2][n - 1] == c) ctr2++;
      cout << ctr1 + ctr2 << endl;
      if (v[n - 1][n - 2] == c) cout << n << " " << n - 1 << endl;
      if (v[n - 2][n - 1] == c) cout << n - 1 << " " << n << endl;
    } else if (v[n - 1][n - 2] == v[n - 2][n - 1]) {
      c = v[n - 1][n - 2];
      if (v[1][0] == c) ctr1++;
      if (v[0][1] == c) ctr2++;
      cout << ctr1 + ctr2 << endl;
      if (v[1][0] == c) cout << "2 1" << endl;
      if (v[0][1] == c) cout << "1 2" << endl;
    } else {
      cout << "2\n";
      if (v[1][0] == v[n - 1][n - 2])
        cout << "2 1\n" << n - 1 << " " << n << endl;
      else if (v[1][0] == v[n - 2][n - 1])
        cout << "2 1\n" << n << " " << n - 1 << endl;
    }
  }
}
