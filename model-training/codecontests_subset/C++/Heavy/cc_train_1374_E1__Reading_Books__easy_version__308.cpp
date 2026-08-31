#include <bits/stdc++.h>
using namespace std;
using pi = pair<long long, long long>;
const long long inf = (long long)2e9 + 5;
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<pi> w[2][2];
  for (long long i = 0; i < n; i++) {
    long long t, a, b;
    cin >> t >> a >> b;
    w[a][b].emplace_back(t, i);
  }
  if (((long long)(w[1][1]).size()) +
          min(((long long)(w[0][1]).size()), ((long long)(w[1][0]).size())) <
      k) {
    cout << -1 << '\n';
    return 0;
  }
  long long res = inf, id[2][2];
  long long cur[2][2], pt[2][2], z[2][2];
  for (long long a : {0, 1}) {
    for (long long b : {0, 1}) {
      id[a][b] = -1;
      cur[a][b] = pt[a][b] = 0;
      while (((long long)(w[a][b]).size()) < m + 5) {
        w[a][b].emplace_back(inf, -1);
      }
      z[a][b] = ((long long)(w[a][b]).size());
      sort((w[a][b]).begin(), (w[a][b]).end());
    }
  }
  long long want[2][2];
  for (long long i = k; i >= 0; i--) {
    want[0][0] = 0;
    want[0][1] = want[1][0] = k - i;
    want[1][1] = i;
    for (long long a : {0, 1}) {
      for (long long b : {0, 1}) {
        while (pt[a][b] < want[a][b]) {
          cur[a][b] += w[a][b][pt[a][b]++].first;
        }
      }
    }
    while (pt[1][1] + pt[1][0] + pt[0][1] + pt[0][0] < m) {
      cur[1][1] += w[1][1][pt[1][1]++].first;
    }
    while (pt[0][0] + pt[0][1] + pt[1][0] + pt[1][1] > m) {
      bool found = false;
      for (long long a : {0, 1}) {
        for (long long b : {0, 1}) {
          if (pt[a][b] > want[a][b]) {
            cur[a][b] -= w[a][b][--pt[a][b]].first;
            found = true;
            break;
          }
        }
        if (found) {
          break;
        }
      }
      if (!found) {
        break;
      }
    }
    while (true) {
      pair<long long, pi> add = {inf, {-1, -1}}, rem = {-inf, {-1, -1}};
      for (long long a : {0, 1}) {
        for (long long b : {0, 1}) {
          add = min(add, make_pair(w[a][b][pt[a][b]].first, make_pair(a, b)));
          if (pt[a][b] > want[a][b]) {
            rem = max(rem,
                      make_pair(w[a][b][pt[a][b] - 1].first, make_pair(a, b)));
          }
        }
      }
      if (add.first < rem.first) {
        long long a = add.second.first, b = add.second.second;
        cur[a][b] += w[a][b][pt[a][b]++].first;
        a = rem.second.first, b = rem.second.second;
        cur[a][b] -= w[a][b][--pt[a][b]].first;
      } else {
        break;
      }
    }
    if (pt[1][1] + min(pt[0][1], pt[1][0]) >= k &&
        pt[1][1] + pt[1][0] + pt[0][1] + pt[0][0] == m) {
      long long val = cur[0][0] + cur[1][0] + cur[0][1] + cur[1][1];
      if (val < res) {
        res = val;
        for (long long a : {0, 1}) {
          for (long long b : {0, 1}) {
            id[a][b] = pt[a][b];
          }
        }
      }
    }
    --pt[1][1];
    if (pt[1][1] >= 0) {
      cur[1][1] -= w[1][1][pt[1][1]].first;
    }
  }
  if (res == inf) {
    cout << -1 << '\n';
    return 0;
  }
  cout << res << '\n';
  for (long long a : {0, 1}) {
    for (long long b : {0, 1}) {
      for (long long i = 0; i < id[a][b]; i++) {
        cout << w[a][b][i].second + 1 << ' ';
      }
    }
  }
  cout << endl;
  return 0;
}
