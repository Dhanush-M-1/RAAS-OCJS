#include <bits/stdc++.h>
using namespace std;
int t, m;
bool use[128];
map<int, pair<int, int> > bl;
map<int, int> d;
int main() {
  int cnt = 0;
  cin >> t >> m;
  for (int op = 0; op < t; op++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int n;
      cin >> n;
      int pos = 0;
      while (pos + n <= m) {
        bool f = 1;
        for (int i = 0; i < n; i++)
          if (use[pos + i]) f = 0;
        if (f)
          break;
        else
          pos++;
      }
      if (pos + n <= m) {
        cnt++;
        bl[cnt] = make_pair(pos, n);
        for (int i = 0; i < n; i++) use[pos + i] = 1;
        cout << cnt << endl;
      } else
        cout << "NULL" << endl;
    } else if (s == "erase") {
      int n;
      cin >> n;
      if (bl.find(n) != bl.end()) {
        pair<int, int> t = bl[n];
        bl.erase(n);
        for (int i = 0; i < t.second; i++) use[t.first + i] = 0;
      } else
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      d.clear();
      for (int i = 0; i < m; i++) d[i] = i;
      for (int i = 1; i < m; i++)
        if (use[i] && !use[i - 1]) {
          int pos = i - 1;
          while (pos > 0 && !use[pos - 1]) pos--;
          for (int j = i; j < m && use[j]; j++) {
            d[j] = pos + j - i;
            use[pos + j - i] = 1;
            use[j] = 0;
          }
        }
      vector<pair<int, pair<int, int> > > tmp;
      for (map<int, pair<int, int> >::iterator it = bl.begin(); it != bl.end();
           it++) {
        tmp.push_back(make_pair(
            it->first, make_pair(d[it->second.first], it->second.second)));
      }
      bl.clear();
      for (int k = 0; k < tmp.size(); k++) bl[tmp[k].first] = tmp[k].second;
    }
  }
  return 0;
}
