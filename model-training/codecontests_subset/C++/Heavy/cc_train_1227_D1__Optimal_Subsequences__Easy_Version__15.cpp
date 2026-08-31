#include <bits/stdc++.h>
using namespace std;
template <typename T, typename U>
inline void amin(T &a, U b) {
  a = (a > b ? b : a);
}
template <typename T, typename U>
inline void amax(T &a, U b) {
  a = (a > b ? a : b);
}
const int N = (1 << 21) + 5;
int fenw[N];
void update(int i, int val) {
  for (; i < N; i += i & (-i)) fenw[i] += val;
}
int sum(int r) {
  int tot = 0;
  for (; r > 0; r -= r & (-r)) tot += fenw[r];
  return tot;
}
int getSum(int l, int r) { return sum(r) - sum(l - 1); }
int kth(int k) {
  int idx = 0, sum = 0;
  for (int i = 21; i >= 0; --i) {
    if (fenw[idx + (1 << i)] + sum < k) {
      idx += (1 << i);
      sum += fenw[idx];
    }
  }
  return idx + 1;
}
void solve() {
  int n;
  cin >> n;
  vector<int> a(n);
  vector<pair<int, int>> b(n);
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    b[i] = {a[i], -i};
  }
  sort(b.begin(), b.end());
  int q;
  cin >> q;
  vector<array<int, 3>> queries(q);
  for (int i = 0; i < q; ++i) {
    cin >> queries[i][0] >> queries[i][1];
    queries[i][2] = i;
  }
  sort(queries.begin(), queries.end());
  int j = 0;
  vector<int> ans(q);
  for (auto &[len, k, i] : queries) {
    while (j < len) {
      update(-b.rbegin()[j].second + 1, 1);
      ++j;
    }
    ans[i] = a[kth(k) - 1];
  }
  for (int i : ans) {
    cout << i << "\n";
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int tests = 1;
  while (tests--) {
    solve();
  }
}
