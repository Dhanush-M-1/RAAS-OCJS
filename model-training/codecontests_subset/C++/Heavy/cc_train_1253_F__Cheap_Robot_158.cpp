#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > Next[200005];
vector<pair<long long, long long> > use[200005];
priority_queue<pair<long long, long long>, vector<pair<long long, long long> >,
               greater<pair<long long, long long> > >
    all;
priority_queue<pair<long long, pair<long long, long long> >,
               vector<pair<long long, pair<long long, long long> > >,
               greater<pair<long long, pair<long long, long long> > > >
    mst;
bool have[200005] = {0};
long long con[200005];
long long Father[200005];
long long who[25][200005];
long long big[25][200005];
long long deg[200005];
pair<long long, pair<long long, long long> > t2;
pair<long long, long long> t;
long long Find(long long here) {
  if (Father[here] == here) return here;
  Father[here] = Find(Father[here]);
  return Father[here];
}
void F(long long here, long long d) {
  long long i, j;
  have[here] = 1;
  deg[here] = d;
  for (j = 1; (1 << j) <= d; j++) {
    who[j][here] = who[j - 1][who[j - 1][here]];
    big[j][here] = max(big[j - 1][here], big[j - 1][who[j - 1][here]]);
  }
  for (auto i : use[here]) {
    if (!have[i.first]) {
      who[0][i.first] = here;
      big[0][i.first] = i.second;
      F(i.first, d + 1);
    }
  }
}
long long LCA(long long a, long long b) {
  long long i;
  if (a == b) return 0;
  if (deg[a] > deg[b])
    for (i = 20; i >= 0; i--)
      if (deg[a] - (1 << i) >= deg[b]) return max(LCA(who[i][a], b), big[i][a]);
  if (deg[a] < deg[b])
    for (i = 20; i >= 0; i--)
      if (deg[b] - (1 << i) >= deg[a]) return max(LCA(a, who[i][b]), big[i][b]);
  if (who[0][a] == who[0][b]) return max(big[0][a], big[0][b]);
  for (i = 20; i >= 0; i--)
    if ((1 << i) <= max(deg[a], deg[b]) && who[i][a] != who[i][b])
      return max(max(big[i][a], big[i][b]), LCA(who[i][a], who[i][b]));
}
int main() {
  long long N, M, K, Q, tt, i, a, b;
  scanf("%lld %lld %lld %lld", &N, &M, &K, &Q);
  for (i = 0; i < M; i++) {
    scanf("%lld %lld %lld", &a, &b, &tt);
    Next[a].push_back(make_pair(b, tt));
    Next[b].push_back(make_pair(a, tt));
  }
  for (i = 1; i <= K; i++) all.push(make_pair(0, i));
  while (!all.empty()) {
    t = all.top();
    all.pop();
    if (have[t.second]) continue;
    have[t.second] = 1;
    con[t.second] = t.first;
    for (auto i : Next[t.second])
      all.push(make_pair(t.first + i.second, i.first));
  }
  for (i = 1; i <= N; i++) {
    have[i] = 0;
    Father[i] = i;
    for (auto &j : Next[i]) {
      j.second += con[i];
      j.second += con[j.first];
      mst.push(make_pair(j.second, make_pair(i, j.first)));
    }
  }
  while (!mst.empty()) {
    t2 = mst.top();
    mst.pop();
    if (Find(t2.second.first) != Find(t2.second.second)) {
      Father[Find(t2.second.first)] = Find(t2.second.second);
      use[t2.second.first].push_back(make_pair(t2.second.second, t2.first));
      use[t2.second.second].push_back(make_pair(t2.second.first, t2.first));
    }
  }
  F(1, 0);
  while (Q--) {
    scanf("%lld %lld", &a, &b);
    printf("%lld\n", LCA(a, b));
  }
  return 0;
}
