#include <bits/stdc++.h>
using namespace std;
const int MAXN = 208;
int n, mat[MAXN][MAXN];
vector<pair<int, int> > changes;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int tc;
  cin >> tc;
  while (tc--) {
    cin >> n;
    changes.clear();
    for (int i = 1; i <= n; i++) {
      string s;
      cin >> s;
      for (int j = 1; j <= n; j++) {
        mat[i][j] = s[j - 1] - '0';
      }
    }
    if (mat[1][2] == 1 && mat[2][1] == 1) {
      if (mat[n][n - 1] == 1) changes.push_back(make_pair(n, n - 1));
      if (mat[n - 1][n] == 1) changes.push_back(make_pair(n - 1, n));
    } else {
      if (mat[n][n - 1] == 0 && mat[n - 1][n] == 0) {
        if (mat[1][2] == 0) changes.push_back(make_pair(1, 2));
        if (mat[2][1] == 0) changes.push_back(make_pair(2, 1));
      } else {
        if (mat[1][2] == 1) changes.push_back(make_pair(1, 2));
        if (mat[2][1] == 1) changes.push_back(make_pair(2, 1));
        if (mat[n][n - 1] == 0) changes.push_back(make_pair(n, n - 1));
        if (mat[n - 1][n] == 0) changes.push_back(make_pair(n - 1, n));
      }
    }
    cout << (int)changes.size() << endl;
    for (pair<int, int> par : changes)
      cout << par.first << " " << par.second << endl;
  }
}
