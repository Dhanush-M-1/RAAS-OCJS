#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> V2(int a, int b, int v) {
  return vector<vector<int>>(a, vector<int>(b, v));
}
vector<vector<vector<int>>> V3(int a, int b, int c, int v) {
  return vector<vector<vector<int>>>(a, V2(b, c, v));
}
void Read(vector<vector<int>>& x) {
  int n = x.size(), m = x[0].size();
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) cin >> x[i][j];
  }
}
void Print(const vector<vector<vector<int>>>& x) {
  int n = x.size(), m = x[0].size(), o = x[0][0].size();
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      for (int k = 0; k < o; ++k) cout << x[i][j][k] << " ";
      cout << '\n';
    }
    cout << '\n';
  }
}
struct Point {
  int a, b, c;
};
bool Inside(Point t, int n, int m, int k) {
  return 0 <= t.a && t.a < n && 0 <= t.b && t.b < m && 0 <= t.c && t.c < k;
}
void UpdateColor(int& cc, int newc, bool& flag) {
  if (cc == -1) {
    cc = newc;
    return;
  }
  if (cc != newc) flag = false;
  cc = newc;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  auto x1 = V2(m, k, 0);
  auto x2 = V2(m, k, 0);
  auto y1 = V2(n, k, 0);
  auto y2 = V2(n, k, 0);
  auto z1 = V2(n, m, 0);
  auto z2 = V2(n, m, 0);
  Read(x1);
  Read(x2);
  Read(y1);
  Read(y2);
  Read(z1);
  Read(z2);
  auto ans = V3(n, m, k, -1);
  auto state = V3(n, m, k, 0);
  queue<Point> Q;
  for (int a = 0; a < n; ++a) {
    for (int b = 0; b < m; ++b) {
      for (int c = 0; c < k; ++c) {
        if (a == 0 || a == n - 1 || b == 0 || b == m - 1 || c == 0 ||
            c == k - 1) {
          Q.push({a, b, c});
          int& st = state[a][b][c];
          if (a == 0) st |= 1;
          if (a == n - 1) st |= 2;
          if (b == 0) st |= 4;
          if (b == m - 1) st |= 8;
          if (c == 0) st |= 16;
          if (c == k - 1) st |= 32;
        }
      }
    }
  }
  while (!Q.empty()) {
    Point t = Q.front();
    Q.pop();
    int st = state[t.a][t.b][t.c];
    int cc = -1;
    bool flag = true;
    if (st & 1) UpdateColor(cc, x1[t.b][t.c], flag);
    if (st & 2) UpdateColor(cc, x2[t.b][t.c], flag);
    if (st & 4) UpdateColor(cc, y1[t.a][t.c], flag);
    if (st & 8) UpdateColor(cc, y2[t.a][t.c], flag);
    if (st & 16) UpdateColor(cc, z1[t.a][t.b], flag);
    if (st & 32) UpdateColor(cc, z2[t.a][t.b], flag);
    ans[t.a][t.b][t.c] = cc;
    if (flag && cc != 0) continue;
    ans[t.a][t.b][t.c] = 0;
    if ((st & 1) != 0 && (st & 2) == 0) {
      Point s = t;
      while (true) {
        ++s.a;
        if (!Inside(s, n, m, k)) break;
        if (state[s.a][s.b][s.c] & 1) break;
        state[s.a][s.b][s.c] |= 1;
        if (ans[s.a][s.b][s.c] == 0) continue;
        Q.push(s);
        break;
      }
    }
    if ((st & 1) == 0 && (st & 2) != 0) {
      Point s = t;
      while (true) {
        --s.a;
        if (!Inside(s, n, m, k)) break;
        if (state[s.a][s.b][s.c] & 2) break;
        state[s.a][s.b][s.c] |= 2;
        if (ans[s.a][s.b][s.c] == 0) continue;
        Q.push(s);
        break;
      }
    }
    if ((st & 4) != 0 && (st & 8) == 0) {
      Point s = t;
      while (true) {
        ++s.b;
        if (!Inside(s, n, m, k)) break;
        if (state[s.a][s.b][s.c] & 4) break;
        state[s.a][s.b][s.c] |= 4;
        if (ans[s.a][s.b][s.c] == 0) continue;
        Q.push(s);
        break;
      }
    }
    if ((st & 4) == 0 && (st & 8) != 0) {
      Point s = t;
      while (true) {
        --s.b;
        if (!Inside(s, n, m, k)) break;
        if (state[s.a][s.b][s.c] & 8) break;
        state[s.a][s.b][s.c] |= 8;
        if (ans[s.a][s.b][s.c] == 0) continue;
        Q.push(s);
        break;
      }
    }
    if ((st & 16) != 0 && (st & 32) == 0) {
      Point s = t;
      while (true) {
        ++s.c;
        if (!Inside(s, n, m, k)) break;
        if (state[s.a][s.b][s.c] & 16) break;
        state[s.a][s.b][s.c] |= 16;
        if (ans[s.a][s.b][s.c] == 0) continue;
        Q.push(s);
        break;
      }
    }
    if ((st & 16) == 0 && (st & 32) != 0) {
      Point s = t;
      while (true) {
        --s.c;
        if (!Inside(s, n, m, k)) break;
        if (state[s.a][s.b][s.c] & 32) break;
        state[s.a][s.b][s.c] |= 32;
        if (ans[s.a][s.b][s.c] == 0) continue;
        Q.push(s);
        break;
      }
    }
  }
  auto xx = V2(m, k, 0);
  auto yy = V2(n, k, 0);
  auto zz = V2(n, m, 0);
  for (int a = 0; a < n; ++a) {
    for (int b = 0; b < m; ++b) {
      for (int c = 0; c < k; ++c) {
        if (ans[a][b][c] == 0) continue;
        if (ans[a][b][c] == -1) ans[a][b][c] = 1;
        xx[b][c] = 1;
        yy[a][c] = 1;
        zz[a][b] = 1;
      }
    }
  }
  bool flag = true;
  for (int i = 0; i < m; ++i) {
    for (int j = 0; j < k; ++j) {
      if (xx[i][j] != 0) continue;
      if (x1[i][j] != x2[i][j]) flag = false;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < k; ++j) {
      if (yy[i][j] != 0) continue;
      if (y1[i][j] != y2[i][j]) flag = false;
    }
  }
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      if (zz[i][j] != 0) continue;
      if (z1[i][j] != z2[i][j]) flag = false;
    }
  }
  if (!flag) {
    cout << -1 << endl;
    return 0;
  }
  Print(ans);
  return 0;
}
