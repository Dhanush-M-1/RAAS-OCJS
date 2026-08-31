#include <bits/stdc++.h>
using namespace std;
const int maxn = 200100;
const long long mod = 998244353;
const int bsize = 75;
int cnt[maxn];
int dp[maxn];
int n, k;
vector<int> occurences[maxn];
class bucket {
 public:
  int id;
  int first, last;
  int offset, smallest;
  int pref[bsize + 5];
  void build() {
    first = id * bsize;
    last = (id + 1) * bsize - 1;
    smallest = INT_MAX;
    for (int i = first; i <= last; i++) {
      smallest = min(smallest, offset + cnt[i]);
      cnt[i] += offset;
    }
    offset = smallest;
    for (int i = first; i <= last; i++) {
      cnt[i] -= offset;
    }
    for (int i = 0; i <= bsize; i++) {
      pref[i] = 0;
    }
    for (int i = first; i <= last; i++) {
      if (cnt[i] < 0 || cnt[i] > bsize) continue;
      pref[cnt[i]] += dp[i];
      if (pref[cnt[i]] > mod) pref[cnt[i]] -= mod;
    }
    for (int i = 1; i <= bsize; i++) {
      pref[i] += pref[i - 1];
      if (pref[i] > mod) pref[i] -= mod;
    }
  }
} buckets[maxn / bsize + 1];
int bucketid(int i) { return i / bsize; }
void add(int l, int r, int diff) {
  for (int i = l; i <= r && bucketid(i) == bucketid(l); i++) {
    cnt[i] += diff;
  }
  buckets[bucketid(l)].build();
  if (bucketid(l) == bucketid(r)) return;
  for (int i = bucketid(l) + 1; i < bucketid(r); i++) {
    buckets[i].offset += diff;
  }
  for (int i = r; i >= l && bucketid(i) == bucketid(r); i--) {
    cnt[i] += diff;
  }
  buckets[bucketid(r)].build();
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 0; i <= bucketid(n - 1); i++) {
    buckets[i].id = i;
  }
  for (int i = 0; i <= n; i++) {
    occurences[i].push_back(-1);
  }
  dp[0] = 1;
  buckets[bucketid(0)].build();
  int x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    if (occurences[x].size() >= 2) {
      add(occurences[x][occurences[x].size() - 2] + 1,
          occurences[x][occurences[x].size() - 1], -1);
    }
    add(occurences[x].back() + 1, i, 1);
    occurences[x].push_back(i);
    int total = 0;
    for (int j = 0; j <= bucketid(i); j++) {
      int limit = k - buckets[j].offset;
      if (limit >= 0) {
        total += buckets[j].pref[min(bsize, limit)];
        if (total > mod) total -= mod;
      }
    }
    dp[i + 1] = total;
    buckets[bucketid(i)].build();
  }
  cout << dp[n] << "\n";
  return 0;
}
