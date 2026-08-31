#include <bits/stdc++.h>
using namespace std;
int n, m, k, ok, nn, mm, kk;
queue<pair<pair<int, int>, int> > q;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  pair<int, int> mk[m + 1][k + 1], nk[n + 1][k + 1], nm[n + 1][m + 1],
      qmk[m + 1][k + 1], qnk[n + 1][k + 1], qnm[n + 1][m + 1];
  int nmk[n + 1][m + 1][k + 1];
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      cin >> mk[i][j].first;
      if (mk[i][j].first == 0) mk[i][j].first = -1;
      qmk[i][j].first = 1;
      q.push(make_pair(make_pair(1, i), j));
    }
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      cin >> mk[i][j].second;
      if (mk[i][j].second == 0) mk[i][j].second = -1;
      qmk[i][j].second = n;
      q.push(make_pair(make_pair(n, i), j));
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      cin >> nk[i][j].first;
      if (nk[i][j].first == 0) nk[i][j].first = -1;
      qnk[i][j].first = 1;
      q.push(make_pair(make_pair(i, 1), j));
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      cin >> nk[i][j].second;
      if (nk[i][j].second == 0) nk[i][j].second = -1;
      qnk[i][j].second = m;
      q.push(make_pair(make_pair(i, m), j));
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      cin >> nm[i][j].first;
      if (nm[i][j].first == 0) nm[i][j].first = -1;
      qnm[i][j].first = 1;
      q.push(make_pair(make_pair(i, j), 1));
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      cin >> nm[i][j].second;
      if (nm[i][j].second == 0) nm[i][j].second = -1;
      qnm[i][j].second = k;
      q.push(make_pair(make_pair(i, j), k));
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++)
      for (int u = 1; u <= k; u++) nmk[i][j][u] = 0;
  while (!q.empty()) {
    nn = q.front().first.first;
    mm = q.front().first.second;
    kk = q.front().second;
    q.pop();
    ok = 1;
    if (nmk[nn][mm][kk] != -1) {
      if (qnm[nn][mm].first == kk)
        if (ok == 1 &&
            (nmk[nn][mm][kk] == 0 || nmk[nn][mm][kk] == nm[nn][mm].first))
          nmk[nn][mm][kk] = nm[nn][mm].first;
        else
          ok = -1;
      if (qnm[nn][mm].second == kk)
        if (ok == 1 &&
            (nmk[nn][mm][kk] == 0 || nmk[nn][mm][kk] == nm[nn][mm].second))
          nmk[nn][mm][kk] = nm[nn][mm].second;
        else
          ok = -1;
      if (qnk[nn][kk].first == mm)
        if (ok == 1 &&
            (nmk[nn][mm][kk] == 0 || nmk[nn][mm][kk] == nk[nn][kk].first))
          nmk[nn][mm][kk] = nk[nn][kk].first;
        else
          ok = -1;
      if (qnk[nn][kk].second == mm)
        if (ok == 1 &&
            (nmk[nn][mm][kk] == 0 || nmk[nn][mm][kk] == nk[nn][kk].second))
          nmk[nn][mm][kk] = nk[nn][kk].second;
        else
          ok = -1;
      if (qmk[mm][kk].first == nn)
        if (ok == 1 &&
            (nmk[nn][mm][kk] == 0 || nmk[nn][mm][kk] == mk[mm][kk].first))
          nmk[nn][mm][kk] = mk[mm][kk].first;
        else
          ok = -1;
      if (qmk[mm][kk].second == nn)
        if (ok == 1 &&
            (nmk[nn][mm][kk] == 0 || nmk[nn][mm][kk] == mk[mm][kk].second))
          nmk[nn][mm][kk] = mk[mm][kk].second;
        else
          ok = -1;
    }
    if (ok == -1 || nmk[nn][mm][kk] == -1) {
      nmk[nn][mm][kk] = -1;
      if (qnm[nn][mm].first == kk) {
        qnm[nn][mm].first++;
        if (kk < k) q.push(make_pair(make_pair(nn, mm), kk + 1));
      }
      if (qnm[nn][mm].second == kk) {
        qnm[nn][mm].second--;
        if (kk > 1) q.push(make_pair(make_pair(nn, mm), kk - 1));
      }
      if (qnk[nn][kk].first == mm) {
        qnk[nn][kk].first++;
        if (mm < m) q.push(make_pair(make_pair(nn, mm + 1), kk));
      }
      if (qnk[nn][kk].second == mm) {
        qnk[nn][kk].second--;
        if (mm > 1) q.push(make_pair(make_pair(nn, mm - 1), kk));
      }
      if (qmk[mm][kk].first == nn) {
        qmk[mm][kk].first++;
        if (nn < n) q.push(make_pair(make_pair(nn + 1, mm), kk));
      }
      if (qmk[mm][kk].second == nn) {
        qmk[mm][kk].second--;
        if (nn > 1) q.push(make_pair(make_pair(nn - 1, mm), kk));
      }
    }
  }
  ok = 1;
  for (int i = 1; i <= m; i++)
    for (int j = 1; j <= k; j++) {
      if (qmk[i][j].first > n && mk[i][j].first != -1) ok = -1;
      if (qmk[i][j].second < 1 && mk[i][j].second != -1) ok = -1;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      if (qnk[i][j].first > m && nk[i][j].first != -1) ok = -1;
      if (qnk[i][j].second < 1 && nk[i][j].second != -1) ok = -1;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= m; j++) {
      if (qnm[i][j].first > k && nm[i][j].first != -1) ok = -1;
      if (qnm[i][j].second < 1 && nm[i][j].second != -1) ok = -1;
    }
  if (ok == -1) {
    cout << "-1";
    return 0;
  } else
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= m; j++)
        for (int u = 1; u <= k; u++)
          if (nmk[i][j][u] != -1)
            cout << nmk[i][j][u] << ' ';
          else
            cout << '0' << ' ';
}
