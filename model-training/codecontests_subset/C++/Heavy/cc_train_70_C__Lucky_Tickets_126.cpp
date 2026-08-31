#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100000 + 5;
map<pair<int, int>, int> remx, remy;
int d[MAXN];
int rev[MAXN];
int gcd(int x, int y) {
  if (!y) return x;
  return gcd(y, x % y);
}
int get_rev(int x) {
  int res = 0, a;
  while (x) {
    a = x % 10;
    res = res * 10 + a;
    x /= 10;
  }
  return res;
}
void init(int ma) {
  remx.clear(), remy.clear();
  for (int i = 1; i <= ma; i++) rev[i] = get_rev(i);
  for (int i = 1; i <= ma; i++) {
    d[i] = gcd(i, rev[i]);
    remy[make_pair(i / d[i], rev[i] / d[i])]++;
  }
}
void solve(int max_x, int max_y, int W) {
  bool flag = false;
  if (max_x > max_y) {
    swap(max_x, max_y);
    flag = true;
  }
  init(max_y);
  int x = 1, y = max_y;
  int now = remy[make_pair(1, 1)];
  remx[make_pair(1, 1)]++;
  int ans_x = -1, ans_y = -1;
  while (x <= y) {
    while (x < y && x < max_x && now < W) {
      x++;
      remx[make_pair(rev[x] / d[x], x / d[x])]++;
      now += remy[make_pair(rev[x] / d[x], x / d[x])];
    }
    if (now < W) break;
    if (ans_x == -1 || (long long)x * y < (long long)ans_x * ans_y) {
      ans_x = x, ans_y = y;
    }
    remy[make_pair(y / d[y], rev[y] / d[y])]--;
    now -= remx[make_pair(y / d[y], rev[y] / d[y])];
    y--;
  }
  if (flag) swap(ans_x, ans_y);
  if (ans_x == -1)
    puts("-1");
  else
    printf("%d %d\n", ans_x, ans_y);
  return;
}
int main() {
  int max_x, max_y, W;
  while (~scanf("%d %d %d", &max_x, &max_y, &W)) {
    solve(max_x, max_y, W);
  }
  return 0;
}
