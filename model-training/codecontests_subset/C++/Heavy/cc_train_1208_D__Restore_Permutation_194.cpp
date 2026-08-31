#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
long long arr[N];
int n;
int lowbit(int x) { return x & -x; }
void addv(int p, long long val) {
  while (p <= n) {
    arr[p] += val;
    p += lowbit(p);
  }
}
void add(int l, int r, long long val) {
  addv(l, val);
  addv(r + 1, -val);
}
long long get(int p) {
  long long res = 0;
  while (p) {
    res += arr[p];
    p -= lowbit(p);
  }
  return res;
}
long long search(long long val) {
  int l = 1, r = n;
  while (l <= r) {
    int mid = (l + r) / 2;
    if (get(mid) <= val)
      l = mid + 1;
    else
      r = mid - 1;
  }
  return r;
}
long long sum[N];
long long ans[N];
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> sum[i];
    add(i + 1, n, i);
  }
  for (int i = n; i >= 1; i--) {
    ans[i] = search(sum[i]);
    add(ans[i] + 1, n, -ans[i]);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
}
