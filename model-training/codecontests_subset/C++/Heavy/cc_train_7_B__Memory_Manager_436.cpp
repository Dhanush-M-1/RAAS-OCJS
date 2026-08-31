#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t, m, n, x;
  cin >> t >> m;
  string op;
  vector<int> mem(m + 1, 0);
  vector<pair<int, int> > a(120, {0, 0});
  int id = 1;
  for (int i = 0; i < t; ++i) {
    cin >> op;
    if (op == "alloc") {
      cin >> n;
      int s = 1;
      int cnt = 0;
      bool found = false;
      while (s <= m) {
        if (mem[s] == 0) {
          cnt++;
          s++;
        } else {
          cnt = 0;
          s += a[mem[s]].second;
        }
        if (cnt == n) {
          found = true;
          break;
        }
      }
      if (found) {
        int start = s - n;
        a[id].second = n;
        a[id].first = start;
        mem[start] = id;
        cout << id << endl;
        id++;
      } else {
        cout << "NULL\n";
      }
    } else if (op == "erase") {
      cin >> x;
      if (x < 0 || x > id || a[x].first == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      } else {
        mem[a[x].first] = 0;
        a[x].first = 0;
        a[x].second = 0;
      }
    } else {
      int offset = 1;
      for (int i = 1; i <= m;) {
        if (mem[i] != 0) {
          int id1 = mem[i];
          mem[i] = 0;
          mem[offset] = id1;
          a[id1].first = offset;
          offset += a[id1].second;
          i += a[id1].second;
        } else {
          i++;
        }
      }
    }
  }
  return 0;
}
