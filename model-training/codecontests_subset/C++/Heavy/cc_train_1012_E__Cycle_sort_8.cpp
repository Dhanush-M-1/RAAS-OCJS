#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 100;
int n, limit;
int nxt[N], lab[N], flag[N];
pair<int, int> a[N];
vector<int> ans1, ans2;
vector<vector<int> > ans3;
vector<pair<int, int> > v;
int root(int u) {
  if (lab[u] < 0) return u;
  return lab[u] = root(lab[u]);
}
void join(int u, int v) {
  int l1 = root(u), l2 = root(v);
  if (l1 == l2) return;
  if (lab[l1] > lab[l2]) swap(l1, l2);
  lab[l1] += lab[l2];
  lab[l2] = l1;
}
void show(vector<int> &s) {
  cout << s.size() << '\n';
  for (auto &x : s) cout << x << ' ';
  cout << '\n';
}
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> limit;
  memset(lab, -1, sizeof lab);
  for (int i = 1; i <= n; ++i) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; ++i) {
    int j1 = i, j2 = i;
    while (j2 < n && a[j2 + 1].first == a[j2].first) j2++;
    for (; i <= j2; ++i) {
      while (j1 <= a[i].second && a[i].second <= j2 && a[i].second != i)
        swap(a[i], a[a[i].second]);
    }
    i = j2;
  }
  for (int i = 1; i <= n; ++i)
    if (a[i].second != i) {
      nxt[a[i].second] = i;
      join(a[i].second, i);
      v.push_back(a[i]);
    }
  for (int i = 0; i < v.size(); ++i) {
    while (i + 1 < v.size() && v[i + 1].first == v[i].first) {
      i++;
      int idx1 = v[i].second, idx2 = v[i - 1].second;
      if (root(idx1) == root(idx2)) continue;
      join(idx1, idx2);
      swap(nxt[idx1], nxt[idx2]);
    }
  }
  int sum = 0, tmp = 0;
  for (int i = 1; i <= n; ++i)
    if (a[i].second != i && !flag[root(a[i].second)]) {
      flag[root(a[i].second)] = true;
      tmp++;
      sum += abs(lab[root(a[i].second)]);
    }
  if (limit < sum) {
    cout << -1;
    return 0;
  }
  int addmx = limit - sum;
  int cnt = 0;
  memset(flag, 0, sizeof flag);
  for (int i = 1; i <= n; ++i)
    if (a[i].second != i && !flag[root(a[i].second)]) {
      flag[root(a[i].second)] = true;
      cnt++;
      if (cnt <= addmx) {
        ans2.push_back(a[i].second);
        int cur = a[i].second;
        do {
          ans1.push_back(cur);
          cur = nxt[cur];
        } while (cur != a[i].second);
      } else {
        vector<int> cycle;
        int cur = a[i].second;
        do {
          cycle.push_back(cur);
          cur = nxt[cur];
        } while (cur != a[i].second);
        ans3.push_back(cycle);
      }
    }
  if (ans1.size()) ans3.push_back(ans1);
  reverse(ans2.begin(), ans2.end());
  if (ans2.size() > 1) ans3.push_back(ans2);
  cout << ans3.size() << '\n';
  for (auto &s : ans3) show(s);
  return 0;
}
