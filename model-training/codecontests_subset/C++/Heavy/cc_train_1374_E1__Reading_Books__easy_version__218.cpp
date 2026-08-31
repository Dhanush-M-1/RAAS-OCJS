#include <bits/stdc++.h>
using namespace std;
const long long MAX = 3e5;
long long fen[MAX], cnt[MAX], sum[MAX];
deque<pair<long long, long long> > a, b, s, d, v;
multiset<pair<long long, long long> > sol;
void add(long long t, long long cur, long long val) {
  if (cur > 2e4) return;
  if (t == cur) cnt[t] += val;
  if (cur == 0) {
    cur++;
    add(t, cur, val);
    return;
  }
  sum[cur] += val * t;
  fen[cur] += val;
  add(t, cur + (cur & -cur), val);
}
long long psum(long long n) {
  if (n == 0) return 0;
  return sum[n] + psum(n - (n & -n));
}
long long pfen(long long n) {
  if (n == 0) return cnt[0];
  return fen[n] + pfen(n - (n & -n));
}
long long bin(long long cur, long long l = 0, long long r = 2e4) {
  if (r < l) return -1;
  long long mid = (l + r) / 2;
  if (mid == 0) {
    if (cnt[mid] >= cur) return 0;
    return -1;
  }
  long long x = psum(mid - 1), y = pfen(mid - 1);
  if (y >= cur) return bin(cur, l, mid - 1);
  if (y + cnt[mid] >= cur) return x + (cur - y) * mid;
  return bin(cur, mid + 1, r);
}
int main() {
  long long n, m, k;
  cin >> n >> m >> k;
  for (long long i = 0; i < n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    add(x, x, 1);
    if (y == 1 && z == 1)
      s.push_back({x, i});
    else if (y == 0 && z == 0)
      v.push_back({x, i});
    else if (y == 1)
      a.push_back({x, i});
    else if (z == 1)
      b.push_back({x, i});
  }
  long long t = min((long long)a.size(), min((long long)b.size(), k));
  sort(s.begin(), s.end());
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  while (s.size() > k) v.push_back(s.back()), s.pop_back();
  while (a.size() > t) v.push_back(a.back()), a.pop_back();
  while (b.size() > t) v.push_back(b.back()), b.pop_back();
  long long ad = 0;
  long long sum = 0, c = 0, bk = 0;
  for (auto i : s) add(i.first, i.first, -1), sum += i.first, bk++, c++, ad++;
  while (c < k && a.size()) {
    c++;
    bk += 2;
    sum += a[0].first;
    sum += b[0].first;
    d.push_back(a[0]);
    d.push_back(b[0]);
    add(a[0].first, a[0].first, -1);
    add(b[0].first, b[0].first, -1);
    a.pop_front();
    b.pop_front();
  }
  if (c != k) {
    cout << -1;
    return 0;
  }
  if (bin(m - bk) != -1) sol.insert({sum + bin(m - bk), ad});
  for (long long i = s.size() - 1; i > -1; i--) {
    ad--;
    sum -= s[i].first;
    add(s[i].first, s[i].first, 1);
    if (a.size()) {
      bk++;
      sum += a[0].first;
      sum += b[0].first;
      d.push_back(a[0]);
      d.push_back(b[0]);
      add(a[0].first, a[0].first, -1);
      add(b[0].first, b[0].first, -1);
      a.pop_front();
      b.pop_front();
      if (c != k || bk > m) continue;
      if (bin(m - bk) == -1) continue;
      sol.insert({sum + bin(m - bk), ad});
    }
  }
  while (sol.size() && (*sol.begin()).first == -1) sol.erase(sol.begin());
  if (!sol.size()) {
    cout << -1;
    return 0;
  }
  c = 0;
  vector<long long> pr;
  t = (*sol.begin()).second;
  if (s.size() < t) {
    cout << -1;
    return 0;
  }
  while (t--) {
    pr.push_back(s[0].second);
    s.pop_front();
  }
  t = k - pr.size();
  if (d.size() < 2 * t) {
    cout << -1;
    return 0;
  }
  while (t--) {
    pr.push_back(d[0].second);
    d.pop_front();
    pr.push_back(d[0].second);
    d.pop_front();
  }
  for (auto i : d) v.push_back(i);
  for (auto i : s) v.push_back(i);
  for (auto i : a) v.push_back(i);
  for (auto i : b) v.push_back(i);
  sort(v.begin(), v.end());
  t = m - pr.size();
  if (v.size() < t) {
    cout << -1;
    return 0;
  }
  while (t--) pr.push_back(v[0].second), v.pop_front();
  cout << (*sol.begin()).first << endl;
  for (auto i : pr) cout << i + 1 << " ";
  return 0;
}
