#include <bits/stdc++.h>
using namespace std;
const int MOD = 1000000007;
const int INF = 2e9;
const long long INFLL = 1e18;
const int MAX_N = 1;
int N;
vector<long long> v;
struct SEG {
  struct NODE {
    int l, r;
    long long data;
  };
  vector<NODE> seg;
  int SZ;
  void add() { seg.push_back((NODE){-1, -1, (long long)0}); }
  void Init(int x) {
    SZ = x;
    add();
    init(0, 1, SZ);
  }
  void init(int idx, int s, int e) {
    if (s == e) return;
    seg[idx].l = seg.size();
    add();
    seg[idx].r = seg.size();
    add();
    init(seg[idx].l, s, (s + e) / 2);
    init(seg[idx].r, (s + e) / 2 + 1, e);
  }
  void Update(int x, long long y) { update(0, 1, SZ, x, y); }
  void update(int idx, int s, int e, int x, long long y) {
    seg[idx].data += y;
    if (s == e) return;
    if (x <= (s + e) / 2)
      update(seg[idx].l, s, (s + e) / 2, x, y);
    else
      update(seg[idx].r, (s + e) / 2 + 1, e, x, y);
  }
  long long Sum(int x, int y) { return sum(0, 1, SZ, x, y); }
  long long sum(int idx, int s, int e, int x, int y) {
    if (x <= s && e <= y)
      return seg[idx].data;
    else if (x > e || y < s)
      return 0;
    return sum(seg[idx].l, s, (s + e) / 2, x, y) +
           sum(seg[idx].r, (s + e) / 2 + 1, e, x, y);
  }
};
SEG Seg;
vector<long long> ans;
set<int> st;
int main() {
  cin >> N;
  Seg.Init(N);
  for (int i = 0; i < N; i++) {
    long long x;
    scanf("%lld", &x);
    v.push_back(x);
  }
  for (int i = 1; i <= N; i++) {
    Seg.Update(i, i);
    st.insert(i);
  }
  while (!v.empty()) {
    long long x = v.back();
    v.pop_back();
    int s = 1, e = N, m;
    while (s < e) {
      m = (s + e) / 2 + 1;
      if (Seg.Sum(1, m - 1) > x) {
        e = m - 1;
      } else {
        s = m;
      }
    }
    s = (*st.lower_bound(s));
    st.erase(s);
    ans.push_back(s);
    Seg.Update(s, -s);
  }
  while (!ans.empty()) {
    printf("%d ", (int)ans.back());
    ans.pop_back();
  }
  return 0;
}
