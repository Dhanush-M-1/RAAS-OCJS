#include <bits/stdc++.h>
using namespace std;
int __i__, __j__;
class _Debug {
 public:
  template <typename T>
  _Debug& operator,(T val) {
    cout << val << endl;
    return *this;
  }
};
int n, k;
int a[100000], p[100000];
int last[100000];
int dp[100001];
int num[100001];
int sum[350][100100], shift[350];
int sumall = 0;
int prop(int b) {
  if (shift[b] == 0) return 0;
  int i;
  for (i = b * 300; i < min((b + 1) * 300, n); i++) {
    sum[b][num[i]] += 998244353 - dp[i];
    if (sum[b][num[i]] >= 998244353) sum[b][num[i]] -= 998244353;
    num[i] += shift[b];
    sum[b][num[i]] += dp[i];
    if (sum[b][num[i]] >= 998244353) sum[b][num[i]] -= 998244353;
  }
  shift[b] = 0;
  return 0;
}
int add(int i, int d) {
  int b = i / 300;
  sum[b][num[i]] += 998244353 - dp[i];
  if (sum[b][num[i]] >= 998244353) sum[b][num[i]] -= 998244353;
  if (num[i] <= k) sumall += 998244353 - dp[i];
  if (sumall >= 998244353) sumall -= 998244353;
  num[i] += d;
  sum[b][num[i]] += dp[i];
  if (sum[b][num[i]] >= 998244353) sum[b][num[i]] -= 998244353;
  if (num[i] <= k) sumall += dp[i];
  if (sumall >= 998244353) sumall -= 998244353;
  return 0;
}
int update(int s, int e, int d) {
  int i;
  if (s / 300 == e / 300) {
    int b = s / 300;
    prop(b);
    for (i = s; i <= e; i++) add(i, d);
  } else {
    int b = s / 300;
    prop(b);
    for (i = s; i < (b + 1) * 300; i++) add(i, d);
    for (i = b + 1; i < e / 300; i++) {
      if ((d == 1) && (k >= shift[i]))
        sumall += 998244353 - sum[i][k - shift[i]];
      else if ((d == -1) && (k + 1 >= shift[i]))
        sumall += sum[i][k + 1 - shift[i]];
      if (sumall >= 998244353) sumall -= 998244353;
      shift[i] += d;
    }
    b = e / 300;
    prop(b);
    for (i = b * 300; i <= e; i++) add(i, d);
  }
  return 0;
}
int main() {
  int i;
  scanf("%d %d", &n, &k);
  for (i = 0; i < n; i++) scanf("%d", &a[i]), a[i]--;
  for (i = 0; i < n; i++) last[i] = -1;
  for (i = 0; i < n; i++) {
    p[i] = last[a[i]];
    last[a[i]] = i;
  }
  dp[0] = 1;
  sum[0][shift[0]] = 1, sumall = 1;
  for (i = 0; i < n; i++) {
    update(p[i] + 1, i, 1);
    if (p[i] != -1) update(p[p[i]] + 1, p[i], -1);
    int b = (i + 1) / 300;
    prop(b);
    dp[i + 1] = sumall;
    sum[b][num[i + 1]] += dp[i + 1];
    sumall += dp[i + 1];
    if (sum[b][num[i + 1]] >= 998244353) sum[b][num[i + 1]] -= 998244353;
    if (sumall >= 998244353) sumall -= 998244353;
  }
  printf("%d\n", dp[n]);
  return 0;
}
