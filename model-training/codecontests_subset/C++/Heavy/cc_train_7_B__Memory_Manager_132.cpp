#include <bits/stdc++.h>
using namespace std;
int used[128];
int m;
int cc = 0;
bool ok(int i, int k) {
  if (i + k > m) return false;
  for (int j = (i), __j = (i + k); j < __j; j++)
    if (used[j]) return false;
  return true;
}
int main() {
  int n;
  cin >> n >> m;
  map<int, pair<int, int> > a;
  for (int it = (0), __it = (n); it < __it; it++) {
    string op;
    int x;
    cin >> op;
    if (op == "alloc") {
      cin >> x;
      bool bad = true;
      for (int i = (0), __i = (m); i < __i; i++)
        if (ok(i, x)) {
          for (int j = (i), __j = (i + x); j < __j; j++) used[j] = 1;
          ++cc;
          a[cc] = make_pair(i, x);
          cout << cc << endl;
          bad = false;
          break;
        }
      if (bad) {
        cout << "NULL" << endl;
      }
    } else if (op == "erase") {
      cin >> x;
      if (a[x] == make_pair(0, 0)) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      } else {
        for (int j = ((a[x]).first), __j = ((a[x]).first + (a[x]).second);
             j < __j; j++)
          used[j] = 0;
        a[x] = make_pair(0, 0);
      }
    } else if (op == "defragment") {
      vector<pair<pair<int, int>, int> > b;
      map<int, pair<int, int> >::iterator it;
      for (it = a.begin(); it != a.end(); ++it) {
        if (it->second != make_pair(0, 0)) {
          b.push_back(make_pair(it->second, it->first));
          it->second = make_pair(0, 0);
        }
      }
      sort((b).begin(), (b).end());
      memset(used, 0, sizeof(used));
      int p = 0;
      for (int i = (0), __i = (int((b).size())); i < __i; i++) {
        a[b[i].second] = make_pair(p, b[i].first.second);
        for (int j = (p), __j = (p + b[i].first.second); j < __j; j++)
          used[j] = 1;
        p += b[i].first.second;
      }
    } else {
      cerr << "BAD" << endl;
      while (1)
        ;
    }
  }
  return 0;
}
