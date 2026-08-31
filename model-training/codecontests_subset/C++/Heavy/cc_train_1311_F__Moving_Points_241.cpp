#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5 + 9;
int n, a[MAX], speed[MAX], b[MAX];
int idx[MAX];
vector<pair<int, int> > v;
unordered_map<int, int> startRange;
long long tree[(MAX << 2)][2], val;
int l, r, idxToUpd;
void build(int id, int low, int high, int pos) {
  if (low == high) {
    tree[pos][id] = b[low];
    return;
  }
  int mid = ((low + high) >> 1);
  build(id, low, mid, (pos << 1));
  build(id, mid + 1, high, (pos << 1 | 1));
  tree[pos][id] = tree[(pos << 1)][id] + tree[(pos << 1 | 1)][id];
}
long long qwr(int id, int low, int high, int pos) {
  if (l > high || r < low) {
    return 0;
  }
  if (l <= low && r >= high) {
    return tree[pos][id];
  }
  int mid = ((low + high) >> 1);
  return qwr(id, low, mid, (pos << 1)) + qwr(id, mid + 1, high, (pos << 1 | 1));
}
void upd(int id, int low, int high, int pos) {
  if (low == high) {
    tree[pos][id] = val;
    return;
  }
  int mid = ((low + high) >> 1);
  if (idxToUpd <= mid) {
    upd(id, low, mid, (pos << 1));
  } else {
    upd(id, mid + 1, high, (pos << 1 | 1));
  }
  tree[pos][id] = tree[(pos << 1)][id] + tree[(pos << 1 | 1)][id];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
  }
  for (int i = 1; i <= n; ++i) {
    cin >> speed[i];
    v.push_back({speed[i], i});
  }
  sort(v.begin(), v.end());
  for (int i = 0; i < n; ++i) {
    idx[v[i].second] = i + 1;
    if (startRange.find(v[i].first) == startRange.end()) {
      startRange[v[i].first] = i + 1;
    }
  }
  for (int i = 1; i <= n; ++i) {
    b[idx[i]] = a[i];
  }
  build(0, 1, n, 1);
  v.clear();
  for (int i = 1; i <= n; ++i) {
    v.push_back({a[i], i});
  }
  sort(v.begin(), v.end());
  long long ans = 0;
  for (int i = 0; i < n; ++i) {
    l = startRange[speed[v[i].second]];
    r = n;
    int cntRemoved = qwr(1, 1, n, 1);
    long long sum = qwr(0, 1, n, 1);
    long long rest = (n - startRange[speed[v[i].second]] + 1) - cntRemoved;
    ans += sum - rest * (long long)v[i].first;
    idxToUpd = idx[v[i].second];
    val = 1;
    upd(1, 1, n, 1);
    val = 0;
    upd(0, 1, n, 1);
  }
  cout << ans;
  return 0;
}
