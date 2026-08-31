#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
pair<int, int> p[N];
struct fenwick {
  long long fen[N];
  void add(int first, int d) {
    for (int i = first + 1; i < N; i += i & -i) {
      fen[i] += d;
    }
  }
  long long sum(int first) {
    long long ans = 0;
    for (int i = first + 1; i; i -= i & -i) {
      ans += fen[i];
    }
    return ans;
  }
  long long sum(int l, int r) { return sum(r) - sum(l - 1); }
} val, cnt;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> p[i].first;
  for (int i = 0; i < n; ++i) cin >> p[i].second;
  sort(p, p + n);
  vector<int> a(n);
  for (int i = 0; i < n; ++i) a[i] = p[i].second;
  sort(a.begin(), a.end());
  a.resize(unique(a.begin(), a.end()) - a.begin());
  for (int i = 0; i < n; ++i) {
    p[i].second = lower_bound(a.begin(), a.end(), p[i].second) - a.begin();
  }
  long long ans = 0;
  for (int i = n - 1; ~i; --i) {
    val.add(p[i].second, p[i].first);
    cnt.add(p[i].second, 1);
    ans += val.sum(p[i].second, 2e5) - cnt.sum(p[i].second, 2e5) * p[i].first;
  }
  cout << ans << '\n';
  return 0;
}
