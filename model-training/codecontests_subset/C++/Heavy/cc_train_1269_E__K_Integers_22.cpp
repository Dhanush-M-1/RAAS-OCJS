#include <bits/stdc++.h>
using namespace std;
int p[200005];
long long ret[200005];
long long inv[200005], sum[200005];
void update(long long *pen, int ind, int val) {
  while (ind < 200005) {
    pen[ind] += val;
    ind += ind & (-ind);
  }
}
long long query(long long *pen, int ind) {
  long long ret = 0;
  while (ind > 0) {
    ret += pen[ind];
    ind = ind & (ind - 1);
  }
  return ret;
}
int getIndex(int target, int n) {
  int l = 0, r = n - 1, mid;
  while (l < r) {
    mid = (l + r + 1) / 2;
    if (query(inv, mid) < target) {
      l = mid;
    } else {
      r = mid - 1;
    }
  }
  return l + 1;
}
long long getSum(int n) {
  long long ret = (long long)n * (n + 1);
  return ret / 2;
}
void solve() {
  int n;
  scanf("%d ", &n);
  pair<int, int> in[200005];
  int pos = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d ", &p[i]);
    in[pos++] = make_pair(p[i], i);
  }
  sort(in, in + n);
  int maxi = 0;
  long long invSum = 0;
  for (int i = 0; i < n; ++i) {
    invSum = invSum + i - query(inv, in[i].second);
    update(inv, in[i].second, 1);
    update(sum, in[i].second, in[i].second);
    int k = i + 1;
    maxi = max(maxi, in[i].second);
    int mInd = getIndex(k / 2, n);
    long long R = 1e18;
    if (k == 1) {
      continue;
    }
    for (int j = 0; j < 2; ++j) {
      int mid = getIndex(k / 2 + j, n);
      long long prefix = getSum(mid) - getSum(mid - k / 2 - j);
      long long suffix = getSum(mid + k - (k / 2 + j)) - getSum(mid);
      long long tmp = prefix - query(sum, mid) * 2 - suffix + query(sum, n);
      R = min(R, tmp);
    }
    ret[i + 1] = invSum + R;
  }
  for (int i = 1; i <= n; ++i) {
    printf("%lld ", ret[i]);
  }
  putchar('\n');
}
int main() {
  solve();
  return 0;
}
