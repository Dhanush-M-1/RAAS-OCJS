#include <bits/stdc++.h>
using namespace std;
const int N = 257;
const int INF = 1e9 + 123;
const int MOD = 1e9 + 7;
const double EPS = 1e-9;
const int dx[] = {0, 0, 1, -1};
const int dy[] = {1, -1, 0, 0};
string pass;
int n, first[N], last[N];
int main() {
  ios_base ::sync_with_stdio(0);
  cin >> pass;
  cin >> n;
  bool ok = 0;
  for (int i = 1; i <= n; ++i) {
    string s;
    cin >> s;
    if (s == pass) ok = 1;
    first[s[0]] = 1;
    last[s[1]] = 1;
  }
  int fp = pass[0], lp = pass[1];
  if ((last[fp] && first[lp]) || ok)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
