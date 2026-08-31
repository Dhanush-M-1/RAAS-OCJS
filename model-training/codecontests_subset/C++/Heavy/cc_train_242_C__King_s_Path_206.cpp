#include <bits/stdc++.h>
using namespace std;
long long int power(long long int a, long long int b) {
  if (b == 0) return 1;
  long long int p = power(a, b / 2);
  if (b % 2 == 0)
    return p * p;
  else
    return a * p * p;
}
long int gcd(long int a, long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
pair<long int, long int> p, s, t;
map<pair<long int, long int>, long int> allow, vis, ans;
void bfs(long int a, long int b) {
  queue<pair<long int, long int> > q;
  p = make_pair(a, b);
  vis[p] = 1;
  q.push(p);
  ans[p] = 1;
  while (q.size()) {
    p = q.front();
    q.pop();
    if (p.first < 1000000000 && p.second < 1000000000) {
      s = make_pair((p.first) + 1, (p.second) + 1);
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.first < 1000000000 && p.second > 1) {
      s = make_pair((p.first) + 1, (p.second) - 1);
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.first < 1000000000) {
      s = make_pair((p.first) + 1, (p.second));
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.second < 1000000000) {
      s = make_pair((p.first), (p.second) + 1);
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.second > 1) {
      s = make_pair((p.first), (p.second) - 1);
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.first > 1 && p.second > 1) {
      s = make_pair((p.first) - 1, (p.second) - 1);
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.first > 1) {
      s = make_pair((p.first) - 1, (p.second));
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
    if (p.first > 1 && p.second < 1000000000) {
      s = make_pair((p.first) - 1, (p.second) + 1);
      if (!vis.count(s) && allow.count(s)) {
        q.push(s);
        vis[s] = 1;
        ans[s] = ans[p] + 1;
        if (s == t) break;
      }
    }
  }
}
int main() {
  std::ios_base::sync_with_stdio(false);
  long int x0, y0, x1, y1, n, i, j, r, a, b;
  cin >> x0 >> y0 >> x1 >> y1 >> n;
  for (i = 0; i < n; i++) {
    cin >> r >> a >> b;
    for (j = a; j <= b; j++) {
      p = make_pair(r, j);
      allow[p] = 1;
    }
  }
  t = make_pair(x1, y1);
  bfs(x0, y0);
  if (!ans.count(t))
    cout << "-1";
  else
    cout << ans[t] - 1;
}
