#include <bits/stdc++.h>
using namespace std;
int main() {
  int a;
  string r, s;
  cin >> r >> s;
  cout << r << " " << s << endl;
  cin >> a;
  for (; a--;) {
    string u, v;
    cin >> u >> v;
    (u == r) ? r = v : s = v;
    cout << r << " " << s << endl;
  }
  return 0;
}
