#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
struct node {
  long long val = 0, num = 0;
};
vector<node> s(1 << 15);
long long dim = 1 << 14;
void add(long long pos, long long l, long long r, long long p) {
  if (l > p || r < p) return;
  if (l == p && p == r) {
    s[pos].num++;
    s[pos].val += p;
    return;
  }
  add(2 * pos, l, (l + r) / 2, p);
  add(2 * pos + 1, (l + r) / 2 + 1, r, p);
  s[pos].num++;
  s[pos].val += p;
}
void cut(long long pos, long long l, long long r, long long p) {
  if (l > p || r < p) return;
  if (l == r && p == l) {
    s[pos].num--;
    s[pos].val -= p;
    return;
  }
  cut(2 * pos, l, (l + r) / 2, p);
  cut(2 * pos + 1, (l + r) / 2 + 1, r, p);
  s[pos].num--;
  s[pos].val -= p;
}
long long query(long long pos, long long l, long long r, long long k) {
  if (k == 0) return 0;
  if (s[pos].num == k) return s[pos].val;
  if (l == r) return s[pos].val / s[pos].num * k;
  if (s[2 * pos].num >= k) return query(2 * pos, l, (l + r) / 2, k);
  return s[2 * pos].val +
         query(2 * pos + 1, (l + r) / 2 + 1, r, k - s[2 * pos].num);
}
vector<pair<long long, long long> > v[4];
long long N, K, M;
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> N >> M >> K;
  for (long long i = 0; i < N; i++) {
    long long a, b, c;
    cin >> a >> b >> c;
    if (b & c)
      v[3].push_back({a, i});
    else if (b)
      v[1].push_back({a, i});
    else if (c)
      v[2].push_back({a, i});
    else
      v[0].push_back({a, i});
  }
  for (long long i = 0; i < v[0].size(); i++) add(1, 0, dim - 1, v[0][i].first);
  long long mi = 1e12, best;
  long long cur = 0;
  sort(v[1].begin(), v[1].end());
  sort(v[2].begin(), v[2].end());
  sort(v[3].begin(), v[3].end());
  long long presi = 0;
  for (long long i = 0; i < min(K, (long long)v[3].size()); i++) {
    cur += v[3][i].first;
    presi++;
  }
  for (long long i = K; i < v[3].size(); i++) add(1, 0, dim - 1, v[3][i].first);
  long long pos = 0;
  if (v[3].size() < K) {
    long long i = v[3].size();
    while (v[1].size() > pos && v[2].size() > pos && i + pos < K) {
      cur += v[1][pos].first + v[2][pos].first;
      pos++;
      presi += 2;
    }
    if (pos + i < K) {
      cout << -1;
      return 0;
    }
  }
  for (long long i = pos; i < v[1].size(); i++)
    add(1, 0, dim - 1, v[1][i].first);
  for (long long i = pos; i < v[2].size(); i++)
    add(1, 0, dim - 1, v[2][i].first);
  if (presi > M) {
    cout << -1;
    return 0;
  }
  long long agg = query(1, 0, dim - 1, M - presi);
  if (cur + agg < mi) {
    mi = cur + agg;
    best = K - pos;
  }
  for (long long i = min(K, (long long)v[3].size()) - 1; i >= 0; i--) {
    cur -= v[3][i].first;
    presi--;
    add(1, 0, dim - 1, v[3][i].first);
    while (v[1].size() > pos && v[2].size() > pos && i + pos < K) {
      cur += v[1][pos].first + v[2][pos].first;
      cut(1, 0, dim - 1, v[1][pos].first);
      cut(1, 0, dim - 1, v[2][pos].first);
      pos++;
      presi += 2;
    }
    if (pos + i < K || presi > M) break;
    agg = query(1, 0, dim - 1, M - presi);
    if (cur + agg < mi) {
      mi = cur + agg;
      best = i;
    }
  }
  if (mi == 1e12) {
    cout << -1;
    return 0;
  }
  cout << mi << '\n';
  vector<pair<long long, long long> > q;
  for (long long i = 0; i < best; i++) cout << v[3][i].second + 1 << " ";
  for (long long i = 0; i < K - best; i++) cout << v[2][i].second + 1 << " ";
  for (long long i = 0; i < K - best; i++) cout << v[1][i].second + 1 << " ";
  for (long long i = 0; i < v[0].size(); i++) q.push_back(v[0][i]);
  for (long long i = best; i < v[3].size(); i++) q.push_back(v[3][i]);
  for (long long i = K - best; i < v[1].size(); i++) q.push_back(v[1][i]);
  for (long long i = K - best; i < v[2].size(); i++) q.push_back(v[2][i]);
  sort(q.begin(), q.end());
  for (long long i = 0; i < M - best - 2 * (K - best); i++) {
    cout << q[i].second + 1 << " ";
  }
}
