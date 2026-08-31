#include <bits/stdc++.h>
using namespace std;
priority_queue<pair<int64_t, int64_t>, vector<pair<int64_t, int64_t>>,
               greater<pair<int64_t, int64_t>>>
    a, b, c, d;
priority_queue<pair<int64_t, int64_t>> both;
vector<int64_t> ans;
vector<pair<int64_t, pair<int64_t, int64_t>>> prblm;
map<int64_t, bool> ok;
int64_t n, m, k, t;
void print() {
  cout << t << '\n';
  unordered_set<int64_t> s;
  for (auto j : ans)
    if (!ok[j]) s.insert(j + 1);
  for (auto j : s) cout << j << ' ';
}
void m_greater() {
  int64_t x, y, z, w, u, cnt;
  cnt = ans.size();
  while (cnt < m) {
    if (a.size())
      x = a.top().first;
    else
      x = LLONG_MAX;
    if (b.size())
      y = b.top().first;
    else
      y = LLONG_MAX;
    if (c.size())
      z = c.top().first;
    else
      z = LLONG_MAX;
    if (d.size())
      w = d.top().first;
    else
      w = LLONG_MAX;
    if (both.size())
      u = both.top().first;
    else
      u = LLONG_MAX;
    if (min({x, y, z, w}) == LLONG_MAX) {
      cout << "-1" << '\n';
      return;
    }
    if (a.size() and b.size() and both.size() and
        x + y <= u + min({x, y, z, w})) {
      int64_t val = a.top().second;
      t -= u;
      t += x + y;
      ans.push_back((val));
      ans.push_back(b.top().second);
      int64_t q = both.top().second;
      ok[q] = true;
      a.pop();
      b.pop();
      c.push(both.top());
      both.pop();
    } else if (min({x, y, z, w}) == x) {
      t += x;
      ans.push_back(a.top().second);
      a.pop();
    } else if (min({x, y, z, w}) == y) {
      t += y;
      ans.push_back(b.top().second);
      b.pop();
    } else if (min({x, y, z, w}) == w) {
      t += w;
      ans.push_back(d.top().second);
      d.pop();
    } else if (min({x, y, z, w}) == z) {
      t += z;
      ans.push_back(c.top().second);
      if (ok[ans.back()]) ok[ans.back()] = false;
      c.pop();
    }
    cnt++;
  }
  print();
}
void m_less() {
  int64_t x, y, cnt;
  cnt = 0;
  sort(prblm.begin(), prblm.end());
  cnt = ans.size();
  while (cnt > m) {
    if (c.size() == 0 or prblm.size() == 0) break;
    int64_t val = prblm.back().first;
    x = prblm.back().second.first;
    y = prblm.back().second.second;
    prblm.pop_back();
    ok[x] = true;
    ok[y] = true;
    t -= val;
    t += c.top().first;
    ans.push_back(c.top().second);
    c.pop();
    cnt--;
  }
  if (cnt > m) {
    cout << "-1";
    return;
  }
  print();
}
void solve() {
  int64_t i, x, y, z, cnt;
  cin >> n >> m >> k;
  for (i = 0; i < n; i++) {
    cin >> t >> x >> y;
    if (x == y and x == 1)
      c.push({t, i});
    else if (x == 1 and y == 0)
      a.push({t, i});
    else if (x == 0 and y == 1)
      b.push({t, i});
    else
      d.push({t, i});
  }
  t = 0;
  cnt = 0;
  while (1) {
    if (cnt >= k) break;
    if (c.size() == 0 and (a.size() == 0 or b.size() == 0)) break;
    if (a.size())
      x = a.top().first;
    else
      x = LLONG_MAX;
    if (b.size())
      y = b.top().first;
    else
      y = LLONG_MAX;
    if (c.size())
      z = c.top().first;
    else
      z = LLONG_MAX;
    if (a.size() > 0 and b.size() > 0 and x + y <= z) {
      t += x + y;
      ans.push_back(a.top().second);
      ans.push_back(b.top().second);
      prblm.push_back({x + y, {a.top().second, b.top().second}});
      a.pop();
      b.pop();
      cnt++;
    } else {
      t += z;
      ans.push_back(c.top().second);
      both.push({z, c.top().second});
      c.pop();
      cnt++;
    }
  }
  if (cnt < k) {
    cout << "-1" << '\n';
    return;
  }
  if (ans.size() > m) {
    m_less();
    return;
  } else {
    m_greater();
    return;
  }
}
signed main() {
  std::ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  { solve(); }
  cerr << " Execution : " << (1.0 * clock()) / CLOCKS_PER_SEC << "s \n";
  return 0;
}
