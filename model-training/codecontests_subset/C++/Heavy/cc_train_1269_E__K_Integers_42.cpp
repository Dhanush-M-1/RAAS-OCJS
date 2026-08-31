#include <bits/stdc++.h>
using namespace std;
const int MAX_N = 2e5 + 10;
int bit[MAX_N], n, pos[MAX_N], x;
long long ans = 0;
int lowbit(int x) { return x & (-x); }
int sum(int x) {
  int res = 0;
  while (x < MAX_N) {
    res += bit[x];
    x += lowbit(x);
  }
  return res;
}
void update(int x) {
  while (x) {
    bit[x] += 1;
    x -= lowbit(x);
  }
}
int get(int d) {
  int l = 1, r = n;
  while (l <= r) {
    int mid = (l + r) >> 1;
    if (sum(mid) >= d) {
      l = mid + 1;
    } else {
      r = mid - 1;
    }
  }
  return r;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> x;
    pos[x] = i;
  }
  for (int i = 1; i <= n; i++) {
    int mid = (i + 1) / 2;
    if (i & 1) {
      update(pos[i]);
      int k = get(mid);
      int dis = abs(pos[i] - k) - abs(sum(pos[i]) - sum(k));
      if (pos[i] < k) {
        ans += -(sum(1) - sum(pos[i]));
      } else {
        ans += -sum(pos[i] + 1);
      }
      ans += dis + sum(pos[i] + 1);
    } else {
      int k = get(mid);
      int dis =
          abs(pos[i] - k) - abs(sum(pos[i]) + (pos[i] < k ? 1 : 0) - sum(k));
      if (pos[i] < k) {
        ans += -(sum(1) - sum(pos[i]));
      } else {
        ans += -sum(pos[i] + 1);
      }
      ans += dis + sum(pos[i] + 1);
      update(pos[i]);
    }
    printf("%I64d ", ans);
  }
  return 0;
}
