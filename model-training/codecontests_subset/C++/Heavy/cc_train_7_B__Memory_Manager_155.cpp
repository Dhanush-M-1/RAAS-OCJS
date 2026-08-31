#include <bits/stdc++.h>
using namespace std;
int read() {
  int x;
  scanf("%d", &x);
  return x;
}
int a[1010];
bool used[1001];
int busy[1001];
int main() {
  int t = read(), n = read(), x, sum = 0, cnt = 0, sum1 = 0;
  string s;
  busy[n + 1] = 1;
  vector<pair<int, int> > g;
  for (int i = 1; i <= t; i++) {
    cin >> s;
    if (s == "defragment") {
      g.clear();
      for (int id = 1; id <= n; id++) {
        if (busy[id]) {
          int r = busy[id], l = id;
          while (busy[id] == r) {
            id++;
          }
          g.push_back({id - l, r});
          id--;
        }
      }
      int cnt = 1;
      for (int id = 0; id < g.size(); id++) {
        for (int j = 0; j < g[id].first; j++) {
          busy[cnt + j] = g[id].second;
        }
        cnt += g[id].first;
      }
      for (int id = cnt; id <= n; id++) busy[id] = 0;
    }
    if (s == "alloc") {
      cin >> x;
      bool ok = 0;
      for (int id = 1; id <= n; id++) {
        if (!busy[id]) {
          int j;
          for (j = id; j <= n; j++) {
            if (busy[j]) break;
          }
          if (!busy[j] && j == n) j++;
          if (j - id >= x) {
            ++cnt;
            for (int jj = id; jj < id + x; jj++) busy[jj] = cnt;
            ok = 1;
            break;
          }
          id = j;
        }
      }
      if (!ok)
        cout << "NULL\n";
      else
        cout << cnt << endl;
    }
    if (s == "erase") {
      cin >> x;
      if (x > cnt || x <= 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
        continue;
      }
      int ind = -1;
      for (int id = 1; id <= n; id++) {
        if (busy[id] == x) {
          ind = id;
          break;
        }
      }
      if (ind == -1) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      } else {
        for (int id = ind; busy[id] == x; id++) busy[id] = 0;
      }
    }
  }
}
