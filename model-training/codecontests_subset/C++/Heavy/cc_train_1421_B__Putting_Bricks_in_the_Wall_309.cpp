#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int>> foo(string table[], int n, char character) {
  vector<pair<int, int>> result(0);
  char ch = character;
  if (table[n - 1][n - 3] != ch) result.push_back({n - 1, n - 3});
  if (table[n - 2][n - 2] != ch) result.push_back({n - 2, n - 2});
  if (table[n - 3][n - 1] != ch) result.push_back({n - 3, n - 1});
  if (ch == '1')
    ch = '0';
  else
    ch = '1';
  if (table[n - 1][n - 2] != ch) result.push_back({n - 1, n - 2});
  if (table[n - 2][n - 1] != ch) result.push_back({n - 2, n - 1});
  return result;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  vector<pair<int, int>> a, b, c;
  int tt;
  cin >> tt;
  while (tt--) {
    int n;
    cin >> n;
    string table[n];
    for (int i = 0; i < n; i++) cin >> table[i];
    a = foo(table, n, '1');
    b = foo(table, n, '0');
    c = a.size() < b.size() ? a : b;
    cout << c.size() << "\n";
    for (int i = 0; i < c.size(); i++) {
      cout << c[i].first + 1 << " " << c[i].second + 1 << "\n";
    }
  }
  return 0;
}
