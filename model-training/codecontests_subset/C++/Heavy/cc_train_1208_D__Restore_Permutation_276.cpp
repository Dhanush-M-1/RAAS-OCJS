#include <bits/stdc++.h>
using namespace std;
long long a[3000000], tree[4 * 3000000], ans[4 * 3000000];
int n;
void update(int indx, int left, int right, int pos, long long val) {
  if (left > pos || right < pos) return;
  if (left == right) {
    tree[indx] += val;
    return;
  }
  int mid = (left + right) >> 1;
  update(indx * 2, left, mid, pos, val);
  update(indx * 2 + 1, mid + 1, right, pos, val);
  tree[indx] = tree[indx * 2] + tree[indx * 2 + 1];
}
long long query(int indx, int l, int r, int left, int right) {
  if (left > right || l > right || r < left) return 0;
  if (l >= left && r <= right) return tree[indx];
  int mid = (l + r) >> 1;
  long long x = query(indx * 2, l, mid, left, right);
  long long y = query(indx * 2 + 1, mid + 1, r, left, right);
  return x + y;
}
int doit(long long val) {
  int low = 1, high = n, ans = 1;
  while (low <= high) {
    int mid = (low + high) >> 1;
    long long xx = query(1, 1, n, 1, mid - 1);
    if (xx <= val) {
      low = mid + 1;
      ans = mid;
    } else
      high = mid - 1;
  }
  return ans;
}
int main(void) {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout.setf(ios::fixed);
  cout.precision(20);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) update(1, 1, n, i, i);
  for (int i = n; i > 0; i--) {
    ans[i] = doit(a[i]);
    update(1, 1, n, ans[i], -1ll * ans[i]);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  return 0;
}
