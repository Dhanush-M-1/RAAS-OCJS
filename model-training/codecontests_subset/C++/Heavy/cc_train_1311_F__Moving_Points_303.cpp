#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1, -1, -1, 1, 1};
int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
template <class T>
inline T biton(T n, T pos) {
  return n | ((T)1 << pos);
}
template <class T>
inline T bitoff(T n, T pos) {
  return n & ~((T)1 << pos);
}
template <class T>
inline T ison(T n, T pos) {
  return (bool)(n & ((T)1 << pos));
}
template <class T>
inline T gcd(T a, T b) {
  while (b) {
    a %= b;
    swap(a, b);
  }
  return a;
}
inline int nxt() {
  int aaa;
  scanf("%d", &aaa);
  return aaa;
}
inline long long lxt() {
  long long aaa;
  scanf("%lld", &aaa);
  return aaa;
}
inline double dxt() {
  double aaa;
  scanf("%lf", &aaa);
  return aaa;
}
template <class T>
inline T bigmod(T p, T e, T m) {
  T ret = 1;
  for (; e > 0; e >>= 1) {
    if (e & 1) ret = (ret * p) % m;
    p = (p * p) % m;
  }
  return (T)ret;
}
class fenwick {
 public:
  long long tree[200005] = {0};
  void Update(int pos, long long val, int limit) {
    while (pos <= limit) {
      tree[pos] += val;
      pos += pos & (-pos);
    }
  }
  long long Query(int pos) {
    long long sum = 0;
    while (pos > 0) {
      sum += tree[pos];
      pos -= pos & (-pos);
    }
    return sum;
  }
} past, pastSum;
void solve() {
  vector<pair<long long, long long>> v;
  int n = nxt();
  for (int i = 0; i < n; i++) {
    v.emplace_back(lxt(), 0);
  }
  for (int i = 0; i < n; i++) {
    v[i].second = lxt();
  }
  sort(v.begin(), v.end());
  set<long long> st;
  for (int i = 0; i < n; i++) st.insert(v[i].second);
  vector<long long> velocity(st.begin(), st.end());
  n = (int)(velocity).size();
  long long ans = 0;
  for (int i = 0; i < (int)(v).size(); i++) {
    int pos = lower_bound(velocity.begin(), velocity.end(), v[i].second) -
              velocity.begin();
    ans += past.Query(pos + 1) * v[i].first - pastSum.Query(pos + 1);
    past.Update(pos + 1, 1LL, n);
    pastSum.Update(pos + 1, v[i].first, n);
  }
  printf("%lld\n", ans);
}
int main() {
  cout.setf(ios::fixed);
  cout.precision(10);
  int tc = 1;
  while (tc--) {
    solve();
  }
  return 0;
}
