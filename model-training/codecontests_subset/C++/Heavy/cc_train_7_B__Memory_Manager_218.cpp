#include <bits/stdc++.h>
using namespace std;
string nl = "NULL";
string er = "ILLEGAL_ERASE_ARGUMENT";
map<int, pair<int, int> > mp;
vector<int> ar, br;
int nm = 1;
int alloc(int num) {
  int n = ar.size();
  for (int i = 1; i < n - num + 1; ++i) {
    if (ar[i] == 0) {
      int f = 1;
      for (int j = i; j < i + num; ++j) {
        if (ar[j] != 0) f = 0;
      }
      if (f) {
        for (int j = i; j < i + num; ++j) {
          ar[j] = nm;
        }
        mp[nm] = {i, num};
        ++nm;
        return (nm - 1);
      }
    }
  }
  return 0;
}
string ers(int num) {
  if (mp[num].first == 0) return er;
  int pos = mp[num].first, cnt = mp[num].second;
  for (int i = pos; i < pos + cnt; ++i) ar[i] = 0;
  mp[num].first = 0;
  return "#";
}
void defragment() {
  int n = ar.size();
  for (int i = 0; i < br.size(); ++i) br[i] = 0;
  int ps = 0;
  for (int i = 1; i < n; ++i) {
    if (ar[i] != 0) br[ps++] = (ar[i]);
    ar[i] = 0;
  }
  for (int i = 0; i < br.size() - 1; ++i) ar[i + 1] = br[i];
  vector<bool> used(n, 0);
  used[0] = 1;
  for (int i = 1; i < n; ++i) {
    if (!used[ar[i]]) {
      used[ar[i]] = 1;
      mp[ar[i]].first = i;
    }
  }
}
int main() {
  int t, m;
  cin >> t >> m;
  ar.resize(m + 1);
  br.resize(m + 1);
  while (t--) {
    string cmd;
    int num;
    cin >> cmd;
    if (cmd == "alloc") {
      cin >> num;
      int x = alloc(num);
      if (x == 0)
        cout << nl << "\n";
      else
        cout << x << '\n';
    } else if (cmd == "erase") {
      cin >> num;
      string x = ers(num);
      if (x != "#") cout << x << '\n';
    } else if (cmd == "defragment") {
      defragment();
    }
  }
}
