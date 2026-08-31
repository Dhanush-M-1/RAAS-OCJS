#include <bits/stdc++.h>
using namespace std;
const int N = 200100;
int n, m, k, sa, sb, ans = 2e9 + 10000, calc, x, ty, sz1, res[N], tim;
struct item {
  int t, a, b;
} a[N];
vector<pair<int, int> > b[4];
priority_queue<pair<int, int> > s, t;
bool cmp(pair<int, int> a, pair<int, int> b) { return a.first < b.first; }
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  a[0].t = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].t >> a[i].a >> a[i].b;
    sa += a[i].a;
    sb += a[i].b;
    if (a[i].a + a[i].b == 2)
      b[2].push_back({a[i].t, i});
    else if (a[i].a == 1)
      b[0].push_back({a[i].t, i});
    else if (a[i].b == 1)
      b[1].push_back({a[i].t, i});
    else
      b[3].push_back({a[i].t, i});
  }
  if (min(sa, sb) < k) {
    cout << -1;
    return 0;
  }
  sort(b[0].begin(), b[0].end(), &cmp);
  sort(b[1].begin(), b[1].end(), &cmp);
  sort(b[2].begin(), b[2].end(), &cmp);
  sort(b[3].begin(), b[3].end(), &cmp);
  sa = sb = 0;
  sz1 = 0;
  for (int i = 0; i < b[0].size(); i++)
    if (i < k)
      sa += b[0][i].first, sz1++;
    else
      sb += b[0][i].first, s.push({b[0][i].first, i});
  for (int i = 0; i < b[1].size(); i++)
    if (i < k)
      sa += b[1][i].first, sz1++;
    else
      sb += b[1][i].first, s.push({b[1][i].first, i + n});
  for (int i = 0; i < b[3].size(); i++)
    sb += b[3][i].first, s.push({b[3][i].first, i + 3 * n});
  while (!s.empty() && s.size() + sz1 > m) {
    x = s.top().second;
    s.pop();
    ty = x / n;
    x %= n;
    sb -= b[ty][x].first;
    t.push({-b[ty][x].first, x + ty * n});
  }
  for (int i = 0; i <= b[2].size(); i++) {
    if (i + min(b[0].size(), b[1].size()) >= k && max(i, 2 * k - i) <= m &&
        s.size() + sz1 == m && ans > sa + sb)
      ans = sa + sb, tim = i;
    if (!t.empty()) {
      x = t.top().second;
      t.pop();
      ty = x / n;
      x %= n;
      sb += b[ty][x].first;
      s.push({b[ty][x].first, x + ty * n});
    }
    if (k - i > 0 && k - i <= b[0].size())
      sz1--, sa -= b[0][k - i - 1].first, sb += b[0][k - i - 1].first,
          s.push({b[0][k - i - 1].first, k - i - 1});
    if (k - i > 0 && k - i <= b[1].size())
      sz1--, sa -= b[1][k - i - 1].first, sb += b[1][k - i - 1].first,
          s.push({b[1][k - i - 1].first, k - i - 1 + n});
    if (i < b[2].size()) sz1++, sa += b[2][i].first;
    while (!s.empty() && s.size() + sz1 > m) {
      x = s.top().second;
      s.pop();
      ty = x / n;
      x %= n;
      sb -= b[ty][x].first;
      t.push({-b[ty][x].first, x + ty * n});
    }
  }
  while (!s.empty()) s.pop();
  while (!t.empty()) t.pop();
  sa = sb = 0;
  sz1 = 0;
  for (int i = 0; i < b[0].size(); i++)
    if (i < k)
      sa += b[0][i].first, sz1++;
    else
      sb += b[0][i].first, s.push({b[0][i].first, i});
  for (int i = 0; i < b[1].size(); i++)
    if (i < k)
      sa += b[1][i].first, sz1++;
    else
      sb += b[1][i].first, s.push({b[1][i].first, i + n});
  for (int i = 0; i < b[3].size(); i++)
    sb += b[3][i].first, s.push({b[3][i].first, i + 3 * n});
  while (!s.empty() && s.size() + sz1 > m) {
    x = s.top().second;
    s.pop();
    ty = x / n;
    x %= n;
    sb -= b[ty][x].first;
    t.push({-b[ty][x].first, x + ty * n});
  }
  for (int i = 0; i <= b[2].size(); i++) {
    if (i == tim) {
      for (int j = 1; j <= i; j++) res[b[2][j - 1].second] = 1;
      for (int j = 1; j <= min(k - i, int(b[0].size())); j++)
        res[b[0][j - 1].second] = 1;
      for (int j = 1; j <= min(k - i, int(b[1].size())); j++)
        res[b[1][j - 1].second] = 1;
      while (!s.empty()) {
        x = s.top().second;
        s.pop();
        ty = x / n;
        x %= n;
        res[b[ty][x].second] = 1;
      }
      break;
    }
    if (!t.empty()) {
      x = t.top().second;
      t.pop();
      ty = x / n;
      x %= n;
      sb += b[ty][x].first;
      s.push({b[ty][x].first, x + ty * n});
    }
    if (k - i > 0 && k - i <= b[0].size())
      sz1--, sa -= b[0][k - i - 1].first, sb += b[0][k - i - 1].first,
          s.push({b[0][k - i - 1].first, k - i - 1});
    if (k - i > 0 && k - i <= b[1].size())
      sz1--, sa -= b[1][k - i - 1].first, sb += b[1][k - i - 1].first,
          s.push({b[1][k - i - 1].first, k - i - 1 + n});
    if (i < b[2].size()) sz1++, sa += b[2][i].first;
    while (!s.empty() && s.size() + sz1 > m) {
      x = s.top().second;
      s.pop();
      ty = x / n;
      x %= n;
      sb -= b[ty][x].first;
      t.push({-b[ty][x].first, x + ty * n});
    }
  }
  if (ans > 2e9) {
    cout << -1;
    return 0;
  }
  cout << ans << endl;
  for (int i = 1; i <= n; i++)
    if (res[i]) cout << i << " ";
}
