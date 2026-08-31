#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const int N = 2e5 + 5;
long long t[N], a[N], b[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  int cnta = 0, cntb = 0;
  set<pair<long long, long long> > ab, aa, bb;
  for (int i = 1; i <= n; ++i) {
    cin >> t[i] >> a[i] >> b[i];
    cnta += a[i], cntb += b[i];
    if (a[i] && b[i]) ab.insert({t[i], i});
    if (a[i] && !b[i]) aa.insert({t[i], i});
    if (!a[i] && b[i]) bb.insert({t[i], i});
  }
  if (cnta < k || cntb < k) cout << -1, exit(0);
  long long ans = 0;
  int taken = 0;
  vector<pair<long long, long long> > checkab, checka, checkb;
  while (k--) {
    if (!aa.size() || !bb.size())
      checkab.push_back(*ab.begin()), ans += (ab.begin()->first), taken++,
          ab.erase(ab.begin());
    else if (ab.size() &&
             (ab.begin()->first) < (aa.begin()->first) + (bb.begin()->first)) {
      checkab.push_back(*ab.begin()), ans += (ab.begin()->first), taken++,
          ab.erase(ab.begin());
    } else {
      checka.push_back(*aa.begin()), checkb.push_back(*bb.begin()),
          ans += (aa.begin()->first) + (bb.begin()->first), taken += 2,
          aa.erase(aa.begin()), bb.erase(bb.begin());
    }
  }
  if (taken <= m) {
    m -= taken;
    set<pair<long long, long long> > can;
    vector<bool> used(n + 5, 0);
    for (pair<long long, long long> cur : checkab) used[cur.second] = true;
    for (pair<long long, long long> cur : checka) used[cur.second] = true;
    for (pair<long long, long long> cur : checkb) used[cur.second] = true;
    for (int i = 1; i <= n; ++i) {
      if (!used[i]) can.insert({t[i], i});
    }
    int mn = min((int)aa.size(), (int)bb.size());
    vector<int> dop;
    while (m && can.size()) {
      bool ok = false;
      if (!aa.size() || !bb.size() || !checkab.size()) {
        pair<long long, long long> cur = *can.begin();
        ans += cur.first;
        dop.push_back(cur.second);
        can.erase(can.begin());
        ok = 1;
      } else if ((aa.begin()->first) + (bb.begin()->first) -
                     checkab.back().first <=
                 (can.begin()->first)) {
        ans -= checkab.back().first;
        can.insert(checkab.back());
        checkab.pop_back();
        ans += (aa.begin()->first) + (bb.begin()->first);
        can.erase(*aa.begin());
        can.erase(*bb.begin());
        checka.push_back(*aa.begin()), checkb.push_back(*bb.begin());
        aa.erase(aa.begin()), bb.erase(bb.begin());
        ok = 1;
      } else {
        pair<long long, long long> cur = *can.begin();
        ans += cur.first;
        dop.push_back(cur.second);
        if (aa.count(cur)) aa.erase(cur);
        if (bb.count(cur)) bb.erase(cur);
        can.erase(can.begin());
        ok = 1;
      }
      if (ok) {
        m--;
        continue;
      }
      break;
    }
    if (m) cout << -1, exit(0);
    cout << ans << "\n";
    for (pair<long long, long long> cur : checkab) cout << cur.second << " ";
    for (pair<long long, long long> cur : checka) cout << cur.second << " ";
    for (pair<long long, long long> cur : checkb) cout << cur.second << " ";
    for (int cur : dop) cout << cur << " ";
    exit(0);
  }
  m = taken - m;
  if (min((int)checka.size(), (int)ab.size() - (int)checkab.size()) < m)
    cout << -1, exit(0);
  while (m--) {
    ans -= (checka.back().first + checkb.back().first);
    ans += (ab.begin()->first);
    checka.pop_back(), checkb.pop_back(), checkab.push_back(*ab.begin()),
        ab.erase(ab.begin());
  }
  cout << ans << "\n";
  for (pair<long long, long long> cur : checkab) cout << cur.second << " ";
  for (pair<long long, long long> cur : checka) cout << cur.second << " ";
  for (pair<long long, long long> cur : checkb) cout << cur.second << " ";
}
