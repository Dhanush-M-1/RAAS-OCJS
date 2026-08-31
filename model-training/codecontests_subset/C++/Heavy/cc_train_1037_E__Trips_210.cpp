#include <bits/stdc++.h>
const int maxn = 2e5 + 10;
const int maxm = 1.5e7 + 10;
const int mod = 998244353;
using namespace std;
int n, m, k, ans;
int num[maxn], vis[maxn], sum[maxn];
pair<int, int> a[maxn];
set<int> st[maxn];
void check(int x) {
  if (num[x] >= k || !vis[x]) return;
  vis[x] = 0;
  ans--;
  queue<int> q;
  q.push(x);
  while (!q.empty()) {
    int tmp = q.front();
    q.pop();
    set<int>::iterator it = st[tmp].begin();
    while (it != st[tmp].end()) {
      num[*it]--;
      if (vis[*it] && num[*it] < k) {
        q.push(*it);
        vis[*it] = 0;
        ans--;
      }
      it++;
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  ans = n;
  for (int i = 1; i <= n; i++) vis[i] = 1;
  for (int i = 0; i < m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    a[i].first = x, a[i].second = y;
    num[x]++, num[y]++;
    st[x].insert(y), st[y].insert(x);
  }
  for (int i = 1; i <= n; i++) check(i);
  for (int i = m - 1; i >= 0; i--) {
    sum[i] = ans;
    if (vis[a[i].second]) num[a[i].first]--;
    if (vis[a[i].first]) num[a[i].second]--;
    st[a[i].first].erase(a[i].second);
    st[a[i].second].erase(a[i].first);
    check(a[i].first), check(a[i].second);
  }
  for (int i = 0; i < m; i++) printf("%d\n", sum[i]);
  return 0;
}
