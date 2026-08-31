#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char* name, Arg1&& arg1) {
  cerr << name << " : " << arg1 << '\n';
}
template <typename Arg1, typename... Args>
void __f(const char* names, Arg1&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
template <class T>
void mxi(T& a, const T& b) {
  a = max(a, b);
}
template <class T>
void mni(T& a, const T& b) {
  a = min(a, b);
}
long double EPS = 1e-9;
mt19937 RNG(chrono::steady_clock::now().time_since_epoch().count());
struct node {
  long long sum, cnt;
  node() {
    sum = 0;
    cnt = 0;
  }
};
node t[4 * 200200];
node merge(node a, node b) {
  node tmp;
  tmp.sum = a.sum + b.sum;
  tmp.cnt = a.cnt + b.cnt;
  return tmp;
}
void upd(long long id, long long l, long long r, long long pos, long long val) {
  if (pos < l || pos > r)
    return;
  else if (l == r) {
    t[id].sum += val;
    t[id].cnt++;
    return;
  }
  upd(id << 1, l, ((l + r) >> 1), pos, val);
  upd(id << 1 | 1, ((l + r) >> 1) + 1, r, pos, val);
  t[id] = merge(t[id << 1], t[id << 1 | 1]);
}
node query(long long id, long long l, long long r, long long lq, long long rq) {
  if (lq > r || l > rq)
    return node();
  else if (lq <= l && rq >= r)
    return t[id];
  return merge(query(id << 1, l, ((l + r) >> 1), lq, rq),
               query(id << 1 | 1, ((l + r) >> 1) + 1, r, lq, rq));
}
void solve() {
  long long n;
  cin >> n;
  vector<pair<long long, long long> > v;
  for (long long i = 0; i < (n); i++) {
    long long x;
    cin >> x;
    v.push_back({x, 0});
  }
  set<long long> vel;
  for (long long j = 0; j < (n); j++) {
    long long w;
    cin >> w;
    vel.insert(w);
    v[j].second = w;
  }
  sort((v).begin(), (v).end());
  map<long long, long long> mp;
  long long cnt = 0;
  for (auto x : vel) {
    mp[x] = cnt++;
  }
  long long an = 0;
  for (long long i = n - 1; ~i; i--) {
    node ans = query(1, 0, 200010, mp[v[i].second], 200010);
    long long cc = ans.cnt;
    an += (ans.sum - cc * v[i].first);
    upd(1, 0, 200010, mp[v[i].second], v[i].first);
  }
  cout << an << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t, tab;
  t = 1;
  tab = t;
  while (t--) {
    solve();
  }
  cerr << ((double)clock() / CLOCKS_PER_SEC);
}
