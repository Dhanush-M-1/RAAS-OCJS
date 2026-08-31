#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18 + 123;
const long double EPS = 1e-9;
const int MX = 1e9 + 1;
const int inf = 1e9 + 123;
const int MOD = 1e9 + 7;
const int N = 1e5 + 123;
const int dx[] = {0, 0, 1, -1};
const int dy[] = {1, -1, 0, 0};
int main() {
  int n, ans = 0, a = 0, b = 0;
  cin >> n;
  string s;
  cin >> s;
  for (int i = 0; i < s.size(); ++i) {
    if (s[i] == '8') {
      a++;
    }
    b++;
  }
  ans = min(a, b / 11);
  cout << ans;
}
