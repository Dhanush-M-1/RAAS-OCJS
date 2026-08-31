#include <bits/stdc++.h>
using namespace std;
void __print(int x) { cerr << x; }
void __print(long x) { cerr << x; }
void __print(long long x) { cerr << x; }
void __print(unsigned x) { cerr << x; }
void __print(unsigned long x) { cerr << x; }
void __print(unsigned long long x) { cerr << x; }
void __print(float x) { cerr << x; }
void __print(double x) { cerr << x; }
void __print(long double x) { cerr << x; }
void __print(char x) { cerr << '\'' << x << '\''; }
void __print(const char *x) { cerr << '\"' << x << '\"'; }
void __print(const string &x) { cerr << '\"' << x << '\"'; }
void __print(bool x) { cerr << (x ? "true" : "false"); }
template <typename T, typename V>
void __print(const pair<T, V> &x) {
  cerr << '{';
  __print(x.first);
  cerr << ',';
  __print(x.second);
  cerr << '}';
}
template <typename T>
void __print(const T &x) {
  int f = 0;
  cerr << '{';
  for (auto &i : x) cerr << (f++ ? "," : ""), __print(i);
  cerr << "}";
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  __print(t);
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
long long n, k, a, b, q;
class SegTree {
 public:
  vector<long long> seg_tree;
  vector<long long> arr;
  SegTree(int N) {
    for (int i = 1; i <= 4 * N; i++) seg_tree.push_back(0);
    for (int i = 1; i <= N; i++) arr.push_back(0);
  }
  void buildTree(int si, int ss, int second) {
    if (ss == second) {
      seg_tree[si] = arr[ss];
      return;
    }
    int mid = (ss + second) / 2;
    buildTree(2 * si, ss, mid);
    buildTree(2 * si + 1, mid + 1, second);
    seg_tree[si] = seg_tree[2 * si] + seg_tree[2 * si + 1];
    return;
  }
  void updateTree(int si, int ss, int second, int qi) {
    if (ss == second) {
      seg_tree[si] = arr[ss];
      return;
    }
    int mid = (ss + second) / 2;
    if (qi <= mid)
      updateTree(2 * si, ss, mid, qi);
    else
      updateTree(2 * si + 1, mid + 1, second, qi);
    seg_tree[si] = seg_tree[2 * si] + seg_tree[2 * si + 1];
    return;
  }
  long long queryTree(int si, int ss, int second, int qs, int qe) {
    if (qs > second || ss > qe) return 0;
    if (ss >= qs && second <= qe) return seg_tree[si];
    int mid = (ss + second) / 2;
    long long lsum = queryTree(2 * si, ss, mid, qs, qe);
    long long rsum = queryTree(2 * si + 1, mid + 1, second, qs, qe);
    return lsum + rsum;
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> k >> a >> b >> q;
  int N = 2e5 + 10;
  SegTree segA(N), segB(N);
  while (q--) {
    int qi;
    cin >> qi;
    ;
    if (qi == 1) {
      int di, oi;
      cin >> di >> oi;
      ;
      segB.arr[di] = min((long long)b, (long long)(segB.arr[di] + oi));
      segB.updateTree(1, 1, n, di);
      segA.arr[di] = min((long long)a, (long long)(segA.arr[di] + oi));
      segA.updateTree(1, 1, n, di);
    } else {
      int pi;
      cin >> pi;
      ;
      long long ansB, ansA;
      if (pi == 1)
        ansB = 0;
      else
        ansB = segB.queryTree(1, 1, n, 1, pi - 1);
      if (pi + k - 1 == n)
        ansA = 0;
      else
        ansA = segA.queryTree(1, 1, n, pi + k, n);
      cout << ansA + ansB << "\n";
    }
  }
  return 0;
}
