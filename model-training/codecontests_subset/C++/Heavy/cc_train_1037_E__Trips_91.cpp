#include <bits/stdc++.h>
using namespace std;
template <class X, class Y>
void amax(X& x, const Y& y) {
  if (x < y) x = y;
}
template <class X, class Y>
void amin(X& x, const Y& y) {
  if (x > y) x = y;
}
const int INF = 1e9 + 10;
const long long INFL = (long long)1e18 + 10;
const int MAX = 2e5 + 10;
int n, m, k;
int cnt[MAX];
pair<int, int> ed[MAX];
bool mark[MAX], removed[MAX];
vector<pair<int, int> > es[MAX];
stack<int> st;
void invalid_push(int v) {
  if (!mark[v] && cnt[v] < k) {
    mark[v] = true;
    st.push(v);
  }
}
void process() {
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> ed[i].first >> ed[i].second;
    cnt[ed[i].first]++;
    cnt[ed[i].second]++;
    es[ed[i].first].push_back(make_pair(ed[i].second, i));
    es[ed[i].second].push_back(make_pair(ed[i].first, i));
  }
  for (int i = 1; i <= n; i++) invalid_push(i);
  vector<int> ans;
  int res = n;
  for (int i = m; i >= 1; i--) {
    while (!st.empty()) {
      int u = st.top();
      st.pop();
      res--;
      for (auto e : es[u])
        if (!mark[e.first] && !removed[e.second]) {
          removed[e.second] = true;
          cnt[e.first]--;
          invalid_push(e.first);
        }
    }
    ans.push_back(res);
    if (!removed[i]) {
      removed[i] = true;
      cnt[ed[i].first]--;
      cnt[ed[i].second]--;
      invalid_push(ed[i].first);
      invalid_push(ed[i].second);
    }
  }
  for (int i = int(ans.size()) - 1; i >= 0; i--) cout << ans[i] << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  process();
}
