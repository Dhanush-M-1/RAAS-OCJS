#include <bits/stdc++.h>
using namespace std;
int m1[100001];
vector<int> m2[100001];
map<int, int> mp[100001];
int main() {
  int n = 1;
  int maxx, maxy, w;
  cin >> maxx >> maxy >> w;
  for (int i = 1; i <= maxx; i++) {
    int x = i, y = 0;
    while (x) {
      y = y * 10 + (x % 10);
      x /= 10;
    }
    x = i;
    int g = x, b = y;
    while (b) {
      int x2 = b;
      b = g % b;
      g = x2;
    }
    x /= g;
    y /= g;
    g = mp[x][y];
    if (!g) {
      mp[x][y] = n++;
      g = n - 1;
    }
    m1[i] = g;
  }
  n = 0;
  for (int i = 1; i <= maxy; i++) {
    int x = i, y = 0;
    while (x) {
      y = y * 10 + (x % 10);
      x /= 10;
    }
    x = i;
    int g = x, b = y;
    while (b) {
      int x2 = b;
      b = g % b;
      g = x2;
    }
    x /= g;
    y /= g;
    g = mp[y][x];
    if (g) {
      m2[g].push_back(i);
      n = max(n, (int)m2[g].size());
    }
  }
  long long MH = (long long)(maxx + 1ll) * (long long)(maxy + 1ll);
  long long l = 0, h = MH;
  while (l <= h) {
    long long m = (l + h) / 2ll;
    int t = 0;
    int cnt = 0;
    priority_queue<int> q;
    for (int x = 1; x <= maxx && !t; x++) {
      long long h2 = m / x;
      while (!q.empty() && q.top() > h2) q.pop();
      int y = m1[x];
      for (int i = 0; i < m2[y].size() && m2[y][i] <= h2; i++) {
        q.push(m2[y][i]);
      }
      if (q.size() >= w) t = 1;
    }
    if (t)
      h = m - 1;
    else
      l = m + 1;
  }
  if (l < MH) {
    priority_queue<int> q;
    int t = 0;
    int x1, y1;
    for (int x = 1; x <= maxx && !t; x++) {
      while (!q.empty() && (long long)x * (long long)q.top() > l) q.pop();
      int y = m1[x];
      for (int i = 0;
           i < m2[y].size() && (long long)x * (long long)m2[y][i] <= l; i++)
        q.push(m2[y][i]);
      if (q.size() >= w) {
        t = 1;
        x1 = x;
        y1 = q.top();
      }
    }
    cout << x1 << " " << y1 << endl;
  } else
    cout << -1 << endl;
  return 0;
}
