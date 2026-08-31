#include <bits/stdc++.h>
using namespace std;
long long n, ar[200005], br[200005], up[800555], dr[100];
pair<long long, long long> tr[800555];
void build(long long, long long, long long),
    update(long long, long long, long long, long long),
    upd(long long, long long, long long, long long, long long, long long);
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> ar[i];
  build(0, 0, n - 1);
  long long pos;
  for (int i = 1; i < n + 1; i++) {
    pos = tr[0].second;
    br[pos] = i;
    if (pos + 1 < n) upd(0, 0, n - 1, pos + 1, n - 1, i);
    update(0, 0, n - 1, pos);
  }
  for (int i = 0; i < n; i++) cout << br[i] << " ";
}
void build(long long idx, long long l, long long r) {
  if (l == r) {
    tr[idx].first = ar[l];
    tr[idx].second = l;
    return;
  }
  long long mid = (l + r) / 2;
  build(2 * idx + 1, l, mid);
  build(2 * idx + 2, mid + 1, r);
  if (tr[2 * idx + 1].first < tr[2 * idx + 2].first)
    tr[idx] = tr[2 * idx + 1];
  else
    tr[idx] = tr[2 * idx + 2];
}
void update(long long idx, long long l, long long r, long long pos) {
  if (up[idx]) {
    tr[idx].first -= up[idx];
    if (l != r) {
      up[2 * idx + 1] += up[idx];
      up[2 * idx + 2] += up[idx];
    }
    up[idx] = 0;
  }
  if (pos < l || pos > r) return;
  if (l == r) {
    tr[idx].first = 12345678123456ll;
    return;
  }
  long long mid = (l + r) / 2;
  update(2 * idx + 1, l, mid, pos);
  update(2 * idx + 2, mid + 1, r, pos);
  if (tr[2 * idx + 1].first < tr[2 * idx + 2].first)
    tr[idx] = tr[2 * idx + 1];
  else
    tr[idx] = tr[2 * idx + 2];
}
void upd(long long idx, long long l, long long r, long long low, long long high,
         long long val) {
  if (up[idx]) {
    tr[idx].first -= up[idx];
    if (l != r) {
      up[2 * idx + 1] += up[idx];
      up[2 * idx + 2] += up[idx];
    }
    up[idx] = 0;
  }
  if (high < l || low > r) {
    return;
  }
  if (low <= l && r <= high) {
    tr[idx].first -= val;
    if (l != r) {
      up[2 * idx + 1] += val;
      up[2 * idx + 2] += val;
    }
    return;
  }
  long long mid = (l + r) / 2;
  upd(2 * idx + 1, l, mid, low, high, val);
  upd(2 * idx + 2, mid + 1, r, low, high, val);
  if (tr[2 * idx + 1].first < tr[2 * idx + 2].first)
    tr[idx] = tr[2 * idx + 1];
  else
    tr[idx] = tr[2 * idx + 2];
}
