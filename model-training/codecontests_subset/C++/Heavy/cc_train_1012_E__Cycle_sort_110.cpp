#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 2;
int a[N], p[N], head[N], now = 0;
pair<int, int> b[N];
vector<int> cycle[N];
int findd(int x) {
  if (head[x] < 0) {
    return x;
  }
  return head[x] = findd(head[x]);
}
void unionn(int x, int y) {
  x = findd(x), y = findd(y);
  head[x] += head[y];
  head[y] = x;
}
bool samee(int x, int y) { return findd(x) == findd(y); }
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, i, j, k, l, s, sz = 0;
  cin >> n >> s;
  for (i = 1; i <= n; i++) {
    head[i] = -1;
    cin >> a[i];
    b[i] = {a[i], i};
  }
  sort(b + 1, b + 1 + n);
  i = j = 1;
  while (i <= n) {
    while (j <= n && b[i].first == b[j].first) {
      j++;
    }
    now++;
    while (i < j) {
      a[b[i].second] = now;
      b[i].first = now;
      i++;
    }
  }
  for (i = 1; i <= n; i++) {
    if (a[i] != b[i].first) {
      sz++;
      head[i] = -1;
      b[sz] = {a[i], i};
      a[sz] = i;
    }
  }
  if (sz == 0) {
    cout << 0;
    return 0;
  }
  if (sz > s) {
    cout << -1;
    return 0;
  }
  sort(b + 1, b + 1 + sz);
  sort(a + 1, a + 1 + sz);
  for (i = 1; i <= sz; i++) {
    p[b[i].second] = a[i];
    if (!samee(b[i].second, a[i])) {
      unionn(b[i].second, a[i]);
    }
  }
  i = j = 1;
  while (i <= sz) {
    while (j <= sz && b[i].first == b[j].first) {
      j++;
    }
    for (k = i + 1; k < j; k++) {
      if (!samee(b[i].second, b[k].second)) {
        swap(p[b[i].second], p[b[k].second]);
        unionn(b[i].second, b[k].second);
      }
    }
    i = j;
  }
  int cnt = 0;
  for (i = 1; i <= sz; i++) {
    if (p[a[i]]) {
      cycle[cnt].push_back(a[i]);
      j = p[a[i]];
      while (j != a[i]) {
        cycle[cnt].push_back(j);
        j = p[j];
      }
      for (k = 0; k < cycle[cnt].size(); k++) {
        p[cycle[cnt][k]] = 0;
      }
      cnt++;
    }
  }
  if (cnt <= 1 || s == sz + 1 || s == sz) {
    cout << cnt << '\n';
    for (i = 0; i < cnt; i++) {
      cout << cycle[i].size() << '\n';
      for (j = 0; j < cycle[i].size(); j++) {
        cout << cycle[i][j] << ' ';
      }
      cout << '\n';
    }
  } else {
    cout << cnt - min(cnt, s - sz) + 2 << '\n';
    int z = min(s - sz, cnt);
    for (i = z; i < cnt; i++) {
      cout << cycle[i].size() << '\n';
      for (j = 0; j < cycle[i].size(); j++) {
        cout << cycle[i][j] << ' ';
      }
      cout << '\n';
    }
    cout << z << '\n';
    k = 0;
    for (i = 0; i < z; i++) {
      k += cycle[i].size();
      cout << cycle[i][0] << ' ';
    }
    cout << '\n';
    cout << k << '\n';
    for (i = z - 1; i > -1; i--) {
      for (l = 1; l < cycle[i].size(); l++) {
        cout << cycle[i][l] << ' ';
      }
      cout << cycle[i][0] << ' ';
    }
  }
}
