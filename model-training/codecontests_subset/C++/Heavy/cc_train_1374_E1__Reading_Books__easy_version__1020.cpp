#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
using ld = long double;
template <typename T1, typename T2>
inline void chkmin(T1 &x, const T2 &y) {
  if (x > y) x = y;
}
template <typename T1, typename T2>
inline void chkmax(T1 &x, const T2 &y) {
  if (x < y) x = y;
}
int n, m, k;
vector<pair<int, int>> a[4];
void read() {
  cin >> n >> m >> k;
  for (int i = 0; i < n; i++) {
    int t, f1, f2;
    cin >> t >> f1 >> f2;
    a[f1 * 2 + f2].push_back({t, i});
  }
  for (int i = 0; i <= 3; i++) sort(a[i].begin(), a[i].end());
}
set<pair<int, int>> L, R;
int sumSet;
void relax(int sz) {
  sz = max(sz, 0);
  while (L.size() > sz) {
    auto x = *(--L.end());
    L.erase(--L.end());
    sumSet -= x.first;
    R.insert(x);
  }
  while (L.size() < sz) {
    if (R.empty()) break;
    auto x = *(R.begin());
    R.erase(R.begin());
    L.insert(x);
    sumSet += x.first;
  }
}
void add(pair<int, int> a) {
  if (R.empty()) {
    L.insert(a);
    sumSet += a.first;
  } else if (L.empty()) {
    R.insert(a);
  } else if (*(R.begin()) < a) {
    R.insert(a);
  } else {
    L.insert(a);
    sumSet += a.first;
  }
}
int ans;
vector<int> fans;
void getAns() {
  ans = 2e9 + 228 + 1337;
  for (int it = 0; it < 2; it++) {
    L.clear();
    R.clear();
    sumSet = 0;
    int sum = 0;
    for (auto i : a[0]) add(i);
    int top1 = a[1].size() - 1;
    int top2 = a[2].size() - 1;
    for (auto i : a[1]) sum += i.first;
    for (auto i : a[2]) sum += i.first;
    for (int i = 0; i <= min(m, (int)a[3].size()); i++) {
      while (top1 >= 0 && top1 + 1 + i > k) {
        sum -= a[1][top1].first;
        add(a[1][top1]);
        top1--;
      }
      while (top2 >= 0 && top2 + 1 + i > k) {
        sum -= a[2][top2].first;
        add(a[2][top2]);
        top2--;
      }
      if (min(top1, top2) + 1 + i >= k) {
        int sz = m - i - (top1 + 1) - (top2 + 1);
        if (L.size() + R.size() >= sz) {
          relax(sz);
          if ((top1 + 1) + (top2 + 1) + i + (int)L.size() == m) {
            ans = min(ans, sum + sumSet);
            if (it == 1 && sum + sumSet == ans) {
              for (auto j : L) {
                fans.push_back(j.second);
              }
              for (int j = 0; j <= top1; j++) {
                fans.push_back(a[1][j].second);
              }
              for (int j = 0; j <= top2; j++) {
                fans.push_back(a[2][j].second);
              }
              for (int j = 0; j < i; j++) {
                fans.push_back(a[3][j].second);
              }
              return;
            }
          }
        }
      }
      if (i == a[3].size()) break;
      sum += a[3][i].first;
    }
  }
  cout << -1 << endl;
  exit(0);
}
void run() { getAns(); }
void write() {
  cout << ans << endl;
  sort(fans.begin(), fans.end());
  for (auto i : fans) {
    cout << i + 1 << " ";
  }
  cout << endl;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  read();
  run();
  write();
  return 0;
}
