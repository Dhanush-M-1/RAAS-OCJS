#include <bits/stdc++.h>
using namespace std;
string s, t;
char tmp[20];
string itostr(int x) {
  sprintf(tmp, "%d", x);
  return tmp;
}
int main() {
  int n, x, y, tmp;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x >> y >> tmp;
    s += "(" + itostr(x / 2) + "*((1-abs((t-" + itostr(i) + ")))+abs((abs((t-" +
         itostr(i) + "))-1))))";
    t += "(" + itostr(y / 2) + "*((1-abs((t-" + itostr(i) + ")))+abs((abs((t-" +
         itostr(i) + "))-1))))";
    if (i) s += ')', t += ')';
    s += '+', t += '+';
  }
  s.erase(s.end() - 1), t.erase(t.end() - 1);
  s = string(n - 1, '(') + s, t = string(n - 1, '(') + t;
  cout << s << endl << t << endl;
  return 0;
}
