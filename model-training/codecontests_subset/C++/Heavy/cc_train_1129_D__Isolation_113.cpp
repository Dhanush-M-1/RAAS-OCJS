#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
template <class TH>
void _dbg(const char *sdbg, TH h) {
  cerr << sdbg << '=' << h << endl;
}
template <class TH, class... TA>
void _dbg(const char *sdbg, TH h, TA... a) {
  while (*sdbg != ',') cerr << *sdbg++;
  cerr << '=' << h << ',';
  _dbg(sdbg + 1, a...);
}
template <class T>
ostream &operator<<(ostream &os, vector<T> V) {
  os << "[";
  for (auto vv : V) os << vv << ",";
  return os << "]";
}
template <class L, class R>
ostream &operator<<(ostream &os, pair<L, R> P) {
  return os << "(" << P.first << "," << P.second << ")";
}
const int maxn = 2e5 + 10;
const int md = 998244353;
const int BlockLen = 50;
const int NumBlocks = maxn / BlockLen + 10;
void addto(int &x, int y) {
  x = x + y;
  if (x >= md) x -= md;
}
int T;
string str;
int n, m;
int dp[maxn], cnt[maxn];
vector<int> e[maxn];
int nk;
struct Block {
  int L, R;
  vector<pair<int, int>> pref_sums;
  int ptr;
  int increase;
  vector<int> num_incrs;
  Block() : L(0), R(0), ptr(0), increase(0) {}
  Block(int l, int r) : L(l), R(r), ptr(0), increase(0), num_incrs(r - l) {}
  void IncrAll(int delta) { increase += delta; }
  void Rebuild() {
    vector<int> order(num_incrs.size());
    int min_num_incrs = num_incrs[0];
    for (int i = 1; i < num_incrs.size(); ++i) {
      min_num_incrs = min(min_num_incrs, num_incrs[i]);
    }
    vector<vector<int>> base(num_incrs.size());
    for (int i = 0; i < num_incrs.size(); ++i) {
      base[num_incrs[i] - min_num_incrs].push_back(i);
    }
    int cnt = 0;
    for (int i = 0; i < base.size(); ++i) {
      for (auto id : base[i]) order[cnt++] = id;
    }
    pref_sums.clear();
    pref_sums.emplace_back((int)-1e9, 0);
    pref_sums.emplace_back(num_incrs[order[0]], dp[order[0] + L]);
    for (int i = 1; i < order.size(); ++i) {
      const int v = order[i];
      long long val = (pref_sums.back().second + dp[v + L]) % md;
      if (num_incrs[v] == pref_sums.back().first) {
        pref_sums.back().second = val;
      } else {
        pref_sums.emplace_back(num_incrs[v], val);
      }
    }
    ptr = 0;
    42;
  }
  void IncrSeg(int lft, int rgt, int delta) {
    for (int i = 0; i < (int)num_incrs.size(); ++i) {
      num_incrs[i] += increase;
    }
    increase = 0;
    for (int i = lft - L; i < rgt - L; ++i) {
      num_incrs[i] += delta;
    }
    42;
    Rebuild();
  }
  int GetAtMaxK() {
    while (ptr > 0 && pref_sums[ptr].first + increase > nk) {
      --ptr;
    }
    while (ptr < pref_sums.size() - 1 &&
           pref_sums[ptr + 1].first + increase <= nk) {
      ++ptr;
    }
    42;
    return pref_sums[ptr].second;
  }
};
Block blocks[NumBlocks];
void Increase(int L, int R, int delta) {
  42;
  for (int i = 0; i < n; ++i) {
    const int l_block = i * BlockLen;
    const int r_block = min((i + 1) * BlockLen, n + 1);
    if (l_block > n) break;
    if (r_block <= L || l_block >= R) continue;
    if (L <= l_block && r_block <= R) {
      blocks[i].IncrAll(delta);
    } else {
      blocks[i].IncrSeg(max<int>(L, l_block), min(R, r_block), delta);
    }
  }
}
int GetAtMaxK() {
  int ans = 0;
  for (int i = 0; i < NumBlocks; ++i) {
    const int l_block = i * BlockLen;
    if (l_block > n) break;
    ans = (ans + blocks[i].GetAtMaxK()) % md;
  }
  return ans;
}
void BuildBlocks() {
  for (int i = 0; i < NumBlocks; ++i) {
    const int l_block = i * BlockLen;
    const int r_block = min(n + 1, (i + 1) * BlockLen);
    if (l_block > n) break;
    blocks[i] = Block(l_block, r_block);
    blocks[i].Rebuild();
  }
}
void task() {
  cin >> n >> nk;
  dp[0] = 1;
  BuildBlocks();
  for (int i = 1; i <= n; ++i) {
    int x;
    cin >> x;
    e[x].push_back(i);
    int l1, r1 = i;
    if (e[x].size() > 1)
      l1 = e[x][e[x].size() - 2];
    else
      l1 = 0;
    Increase(l1, r1, 1);
    if (e[x].size() >= 2) {
      int l2 = e[x].size() >= 3 ? e[x][e[x].size() - 3] : 0, r2 = l1;
      Increase(l2, r2, -1);
    }
    42;
    dp[i] = GetAtMaxK();
    blocks[i / BlockLen].Rebuild();
    42;
  }
  cout << dp[n] << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  T = 1;
  while (T--) {
    task();
  }
  return 0;
}
