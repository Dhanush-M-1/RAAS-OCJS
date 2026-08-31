#include <bits/stdc++.h>
using namespace std;
const long long maxn = 200005;
map<long long, long long> g;
map<long long, long long> invG;
long long tree[8][maxn];
long long sum(long long k, long long t) {
  long long res = 0;
  for (long long i = k; i >= 1; i -= i & -i) res += tree[t][i];
  return res;
}
void add(long long k, long long v, long long t) {
  for (long long i = k; i < maxn; i += i & -i) tree[t][i] += v;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  for (long long i = 0; i < maxn; i++)
    for (long long j = 0; j < 8; j++) tree[j][i] = 0;
  long long n;
  cin >> n;
  priority_queue<pair<long long, pair<long long, long long>>> pq;
  vector<long long> xs;
  vector<long long> vs;
  set<long long> distinct;
  for (long long i = 0; i < n; i++) {
    long long x;
    cin >> x;
    xs.push_back(x);
    distinct.emplace(x);
  }
  for (long long i = 0; i < n; i++) {
    long long v;
    cin >> v;
    vs.push_back(v);
  }
  vector<long long> vec(distinct.begin(), distinct.end());
  for (long long i = 0; i < n; i++) {
    g[vec[i]] = i + 1;
    invG[i + 1] = vec[i];
  }
  for (long long i = 0; i < n; i++) {
    long long dir = 0;
    if (vs[i] < 0) dir = 1;
    pq.emplace(abs(vs[i]), make_pair(g[xs[i]], dir));
  }
  long long res = 0;
  while (!pq.empty()) {
    pair<long long, pair<long long, long long>> t = pq.top();
    queue<pair<long long, long long>> q;
    queue<pair<long long, long long>> q2;
    while (!pq.empty() && pq.top().first == t.first) {
      pair<long long, pair<long long, long long>> p = pq.top();
      pq.pop();
      q.emplace(p.second);
    }
    while (!q.empty()) {
      pair<long long, long long> p = q.front();
      q.pop();
      q2.emplace(p);
      long long x = p.first;
      long long dir = p.second;
      long long sumRight = sum(maxn - 1, 0) - sum(x, 0);
      sumRight -= invG[x] * (sum(maxn - 1, 0 + 2) - sum(x, 0 + 2));
      long long sumLeft = sum(x - 1, 1);
      sumLeft -= invG[x] * sum(x - 1, 1 + 2);
      res += abs(sumRight) + abs(sumLeft);
    }
    vector<pair<long long, long long>> same;
    while (!q2.empty()) {
      pair<long long, long long> p = q2.front();
      q2.pop();
      long long x = p.first;
      long long dir = p.second;
      add(x, invG[x], dir);
      add(x, 1, dir + 2);
      same.push_back(make_pair(x, dir));
      add(x, invG[x], dir + 4);
      add(x, 1, dir + 4 + 2);
    }
    long long cnt = 0;
    for (pair<long long, long long> p : same) {
      long long x = p.first;
      long long dir = p.second;
      if (dir == 0) {
        long long sumRight = sum(maxn - 1, 4) - sum(x, 4);
        sumRight -= invG[x] * (sum(maxn - 1, 4 + 2) - sum(x, 4 + 2));
        long long sumLeft = sum(x - 1, 5);
        sumLeft -= invG[x] * sum(x - 1, 5 + 2);
        long long extra = sum(x - 1, 4);
        extra -= invG[x] * sum(x - 1, 4 + 2);
        cnt += abs(sumRight) + abs(sumLeft) + abs(extra);
      } else {
        long long sumRight = sum(maxn - 1, 4) - sum(x, 4);
        sumRight -= invG[x] * (sum(maxn - 1, 4 + 2) - sum(x, 4 + 2));
        long long sumLeft = sum(x - 1, 5);
        sumLeft -= invG[x] * sum(x - 1, 5 + 2);
        long long extra = sum(maxn - 1, 5) - sum(x, 5);
        extra -= invG[x] * (sum(maxn - 1, 5 + 2) - sum(x, 5 + 2));
        cnt += abs(sumRight) + abs(sumLeft) + abs(extra);
      }
    }
    cnt /= 2;
    res += cnt;
    for (pair<long long, long long> p : same) {
      long long x = p.first;
      long long dir = p.second;
      add(x, -invG[x], dir + 4);
      add(x, -1, dir + 4 + 2);
    }
  }
  cout << res << '\n';
}
