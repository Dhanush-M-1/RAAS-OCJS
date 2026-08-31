#include <bits/stdc++.h>
using namespace std;
vector<long long int> a;
long long int c, d;
vector<pair<long long int, long long int> > tree;
void update(long long int idx, long long int pos, long long int s,
            long long int e) {
  if (pos < s || pos > e) return;
  if (s == e) {
    tree[idx] = {min(a[s], c), min(a[s], d)};
    return;
  }
  long long int mid = s + ((e - s) >> 1);
  update(2 * idx, pos, s, mid);
  update(2 * idx + 1, pos, mid + 1, e);
  tree[idx] = {tree[2 * idx].first + tree[2 * idx + 1].first,
               tree[2 * idx].second + tree[2 * idx + 1].second};
  return;
}
long long query(long long int idx, long long int l, long long int r,
                long long int type, long long int s, long long int e) {
  if (r < s || l > e) return 0;
  if (s >= l && e <= r) {
    if (type == 1)
      return tree[idx].first;
    else
      return tree[idx].second;
  }
  long long int mid = s + ((e - s) >> 1);
  return (query(2 * idx, l, r, type, s, mid) +
          query(2 * idx + 1, l, r, type, mid + 1, e));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, k, i, l, r, q, t, ans;
  cin >> n >> k >> c >> d >> q;
  a.resize(n);
  tree.resize(4 * n + 2);
  while (q--) {
    cin >> t;
    if (t == 1) {
      cin >> i >> l;
      i--;
      a[i] += l;
      update(1, i, 0, n - 1);
    } else {
      cin >> i;
      i--;
      ans = query(1, 0, i - 1, 2, 0, n - 1);
      i += k;
      ans += query(1, i, n - 1, 1, 0, n - 1);
      cout << ans << "\n";
    }
  }
  return 0;
}
