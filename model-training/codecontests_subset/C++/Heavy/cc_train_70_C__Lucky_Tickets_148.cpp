#include <bits/stdc++.h>
using namespace std;
const int P = 1000003;
const int maxn = 100005;
struct Node {
  long long a, b;
  bool operator<(const Node node) const { return a * node.b < b * node.a; }
  Node() {}
  Node(long long a, long long b) : a(a), b(b) {}
} a[maxn];
map<Node, int> M;
map<Node, vector<int> > MV;
int A, B, W;
long long C[maxn];
inline int lowbit(int x) { return x & (-x); }
void cha(int pos, int sz, long long val) {
  while (pos <= sz) {
    C[pos] += val;
    pos += lowbit(pos);
  }
}
long long he(int pos) {
  long long r = 0;
  while (pos > 0) {
    r += C[pos];
    pos -= lowbit(pos);
  }
  return r;
}
int rev(int x) {
  int r = 0;
  while (x) {
    r = r * 10 + (x % 10);
    x /= 10;
  }
  return r;
}
int R[maxn];
vector<int> vc[maxn];
void pre() {
  int i;
  for (i = 1; i < maxn; ++i) R[i] = rev(i);
  for (i = 1; i < maxn; ++i) a[i] = Node(i, R[i]);
  MV.clear();
  for (i = 1; i < maxn; ++i) {
    MV[Node(R[i], i)].push_back(i);
  }
  for (i = 1; i < maxn; ++i) {
    Node now = Node(i, R[i]);
    if (MV.find(now) != MV.end()) vc[i] = MV[Node(i, R[i])];
  }
}
pair<long long, long long> best, now;
void update(pair<long long, long long> a, pair<long long, long long> &best) {
  if (best.first < 0)
    best = a;
  else if (a.first * a.second < best.first * best.second)
    best = a;
}
void gao() {
  memset(C, 0, sizeof C);
  int i, j;
  best = make_pair(-1, -1);
  for (i = 1; i <= A; ++i) {
    for (j = 0; j < vc[i].size(); ++j) {
      cha(vc[i][j], B, 1);
    }
    int l, r, mid;
    l = 1;
    r = B;
    mid = (l + r) >> 1;
    while (l < r) {
      mid = (l + r) >> 1;
      long long ct = he(mid);
      if (ct < W)
        l = mid + 1;
      else
        r = mid - 1;
    }
    mid = min(B, mid + 2);
    while (he(mid) >= W) --mid;
    ++mid;
    if (mid <= B) {
      update(make_pair(i, mid), best);
    }
  }
  if (best.first < 0)
    puts("-1");
  else
    cout << best.first << ' ' << best.second << endl;
}
int main() {
  pre();
  while (cin >> A >> B >> W) {
    gao();
  }
  return 0;
}
