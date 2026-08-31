#include <bits/stdc++.h>
using namespace std;
struct Pt {
  int x, v;
  bool operator<(const Pt &a) const { return x < a.x; }
};
struct BIT {
  vector<long long> bit, cnt;
  int n;
  BIT(int sz) {
    bit.resize(sz + 1);
    cnt.resize(sz + 1);
    n = sz;
  }
  void add(int x, long long v) {
    while (x <= n) {
      cnt[x]++;
      bit[x] += v;
      x += x & (-x);
    }
  }
  pair<long long, long long> ask(int x) {
    pair<long long, long long> ret(0, 0);
    while (x) {
      ret.first += bit[x];
      ret.second += cnt[x];
      x -= x & (-x);
    }
    return ret;
  }
};
vector<int> V;
Pt arr[200005];
int n;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &arr[i].x);
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &arr[i].v);
    V.push_back(arr[i].v);
  }
  long long ans = 0;
  sort(arr, arr + n);
  sort(begin(V), end(V));
  V.erase(unique(begin(V), end(V)), end(V));
  BIT loli(V.size());
  for (int i = 0; i < n; i++) {
    int p = lower_bound(begin(V), end(V), arr[i].v) - begin(V) + 1;
    auto val = loli.ask(p);
    ans = ans + arr[i].x * val.second - val.first;
    loli.add(p, arr[i].x);
  }
  printf("%lld\n", ans);
  return 0;
}
