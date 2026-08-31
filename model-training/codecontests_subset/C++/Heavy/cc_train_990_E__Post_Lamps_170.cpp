#include <bits/stdc++.h>
using namespace std;
int64_t rd() {
  char ch = getchar();
  int64_t x = 0;
  int op = 1;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') op = -1;
  for (; isdigit(ch); ch = getchar()) x = (x << 1) + (x << 3) + ch - '0';
  return x * op;
}
void _wr(int64_t a) {
  if (a >= 10) _wr(a / 10);
  putchar(a % 10 + '0');
}
void wr(int64_t a, char end = ' ') {
  if (a < 0) putchar('-'), a = -a;
  _wr(a);
  putchar(end);
}
int64_t divup(int64_t x, int64_t y) { return (x - 1) / y + 1; }
int main() {
  int n = rd(), m = rd(), k = rd();
  vector<int> s(n);
  vector<int> a(k);
  for (int i = 0; i < m; ++i) s[rd()] = 1;
  for (int i = 0; i < k; ++i) a[i] = rd();
  int blocked = k - 1;
  int max_block = 0;
  int prev = -1;
  for (int i = 0; i < n; ++i) {
    if (s[i]) {
      blocked++;
      s[i] = prev;
    } else {
      blocked = 0;
      s[i] = prev = i;
    }
    if (blocked == k) break;
    if (blocked > max_block) max_block = blocked;
  }
  if (blocked == k) {
    puts("-1");
    return 0;
  }
  vector<pair<int64_t, int>> min_pos_cost(k - max_block);
  for (int i = 0; i < min_pos_cost.size(); ++i) {
    int j = i + max_block;
    min_pos_cost[i] = {divup(n, j + 1) * a[j], j + 1};
  }
  sort(min_pos_cost.begin(), min_pos_cost.end());
  int64_t min = 1000 * 1000 * 1000 * 2000ll;
  for (auto &c : min_pos_cost) {
    if (c.first > min) break;
    int d = c.second;
    int p = 0;
    int64_t cnt = 0;
    while (p < n) {
      cnt++;
      p = s[p] + d;
    }
    if (cnt * a[d - 1] < min) min = cnt * a[d - 1];
  }
  wr(min, '\n');
}
