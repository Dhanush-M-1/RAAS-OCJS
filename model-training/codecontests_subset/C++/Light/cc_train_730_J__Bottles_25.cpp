#include <bits/stdc++.h>
using namespace std;
const int N = 200010;
inline int in() {
  int x;
  scanf("%d", &x);
  return x;
}
inline long long lin() {
  long long x;
  scanf("%I64d", &x);
  return x;
}
struct Info {
  int a, b;
} inp[205];
int tot;
int n;
pair<int, int> dp[105][10005];
pair<int, int> go(int now, int rem) {
  if (rem <= 0) return make_pair(0, 0);
  if (now > n) return make_pair(100000, 100000);
  if (dp[now][rem] != make_pair(-1, -1)) return dp[now][rem];
  pair<int, int> a;
  a = go(now + 1, rem - inp[now].b);
  pair<int, int> p, q;
  p.first = 1 + a.first;
  if (rem - inp[now].b >= 0)
    p.second = (inp[now].b - inp[now].a) + a.second;
  else
    p.second = (rem - inp[now].a) + a.second;
  q = go(now + 1, rem);
  if (q.first < p.first)
    p = q;
  else if (q.first == p.first) {
    if (q.second < p.second) p = q;
  }
  return dp[now][rem] = p;
}
int main() {
  n = in();
  for (int i = 1; i <= n; i++) {
    inp[i].a = in();
    tot += inp[i].a;
  }
  for (int i = 1; i <= n; i++) {
    inp[i].b = in();
  }
  memset(dp, -1, sizeof dp);
  pair<int, int> ans = go(1, tot);
  printf("%d %d\n", ans.first, ans.second);
}
