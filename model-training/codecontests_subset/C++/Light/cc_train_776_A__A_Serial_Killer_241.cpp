#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize "-O3"
const int N = (1e5 + 5);
int n;
string s1, s2;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> s1 >> s2 >> n;
  cout << s1 << ' ' << s2 << '\n';
  for (int i = 1; i <= n; i++) {
    string x, y;
    cin >> x >> y;
    ((x == s1) ? s1 : s2) = y;
    cout << s1 << ' ' << s2 << '\n';
  }
  return 0;
}
