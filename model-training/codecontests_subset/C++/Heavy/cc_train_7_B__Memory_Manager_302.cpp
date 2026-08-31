#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  list<pair<int, int> > f;
  list<pair<pair<int, int>, int> > nf;
  f.push_back(pair<int, int>(1, m));
  int a = 1;
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int n;
      cin >> n;
      bool found = false;
      for (list<pair<int, int> >::iterator it = f.begin(); it != f.end();
           ++it) {
        if (it->second - it->first + 1 >= n) {
          cout << a << endl;
          found = true;
          nf.push_back(pair<pair<int, int>, int>(
              pair<int, int>(it->first, it->first + n - 1), a));
          nf.sort();
          it->first = it->first + n;
          if (it->first > it->second) f.erase(it);
          a++;
          break;
        }
      }
      if (!found) {
        cout << "NULL" << endl;
      }
    } else if (s == "erase") {
      int n;
      cin >> n;
      list<pair<pair<int, int>, int> >::iterator ff;
      bool found = false;
      for (ff = nf.begin(); ff != nf.end(); ++ff) {
        if (ff->second == n) {
          found = true;
          f.push_back(pair<int, int>(ff->first.first, ff->first.second));
          nf.erase(ff);
          f.sort();
          list<pair<int, int> >::iterator prev = f.end();
          for (list<pair<int, int> >::iterator it = f.begin(); it != f.end();) {
            if (prev != f.end() && it->first - prev->second == 1) {
              prev->second = it->second;
              prev = it;
              it = f.erase(it);
            } else {
              prev = it;
              ++it;
            }
          }
          break;
        }
      }
      if (!found) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      int s = 1;
      for (list<pair<pair<int, int>, int> >::iterator it = nf.begin();
           it != nf.end(); ++it) {
        int sz = it->first.second - it->first.first;
        it->first.first = s;
        it->first.second = s + sz;
        s = it->first.second + 1;
      }
      f.clear();
      if (s <= m) f.push_back(pair<int, int>(s, m));
    }
  }
  return 0;
}
