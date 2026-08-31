#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  string s, t;
  cin >> s >> t;
  int n;
  cin >> n;
  cout << s << " " << t << "\n";
  string a, b;
  for (int i = 0; i < n; i++) {
    cin >> a >> b;
    if (s == a)
      s = b;
    else
      t = b;
    cout << s << " " << t << "\n";
  }
  return 0;
}
