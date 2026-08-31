#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
const int MAX_N = 2e5 + 5;
vector<int> occurrences[MAX_N];
int cnt[MAX_N], dp[MAX_N];
void add_self(int& a, int b) {
  a += b;
  if (a >= mod) {
    a -= mod;
  }
}
const int B = 256;
struct Bucket {
  int id;
  int offset;
  int pref_sum[B];
  void rebuild() {
    int first = id * B, last = (id + 1) * B - 1;
    int smallest = INT_MAX;
    for (int i = first; i <= last; ++i) {
      smallest = min(smallest, offset + cnt[i]);
    }
    for (int i = first; i <= last; ++i) {
      cnt[i] -= smallest - offset;
      assert(0 <= cnt[i] && cnt[i] < B);
    }
    offset = smallest;
    for (int x = 0; x < B; ++x) {
      pref_sum[x] = 0;
    }
    for (int i = first; i <= last; ++i) {
      add_self(pref_sum[cnt[i]], dp[i]);
    }
    for (int x = 1; x < B; ++x) {
      add_self(pref_sum[x], pref_sum[x - 1]);
    }
  }
} buckets[MAX_N / B + 1];
int which(int i) { return i / B; }
void add(int a, int b, int diff) {
  for (int i = a; i <= b && which(i) == which(a); ++i) {
    cnt[i] += diff;
  }
  buckets[which(a)].rebuild();
  if (which(a) == which(b)) {
    return;
  }
  for (int i = which(a) + 1; i < which(b); ++i) {
    buckets[i].offset += diff;
  }
  for (int i = b; which(i) == which(b); --i) {
    cnt[i] += diff;
  }
  buckets[which(b)].rebuild();
}
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 0; i <= which(n - 1); ++i) {
    buckets[i].id = i;
  }
  for (int x = 1; x <= n; ++x) {
    occurrences[x].push_back(-1);
  }
  dp[0] = 1;
  buckets[which(0)].rebuild();
  for (int R = 0; R < n; ++R) {
    int x;
    scanf("%d", &x);
    vector<int>& vec = occurrences[x];
    if ((int)vec.size() >= 2) {
      add(vec.end()[-2] + 1, vec.back(), -1);
    }
    add(vec.back() + 1, R, 1);
    vec.push_back(R);
    int total = 0;
    for (int i = 0; i <= which(R); ++i) {
      int at_most = k - buckets[i].offset;
      if (at_most >= 0) {
        add_self(total, buckets[i].pref_sum[min(at_most, B - 1)]);
      }
    }
    dp[R + 1] = total;
    buckets[which(R + 1)].rebuild();
  }
  printf("%d\n", dp[n]);
}
