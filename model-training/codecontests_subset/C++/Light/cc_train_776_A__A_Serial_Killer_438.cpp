#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 11;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s, t;
  cin >> s >> t;
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cout << s << " " << t << endl;
    string p, g;
    cin >> p >> g;
    if (s == p)
      s = g;
    else
      t = g;
  }
  cout << s << " " << t << endl;
}
