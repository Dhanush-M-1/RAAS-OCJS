#include <bits/stdc++.h>
using namespace std;
const long long MAX = 200100;
pair<long long, long long> tree[256 * 1024 * 2];
long long lazy[256 * 1024 * 2];
void updateRangeUtil(long long si, long long ss, long long se, long long us,
                     long long ue, long long diff) {
  if (lazy[si] != 0) {
    tree[si].first += lazy[si];
    if (ss != se) {
      lazy[si * 2 + 1] += lazy[si];
      lazy[si * 2 + 2] += lazy[si];
    }
    lazy[si] = 0;
  }
  if (ss > se || ss > ue || se < us) return;
  if (ss >= us && se <= ue) {
    tree[si].first += diff;
    if (ss != se) {
      lazy[si * 2 + 1] += diff;
      lazy[si * 2 + 2] += diff;
    }
    return;
  }
  long long mid = (ss + se) / 2;
  updateRangeUtil(si * 2 + 1, ss, mid, us, ue, diff);
  updateRangeUtil(si * 2 + 2, mid + 1, se, us, ue, diff);
  tree[si] = min(tree[si * 2 + 1], tree[si * 2 + 2]);
}
void updateRange(long long n, long long us, long long ue, long long diff) {
  updateRangeUtil(0, 0, n - 1, us, ue, diff);
}
void updateRangeUtil2(long long si, long long ss, long long se, long long us,
                      long long ue, long long diff) {
  if (ss > se || ss > ue || se < us) return;
  if (ss >= us && se <= ue) {
    tree[si].second += diff;
    return;
  }
  long long mid = (ss + se) / 2;
  updateRangeUtil2(si * 2 + 1, ss, mid, us, ue, diff);
  updateRangeUtil2(si * 2 + 2, mid + 1, se, us, ue, diff);
  tree[si] = min(tree[si * 2 + 1], tree[si * 2 + 2]);
}
void updateRange2(long long n, long long us, long long ue, long long diff) {
  updateRangeUtil2(0, 0, n - 1, us, ue, diff);
}
int main() {
  long long arr[MAX];
  long long n;
  cin >> n;
  for (long long i = 0; i < n; ++i) {
    cin >> arr[i];
  }
  reverse(arr, arr + n);
  for (long long i = 0; i < n; ++i) {
    updateRange2(n, i, i, i);
  }
  for (long long i = 0; i < n; ++i) {
    updateRange(n, i, i, arr[i]);
  }
  long long res[MAX];
  for (long long iter = 1; iter <= n; ++iter) {
    long long smallest = tree[0].second;
    updateRange(n, 0, smallest, -iter);
    updateRange(n, smallest, smallest, 1LL << 62);
    res[smallest] = iter;
  }
  reverse(res, res + n);
  for (long long i = 0; i < n; ++i) {
    if (i) cout << ' ';
    cout << res[i];
  }
  cout << endl;
}
