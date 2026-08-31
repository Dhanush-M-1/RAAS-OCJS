#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
int B;
vector<int> counts;
vector<int> dp;
void mod_add(int& first, int second) {
  first += second;
  if (first >= mod) {
    first -= mod;
  }
}
struct Bucket {
  int id;
  int offset = 0;
  vector<int> pref_sum;
  Bucket(int _id) {
    id = _id;
    pref_sum.assign(B, 0);
  }
  void rebuild() {
    int first = id * B, last = (id + 1) * B;
    int smallest = INT_MAX;
    for (int i = first; i < last; ++i) {
      smallest = min(smallest, counts[i] + offset);
    }
    for (int i = first; i < last; ++i) {
      counts[i] = counts[i] - smallest + offset;
    }
    offset = smallest;
    for (int i = 0; i < B; ++i) {
      pref_sum[i] = 0;
    }
    for (int i = first; i < last; ++i) {
      mod_add(pref_sum[counts[i]], dp[i]);
    }
    for (int i = 1; i < B; ++i) {
      mod_add(pref_sum[i], pref_sum[i - 1]);
    }
  }
};
vector<Bucket> buckets;
int getBucket(int val) { return val / B; }
void add(int start, int end, int amt) {
  int startBucket = getBucket(start);
  for (int i = start; i <= end and getBucket(i) == startBucket; ++i) {
    counts[i] += amt;
  }
  buckets[getBucket(start)].rebuild();
  if (getBucket(start) == getBucket(end)) {
    return;
  }
  int endBucket = getBucket(end);
  for (int i = getBucket(start) + 1; i < endBucket; ++i) {
    buckets[i].offset += amt;
  }
  for (int i = end; getBucket(i) == getBucket(end); --i) {
    counts[i] += amt;
  }
  buckets[getBucket(end)].rebuild();
}
int main() {
  int n, k;
  cin >> n >> k;
  vector<int> nums(n, 0);
  for (int i = 0; i < n; ++i) {
    cin >> nums[i];
  }
  B = ceil(sqrt(n));
  for (int i = 0; i < B; ++i) {
    buckets.push_back(Bucket(i));
  }
  counts.assign(n + B, 0);
  dp.assign(n + B, 0);
  vector<vector<int>> prev(n + 1, vector<int>(2, -1));
  dp[0] = 1;
  for (int i = 0; i < n; ++i) {
    add(prev[nums[i]][0] + 1, i, 1);
    if (prev[nums[i]][0] != -1) {
      add(prev[nums[i]][1] + 1, prev[nums[i]][0], -1);
    }
    int total = 0;
    for (int j = 0; j <= getBucket(i); ++j) {
      int count = k - buckets[j].offset;
      if (count >= 0) {
        mod_add(total, buckets[j].pref_sum[min(count, B - 1)]);
      }
    }
    dp[i + 1] = total;
    buckets[getBucket(i)].rebuild();
    if (prev[nums[i]][0] != -1) {
      prev[nums[i]][1] = prev[nums[i]][0];
    }
    prev[nums[i]][0] = i;
  }
  cout << dp[n] << endl;
  return 0;
}
