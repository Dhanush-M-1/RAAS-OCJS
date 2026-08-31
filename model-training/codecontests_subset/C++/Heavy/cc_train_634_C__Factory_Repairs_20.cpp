#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200000;
const int K = 500;
int n, a, b;
int sum[2][MAXN];
int sum_blocks[2][MAXN / K];
void add(int pos, int val) {
  int a1 = min(b - sum[0][pos], val);
  sum[0][pos] += a1;
  sum_blocks[0][pos / K] += a1;
  int a2 = min(a - sum[1][pos], val);
  sum[1][pos] += a2;
  sum_blocks[1][pos / K] += a2;
}
int get_sum(int left, int right, int type) {
  int left_block = left / K, right_block = right / K, res = 0;
  if (left_block == right_block) {
    for (int i = left; i < right; ++i) res += sum[type][i];
  } else {
    for (int i = left_block + 1; i < right_block; ++i)
      res += sum_blocks[type][i];
    for (int i = left; i < (left_block + 1) * K; ++i) res += sum[type][i];
    for (int i = right_block * K; i < right; ++i) res += sum[type][i];
  }
  return res;
}
int get_ans(int left_b, int right_b) {
  return get_sum(0, left_b, 0) + get_sum(right_b, n, 1);
}
int main() {
  int k, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; ++i) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int val, day;
      scanf("%d %d", &day, &val);
      add(day - 1, val);
    } else {
      int day;
      scanf("%d", &day);
      int ans = get_ans(day - 1, day + k - 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
