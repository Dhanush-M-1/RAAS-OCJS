#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, t;
  cin >> s >> t;
  int n;
  cout << s << " " << t << endl;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    string a, b;
    cin >> a >> b;
    if (s == a) s = b;
    if (t == a) t = b;
    cout << s << " " << t << endl;
  }
}
