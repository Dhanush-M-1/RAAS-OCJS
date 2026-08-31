#include <bits/stdc++.h>
using namespace std;
int main() {
  char ch;
  int n, m, x, y;
  list<pair<int, int> > l;
  vector<list<pair<int, int> >::iterator> v;
  scanf("%d%d", &n, &m);
  l.push_back(pair<int, int>(m, 0));
  v.push_back(l.end());
  for (int i = 0; i < n; ++i) {
    scanf(" %c%*s%d", &ch, &x);
    if (ch == 'a') {
      y = 0;
      for (list<pair<int, int> >::iterator i = l.begin(); i != l.end(); ++i) {
        if (y + x <= i->first) {
          printf("%d\n", v.size());
          v.push_back(l.insert(i, make_pair(y, x)));
          break;
        }
        y = i->first + i->second;
      }
      if (y == m) {
        puts("NULL");
      }
    } else if (ch == 'e') {
      if (0 < x && x < (int)v.size() && v[x] != l.end()) {
        l.erase(v[x]);
        v[x] = l.end();
      } else {
        puts("ILLEGAL_ERASE_ARGUMENT");
      }
    } else {
      y = 0;
      for (list<pair<int, int> >::iterator i = l.begin(); i->first < m; ++i) {
        i->first = y;
        y += i->second;
      }
    }
  }
  return 0;
}
