#include <bits/stdc++.h>
const long long MAX = 2e5 + 5;
using namespace std;
long long fen[MAX], a[MAX];
bool cnt[MAX];
bool compare(const pair<long long, long long> &x,
             const pair<long long, long long> &y) {
  if (x.second == y.second) return x.first < y.first;
  return x.second > y.second;
}
void f_insert(long long loc) {
  if (loc > 2e5) return;
  fen[loc]++;
  f_insert(loc + (loc & -loc));
}
long long get_arc(long long num, bool bol = true) {
  if (bol) num--;
  if (num < 1) return 0;
  return fen[num] + get_arc(num - (num & -num), false);
}
long long ind(long long num, long long l = 1, long long r = 2e5) {
  long long mid = (l + r) / 2;
  long long s = get_arc(mid);
  if (s >= num) return ind(num, l, mid - 1);
  if (s + cnt[mid] < num) return ind(num, mid + 1, r);
  return mid;
}
int main() {
  long long n, q;
  cin >> n;
  pair<long long, long long> p[n];
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
    p[i] = {i + 1, a[i]};
  }
  sort(p, p + n, compare);
  cin >> q;
  map<pair<long long, long long>, long long> m;
  vector<pair<long long, long long>> v, s;
  for (long long i = 0; i < q; i++) {
    long long l, r;
    cin >> l >> r;
    s.push_back({l, r});
    v.push_back({l, r});
  }
  sort(s.begin(), s.end());
  long long loc = 0;
  for (long long i = 0; i < q; i++) {
    long long x = s[i].first, y = s[i].second;
    while (loc < x) {
      cnt[p[loc].first] = true;
      f_insert(p[loc].first);
      loc++;
    }
    long long j = ind(y);
    m[{x, y}] = a[j - 1];
  }
  for (auto i : v) cout << m[i] << endl;
  return 0;
}
