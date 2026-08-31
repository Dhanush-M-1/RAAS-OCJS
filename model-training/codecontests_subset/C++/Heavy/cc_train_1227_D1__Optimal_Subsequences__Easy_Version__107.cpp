#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007;
const long long INF = 1e9 + 5;
const double eps = 1e-7;
const double PI = acos(-1.0);
inline void debug_vi(vector<int> a) {
  for (long long i = (long long)(0); i < (long long)(a.size()); i++)
    cout << a[i] << " ";
}
inline void debug_vll(vector<long long> a) {
  for (long long i = (long long)(0); i < (long long)(a.size()); i++)
    cout << a[i] << " ";
}
inline void print_case(int tn) { cout << "Case #" << tn << ": "; }
template <typename T>
using minpq = priority_queue<T, vector<T>, greater<T>>;
template <typename T>
using maxpq = priority_queue<T>;
const int N = 2e5 + 5;
int a[N], arr[N];
vector<pair<int, int>> vals;
int n;
struct SegmentTreeNode {
  int sm;
  void assignLeaf(int value) { sm = value; }
  void merge(SegmentTreeNode& left, SegmentTreeNode& right) {
    sm = left.sm + right.sm;
  }
  int getValue() { return sm; }
};
template <class T, class V>
class SegmentTree {
  SegmentTreeNode* nodes;
  int N;

 public:
  SegmentTree(T arr[], int N) {
    this->N = N;
    nodes = new SegmentTreeNode[getSegmentTreeSize(N)];
    buildTree(arr, 1, 0, N - 1);
  }
  ~SegmentTree() { delete[] nodes; }
  V getValue(int pos) { return getValue(1, 0, N - 1, pos); }
  void update(int index, T value) { update(1, 0, N - 1, index, value); }

 private:
  void buildTree(T arr[], int stIndex, int lo, int hi) {
    if (lo == hi) {
      nodes[stIndex].assignLeaf(arr[lo]);
      return;
    }
    int left = 2 * stIndex, right = left + 1, mid = lo + (hi - lo) / 2;
    buildTree(arr, left, lo, mid);
    buildTree(arr, right, mid + 1, hi);
    nodes[stIndex].merge(nodes[left], nodes[right]);
  }
  int getValue(int stIndex, int left, int right, int pos) {
    if (left == right) {
      return left;
    }
    int mid = (left + right) / 2;
    if (nodes[2 * stIndex].getValue() >= pos)
      return getValue(2 * stIndex, left, mid, pos);
    return getValue(2 * stIndex + 1, mid + 1, right,
                    pos - nodes[2 * stIndex].getValue());
  }
  int getSegmentTreeSize(int N) { return 4 * N; }
  void update(int stIndex, int lo, int hi, int index, T value) {
    if (lo == hi) {
      nodes[stIndex].assignLeaf(value);
      return;
    }
    int left = 2 * stIndex, right = left + 1, mid = lo + (hi - lo) / 2;
    if (index <= mid)
      update(left, lo, mid, index, value);
    else
      update(right, mid + 1, hi, index, value);
    nodes[stIndex].merge(nodes[left], nodes[right]);
  }
};
bool cmp(pair<int, int> a, pair<int, int> b) {
  if (a.first != b.first) return a.first > b.first;
  return a.second < b.second;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  clock_t clk = clock();
  cin >> n;
  vals.resize(n);
  for (long long i = (long long)(0); i < (long long)(n); i++) {
    cin >> a[i];
    vals[i] = {a[i], i};
    arr[i] = 1;
  }
  sort((vals).begin(), (vals).end(), cmp);
  SegmentTree<int, int> st(arr, n);
  int m;
  cin >> m;
  vector<tuple<int, int, int>> reqs(m);
  int k, pos, idx;
  for (long long i = (long long)(0); i < (long long)(m); i++) {
    cin >> k >> pos;
    reqs[i] = make_tuple(k, pos, i);
  }
  sort((reqs).begin(), (reqs).end());
  vector<int> res(m);
  int curr = n;
  for (long long i = (long long)(m - 1); i >= (long long)(0); i--) {
    tie(k, pos, idx) = reqs[i];
    while (curr > k) {
      st.update(vals[curr - 1].second, 0);
      curr--;
    }
    res[idx] = a[st.getValue(pos)];
  }
  for (int a : res) {
    cout << a << "\n";
  }
  cerr << "\n"
       << "Time (in ms): " << double(clock() - clk) * 1000.0 / CLOCKS_PER_SEC
       << "\n";
  return 0;
}
