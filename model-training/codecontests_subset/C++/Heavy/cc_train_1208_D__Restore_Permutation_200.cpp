#include <bits/stdc++.h>
using namespace std;
long long int bit[200005];
int n;
void update(int j, int x) {
  for (; j < 200005; j += j & (-j)) bit[j] += x;
}
long long int query(int j) {
  if (j == 0) return 0;
  long long int x = 0;
  for (; j > 0; j -= (j) & (-j)) x += bit[j];
  return x;
}
int next_ele(long long int s) {
  int l, r, m;
  long long int q;
  l = 0, r = n;
  while (l < r) {
    m = (l + r) / 2;
    if (query(m) > s)
      r = m;
    else
      l = m + 1;
  }
  return l;
}
int compute(long long int s) {
  int x;
  s *= 2;
  x = sqrt(s);
  return x + 1;
}
int main() {
  int i;
  scanf("%d", &n);
  vector<long long int> sum(n);
  for (i = 0; i < n; i++) cin >> sum[i];
  vector<int> ans(n);
  ans[n - 1] = compute(sum[n - 1]);
  for (i = 1; i < n + 1; i++) update(i, i);
  update(ans[n - 1], -ans[n - 1]);
  for (i = n - 2; i >= 0; i--) {
    ans[i] = next_ele(sum[i]);
    update(ans[i], -ans[i]);
  }
  for (i = 0; i < n; i++) printf("%d ", ans[i]);
  printf("\n");
}
