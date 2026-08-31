#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
int main() {
  ios::sync_with_stdio(false);
  int n;
  string s, t;
  cin >> s >> t;
  cin >> n;
  cout << s << " " << t << "\n";
  while (n--) {
    string a, b;
    cin >> a >> b;
    if (a == s)
      s = b;
    else
      t = b;
    cout << s << " " << t << "\n";
  }
  return 0;
}
