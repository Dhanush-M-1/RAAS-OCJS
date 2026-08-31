#include <bits/stdc++.h>
using namespace std;
string s, s1, t, t1;
int main() {
  cin >> s >> s1;
  int n;
  cin >> n;
  while (n--) {
    cout << s << " " << s1 << endl;
    cin >> t >> t1;
    if (t == s)
      s = t1;
    else
      s1 = t1;
  }
  cout << s << " " << s1 << endl;
}
