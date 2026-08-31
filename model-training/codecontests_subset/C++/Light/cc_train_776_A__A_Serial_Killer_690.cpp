#include <bits/stdc++.h>
using namespace std;
string s, t, a, b;
int n;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> s >> t;
  cin >> n;
  cout << s << " " << t << endl;
  for (int i = 1; i <= n; i++) {
    cin >> a >> b;
    if (a == t)
      t = b;
    else if (a == s)
      s = b;
    else if (b == t)
      t = a;
    else if (b == s)
      s = a;
    cout << s << " " << t << endl;
  }
  return 0;
}
