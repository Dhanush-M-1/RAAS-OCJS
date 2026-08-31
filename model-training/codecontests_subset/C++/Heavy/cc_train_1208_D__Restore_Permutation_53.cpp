#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int MAXN = 2e5 + 5;
const int inf = 0x3f3f3f3f;
long long s[MAXN];
struct node {
  int l, r;
  long long sum;
} node[MAXN << 2];
void build(int l, int r, int num) {
  node[num].l = l;
  node[num].r = r;
  if (l == r) {
    node[num].sum = l;
    return;
  }
  int mid = (l + r) >> 1;
  build(l, mid, num << 1);
  build(mid + 1, r, num << 1 | 1);
  node[num].sum = node[num << 1].sum + node[num << 1 | 1].sum;
}
void updata(int pos, int num) {
  if (node[num].l == node[num].r) {
    node[num].sum = 0;
    return;
  }
  int mid = (node[num].l + node[num].r) >> 1;
  if (pos <= mid)
    updata(pos, num << 1);
  else
    updata(pos, num << 1 | 1);
  node[num].sum = node[num << 1 | 1].sum + node[num << 1].sum;
}
int query(long long val, int num) {
  if (node[num].l == node[num].r) {
    return node[num].l;
  }
  long long sum1 = node[num << 1].sum;
  if (sum1 <= val)
    return query(val - sum1, num << 1 | 1);
  else
    return query(val, num << 1);
}
int dp[MAXN];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
  }
  build(1, n, 1);
  for (int i = n; i >= 1; i--) {
    int ans = query(s[i], 1);
    dp[i] = ans;
    updata(ans, 1);
  }
  for (int i = 1; i <= n; i++) {
    cout << dp[i] << " ";
  }
}
