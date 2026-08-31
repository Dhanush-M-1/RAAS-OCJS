#include <bits/stdc++.h>
using namespace std;
int n, k, nr_b;
int t[500010], dp[500010], cnt[500010];
vector<int> _last[500010];
int f(int x) {
  if (x >= 998244353)
    return x - 998244353;
  else
    return x;
}
struct bucket {
  int offset;
  int bucket_id;
  vector<int> pref_sum;
  bucket() {
    offset = 0;
    bucket_id = nr_b;
    pref_sum = vector<int>(315 + 1, 0);
  }
  void rebuild() {
    int l = (bucket_id - 1) * 315 + 1;
    int r = bucket_id * 315;
    int minn = 1e9;
    for (int i = l; i <= r; i++) minn = min(minn, cnt[i] + offset);
    for (int i = 0; i < 315; i++) pref_sum[i] = 0;
    for (int i = l; i <= r; i++) {
      cnt[i] = (cnt[i] + offset) - minn;
      pref_sum[cnt[i]] = f(pref_sum[cnt[i]] + dp[i - 1]);
    }
    offset = minn;
    for (int i = 1; i < 315; i++)
      pref_sum[i] = f(pref_sum[i] + pref_sum[i - 1]);
  }
  int get_smaller(int k) {
    int x = k - offset;
    if (x < 0)
      return 0;
    else
      return pref_sum[min(x, 315 - 1)];
  }
};
bucket buckets[500];
int get_bucket(int pos) { return (pos - 1) / 315 + 1; }
void add(int start, int end, int val) {
  for (int i = start; i <= end && get_bucket(i) == get_bucket(start); i++)
    cnt[i] += val;
  buckets[get_bucket(start)].rebuild();
  for (int i = get_bucket(start) + 1; i < get_bucket(end); i++)
    buckets[i].offset += val;
  if (get_bucket(start) != get_bucket(end)) {
    for (int i = end; i >= start && get_bucket(i) == get_bucket(end); i--)
      cnt[i] += val;
    buckets[get_bucket(end)].rebuild();
  }
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%d", &t[i]);
  for (int i = 1; i <= n; i++) _last[i].push_back(0);
  dp[0] = 1;
  for (int i = 1; i <= n; i++) {
    if (get_bucket(i) > nr_b) {
      nr_b++;
      buckets[nr_b] = bucket();
    }
    add(_last[t[i]].back() + 1, i, 1);
    if (((int)(_last[t[i]].size())) >= 2) {
      add(_last[t[i]].end()[-2] + 1, _last[t[i]].back(), -1);
    }
    _last[t[i]].push_back(i);
    int total = 0;
    for (int j = 1; j <= nr_b; j++)
      total = f(total + buckets[j].get_smaller(k));
    dp[i] = total;
  }
  printf("%d", dp[n]);
  return 0;
}
