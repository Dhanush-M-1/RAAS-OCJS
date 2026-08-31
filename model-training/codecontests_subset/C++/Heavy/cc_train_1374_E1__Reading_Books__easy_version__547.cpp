#include <bits/stdc++.h>
using namespace std;
const int maxm = 2e3 + 23;
const int maxn = 2e5 + 35;
int n, k, t[maxn], vis[maxn], a, b, num, m;
vector<int> ve[4], ee;
vector<pair<int, int> > we;
bool cmp(int i, int j) { return t[i] < t[j]; }
struct node {
  int ii, tt;
  friend bool operator<(node a, node b) { return a.tt > b.tt; }
};
int main() {
  scanf("%d %d %d", &n, &m, &k);
  priority_queue<node> se;
  for (int i = 1; i <= n; ++i) {
    scanf("%d %d %d", t + i, &a, &b);
    if (a && b)
      ve[2].push_back(i);
    else if (a)
      ve[0].push_back(i);
    else if (b)
      ve[1].push_back(i);
    else
      se.push((node){i, t[i]});
  }
  sort((ve[0]).begin(), (ve[0]).end(), cmp);
  sort((ve[1]).begin(), (ve[1]).end(), cmp);
  sort((ve[2]).begin(), (ve[2]).end(), cmp);
  int x0 = 0, x1 = 0, x2 = 0, ans = 0;
  set<int> s;
  while (k) {
    if (x1 < (int)(ve[1]).size() && x0 < (int)(ve[0]).size()) {
      if (x2 < (int)(ve[2]).size()) {
        if (t[ve[2][x2]] < t[ve[0][x0]] + t[ve[1][x1]]) {
          ans += t[ve[2][x2]];
          s.insert(ve[2][x2]);
          ee.push_back(ve[2][x2]);
          k -= 1;
          x2 += 1;
          num += 1;
        } else {
          ans += t[ve[0][x0]] + t[ve[1][x1]];
          s.insert(ve[0][x0]);
          s.insert(ve[1][x1]);
          we.push_back(pair<int, int>(ve[0][x0], ve[1][x1]));
          k -= 1;
          x0 += 1;
          x1 += 1;
          num += 2;
        }
      } else {
        ans += t[ve[0][x0]] + t[ve[1][x1]];
        we.push_back(pair<int, int>(ve[0][x0], ve[1][x1]));
        s.insert(ve[0][x0]);
        s.insert(ve[1][x1]);
        k -= 1;
        x0 += 1;
        x1 += 1;
        num += 2;
      }
    } else if (x2 < (int)(ve[2]).size()) {
      ans += t[ve[2][x2]];
      s.insert(ve[2][x2]);
      ee.push_back(ve[2][x2]);
      k -= 1;
      x2 += 1;
      num += 1;
    } else
      break;
  }
  if (k > 0) return puts("-1"), 0;
  if (num < m) {
    for (int i = x0; i < (int)(ve[0]).size(); ++i)
      se.push((node){ve[0][i], t[ve[0][i]]});
    for (int i = x1; i < (int)(ve[1]).size(); ++i)
      se.push((node){ve[1][i], t[ve[1][i]]});
    for (int i = x2; i < (int)(ve[2]).size(); ++i)
      se.push((node){ve[2][i], t[ve[2][i]]});
    int first = (int)(ee).size() - 1;
    while (num < m && x0 < (int)(ve[0]).size() && x1 < (int)(ve[1]).size() &&
           first >= 0 && (int)(se).size() > 0) {
      while (vis[se.top().ii]) se.pop();
      if ((int)(se).size() == 0) break;
      if (t[ee[first]] + (se.top()).tt < t[ve[0][x0]] + t[ve[1][x1]]) {
        ans += (se.top()).tt;
        vis[(se.top()).ii] = 1;
        s.insert((se.top()).ii);
        se.pop();
        num += 1;
      } else {
        ans += t[ve[0][x0]] + t[ve[1][x1]];
        ans -= t[ee[first]];
        vis[ve[0][x0]] = 1;
        vis[ve[1][x1]] = 1;
        se.push((node){ee[first], t[ee[first]]});
        s.insert(ve[0][x0]);
        s.insert(ve[1][x1]);
        s.erase(ee[first]);
        first -= 1;
        x0 += 1;
        x1 += 1;
        num += 1;
      }
      while (vis[ve[0][x0]]) x0 += 1;
      while (vis[ve[1][x1]]) x1 += 1;
    }
    while (num < m && !se.empty()) {
      ans += se.top().tt;
      s.insert(se.top().ii);
      se.pop();
      num += 1;
    }
  } else {
    int first = (int)(we).size() - 1;
    while (num > m && x2 < (int)(ve[2]).size()) {
      s.erase(we[first].first);
      s.erase(we[first].second);
      ans = ans - t[we[first].first] - t[we[first].second];
      first -= 1;
      s.insert(ve[2][x2]);
      ans += t[ve[2][x2]];
      x2 += 1;
      num -= 1;
    }
  }
  if ((int)(s).size() == m) {
    printf("%d\n", ans);
    for (set<int>::iterator it = s.begin(); it != s.end(); ++it)
      printf("%d ", *it);
  } else
    puts("-1");
  return 0;
}
