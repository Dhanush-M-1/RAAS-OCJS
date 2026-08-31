#include <bits/stdc++.h>
using namespace std;
const int NN = (int)2e5 + 5;
int A[NN];
int pos[NN];
int n;
long long tree_cnt[NN];
long long tree_sum[NN];
long long read(long long* tree, int idx) {
  idx++;
  long long res = 0;
  while (idx > 0) {
    res += tree[idx];
    idx -= (idx & (-idx));
  }
  return res;
}
void update(long long* tree, int idx, long long val) {
  idx++;
  while (idx < NN) {
    tree[idx] += val;
    idx += (idx & (-idx));
  }
}
int find_median(int len) {
  int lo = 0, hi = n;
  int half = (len + 1) / 2;
  while (lo < hi) {
    int mid = (lo + hi) >> 1;
    int r = read(tree_cnt, mid);
    if (r < half)
      lo = mid + 1;
    else
      hi = mid;
  }
  return lo;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> A[i];
    A[i]--;
    pos[A[i]] = i;
  }
  memset(tree_cnt, 0, sizeof(tree_cnt));
  memset(tree_sum, 0, sizeof(tree_sum));
  long long tot = 0;
  long long rev = 0;
  for (int i = 0; i < n; i++) {
    rev += i - read(tree_cnt, pos[i]);
    update(tree_cnt, pos[i], +1);
    update(tree_sum, pos[i], pos[i]);
    int len = i + 1;
    int med = find_median(len);
    tot += pos[i];
    long long sum_down = read(tree_sum, med);
    long long sum_up = tot - sum_down;
    long long down_cnt = (len + 1) / 2;
    long long up_cnt = len - down_cnt;
    long long res = 0;
    res += sum_up - med * up_cnt - (up_cnt * (up_cnt + 1)) / 2;
    res += med * down_cnt - sum_down - (down_cnt * (down_cnt - 1)) / 2;
    res += rev;
    if (i > 0) printf(" ");
    printf("%lld", res);
  }
  printf("\n");
  return 0;
}
