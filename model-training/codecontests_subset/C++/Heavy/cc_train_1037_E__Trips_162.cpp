#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long n, m, k;
  cin >> n >> m >> k;
  vector<vector<pair<long long, long long> > > friends(n);
  vector<long long> pointers(n);
  for (long long i = 0; i < m; i++) {
    long long a, b;
    cin >> a >> b;
    friends[a - 1].push_back(make_pair(b - 1, i));
    friends[b - 1].push_back(make_pair(a - 1, i));
  }
  queue<long long> q;
  set<pair<long long, long long> > good;
  for (long long i = 0; i < n; i++) {
    if (friends[i].size() >= k) {
      good.insert(make_pair(friends[i][k - 1].second, i));
      pointers[i] = k - 1;
    } else {
      pointers[i] = -1;
      q.push(i);
    }
  }
  long long u = m;
  vector<long long> ans(m);
  fill(ans.begin(), ans.end(), 0);
  vector<bool> used(n);
  fill(used.begin(), used.end(), false);
  while (good.size()) {
    while (q.size()) {
      long long V = q.front();
      q.pop();
      used[V] = true;
      for (long long i = 0; i < friends[V].size(); i++) {
        long long to = friends[V][i].first, tm = friends[V][i].second;
        if (pointers[to] == -1) continue;
        long long T = friends[to][pointers[to]].second;
        if (tm > T) continue;
        pointers[to]++;
        while (pointers[to] < friends[to].size()) {
          long long K = friends[to][pointers[to]].first;
          if (used[K] || friends[to][pointers[to]].second >= u)
            pointers[to]++;
          else
            break;
        }
        if (pointers[to] >= friends[to].size()) {
          good.erase(good.find(make_pair(T, to)));
          pointers[to] = -1;
          q.push(to);
        } else {
          good.erase(good.find(make_pair(T, to)));
          T = friends[to][pointers[to]].second;
          good.insert(make_pair(T, to));
        }
      }
    }
    long long S = good.size();
    if (S == 0) break;
    set<pair<long long, long long> >::iterator it = good.end();
    it--;
    pair<long long, long long> P = *it;
    long long tt = P.first;
    for (long long i = tt; i < u; i++) ans[i] = S;
    u = tt;
    while (good.size()) {
      set<pair<long long, long long> >::iterator it = good.end();
      it--;
      pair<long long, long long> P = *it;
      long long ttt = P.first;
      if (tt != ttt) {
        break;
      }
      good.erase(it);
      pointers[P.second] = -1;
      q.push(P.second);
    }
  }
  for (long long i = 0; i < m; i++) cout << ans[i] << "\n";
}
