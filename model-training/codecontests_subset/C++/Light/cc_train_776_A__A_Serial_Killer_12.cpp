#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, t, s1, t1;
  cin >> s >> t;
  int n;
  cin >> n;
  cout << s << " " << t << endl;
  while (n--) {
    cin >> s1 >> t1;
    if (s1 == s) {
      cout << t << " " << t1 << endl;
      s = t;
      t = t1;
    } else if (s1 == t) {
      cout << s << " " << t1 << endl;
      t = t1;
    } else if (t1 == s) {
      cout << t << " " << s1 << endl;
      s = t;
      t = s1;
    } else if (t1 == t) {
      cout << s << " " << s1 << endl;
      t = s1;
    }
  }
}
