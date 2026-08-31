#include <bits/stdc++.h>
using namespace std;
int n, s, a[200020], b[200020], p[200020];
bool cmp(int i, int j) { return a[i] < a[j]; }
int rt[200020];
int findrt(int x) {
  if (rt[x] != x) rt[x] = findrt(rt[x]);
  return rt[x];
}
int get(int x) { return lower_bound(b + 1, b + n + 1, x) - b; }
map<int, int> S;
int c[200020];
bool vis[200020];
int tot;
vector<int> ans[200020];
int q[200020];
int main() {
  cin >> n >> s;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), b[i] = a[i];
  sort(b + 1, b + n + 1);
  int cnt = n;
  for (int i = 1; i <= n; i++)
    if (a[i] == b[i]) q[i] = i, cnt--;
  if (cnt > s) {
    puts("-1");
    return 0;
  }
  vector<int> v;
  for (int i = 1; i <= n; i++)
    if (!q[i]) v.push_back(i);
  sort(v.begin(), v.end(), cmp);
  for (int i = 1, j = 0; i <= n; i++) {
    if (q[i]) continue;
    q[i] = v[j];
    j++;
  }
  for (int i = 1; i <= n; i++) p[q[i]] = i;
  for (int i = 1; i <= n; i++) assert(a[i] == b[p[i]]);
  for (int i = 1; i <= n; i++) rt[i] = i;
  for (int i = 1; i <= n; i++) {
    if (p[i] == i) continue;
    int l = findrt(i), r = findrt(p[i]);
    if (l == r) continue;
    rt[l] = r;
  }
  for (int i = 1; i <= n; i++) {
    if (p[i] == i) continue;
    if (!S.count(a[i])) {
      S[a[i]] = i;
      continue;
    }
    int l = S[a[i]];
    int fl = findrt(l), fr = findrt(i);
    if (fl == fr) continue;
    rt[fr] = fl;
    swap(p[l], p[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (p[i] == i) {
      vis[i] = 1;
      continue;
    }
    if (vis[i]) continue;
    tot++;
    vector<int> &cur = ans[tot];
    int now = i;
    while (1) {
      vis[now] = 1;
      cur.push_back(now);
      now = p[now];
      if (now == i) break;
    }
  }
  int k = s - cnt;
  k = min(tot, k);
  if (k >= 3) {
    vector<int> cur;
    for (int i = 0; i < k; i++) cur.push_back(ans[tot - i][0]);
    vector<int> &to = ans[tot - k + 1];
    for (int i = k - 2; i >= 0; i--) {
      for (int x : ans[tot - i]) to.push_back(x);
    }
    ans[tot - k + 2] = cur;
    tot -= k - 2;
  }
  cout << tot << endl;
  for (int i = 1; i <= tot; i++) {
    cout << ans[i].size() << endl;
    for (int x : ans[i]) printf("%d ", x);
    puts("");
  }
}
