#include <bits/stdc++.h>
using namespace std;
const long long oo = 0x3f3f3f3f3f3f3f3f;
const double eps = 1e-9;
vector<vector<long long> > grid;
long long n;
void doTest() {
  cin >> n;
  grid = vector<vector<long long> >(n, vector<long long>(n, 0));
  for (long long i = (0); i < (n); i++) {
    string s;
    cin >> s;
    for (long long j = (0); j < (n); j++) {
      if (s[j] == '0') grid[i][j] = 0;
      if (s[j] == '1') grid[i][j] = 1;
      if (s[j] == 'S') grid[i][j] = -1;
      if (s[j] == 'F') grid[i][j] = -1;
    }
  }
  vector<pair<long long, long long> > change =
      vector<pair<long long, long long> >();
  if (grid[1][0] == grid[0][1]) {
    if (grid[n - 2][n - 1] == grid[1][0]) {
      change.push_back(make_pair(n - 1, n));
    }
    if (grid[n - 1][n - 2] == grid[1][0]) {
      change.push_back(make_pair(n, n - 1));
    }
  } else if (grid[n - 2][n - 1] == grid[n - 1][n - 2]) {
    if (grid[n - 2][n - 1] == grid[1][0]) {
      change.push_back(make_pair(2, 1));
    }
    if (grid[n - 2][n - 1] == grid[0][1]) {
      change.push_back(make_pair(1, 2));
    }
  } else {
    if (grid[1][0] != grid[n - 2][n - 1]) {
      change.push_back(make_pair(2, 1));
      change.push_back(make_pair(n - 1, n));
    } else {
      change.push_back(make_pair(2, 1));
      change.push_back(make_pair(n, n - 1));
    }
  }
  cout << change.size() << endl;
  for (long long i = (0); i < (change.size()); i++) {
    cout << change[i].first << ' ' << change[i].second << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  for (long long i = (0); i < (t); i++) doTest();
}
