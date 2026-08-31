#include <bits/stdc++.h>
using namespace std;
long long mod = 998244353LL;
int kk;
class Block {
 public:
  int aux;
  vector<long long> pre;
  int st, en;
  int lo, hi;
  vector<long long> vals;
  vector<int> dist;
  Block(int a, int b) {
    aux = 0;
    st = a;
    en = b;
    lo = 0;
    hi = 0;
    pre.push_back(0LL);
    pre.push_back(0LL);
    for (int i = st; i <= en; i++) {
      vals.push_back(0LL);
      dist.push_back(0);
    }
  }
  void change(int ind, long long val) {
    if (ind < st || ind > en) {
      return;
    }
    vals[ind - st] = val;
    for (int i = dist[ind - st]; i <= hi; i++) {
      pre[i - lo + 1] += val;
      pre[i - lo + 1] %= mod;
    }
  }
  void modify(int l, int r, int delta) {
    if (l <= st && r >= en) {
      aux += delta;
      return;
    }
    if (st > r || en < l) {
      return;
    }
    for (int i = max(l, st); i <= min(r, en); i++) {
      dist[i - st] += delta;
    }
    for (int i = st; i <= en; i++) {
      dist[i - st] += aux;
      if (i == st) {
        lo = dist[i - st];
        hi = dist[i - st];
      } else {
        lo = min(lo, dist[i - st]);
        hi = max(hi, dist[i - st]);
      }
    }
    aux = 0;
    pre.clear();
    pre.resize(hi - lo + 2);
    for (int i = st; i <= en; i++) {
      pre[dist[i - st] - lo + 1] += vals[i - st];
      pre[dist[i - st] - lo + 1] %= mod;
    }
    for (int i = 1; i < pre.size(); i++) {
      pre[i] += pre[i - 1];
      pre[i] %= mod;
    }
  }
  long long sum(int l, int r) {
    if (st > r || en < l) {
      return 0LL;
    }
    int k = kk;
    if (l <= st && r >= en) {
      k -= aux;
      if (k < lo) {
        return 0LL;
      }
      if (k >= hi) {
        return pre.back();
      }
      return pre[k - lo + 1];
    }
    long long ret = 0LL;
    for (int i = max(l, st); i <= min(r, en); i++) {
      k -= aux;
      if (dist[i - st] <= k) {
        ret += vals[i - st];
        ret %= mod;
      }
    }
    return (ret % mod);
  }
};
int sz = 300;
int n;
vector<Block> blocks;
void build() {
  int point = 0;
  while (point < n + 1) {
    int en = min(point + sz - 1, n);
    blocks.push_back(Block(point, en));
    point = en + 1;
  }
}
void add(int l, int r, int delta) {
  for (int i = 0; i < blocks.size(); i++) {
    blocks[i].modify(l, r, delta);
  }
}
long long gsum(int l, int r) {
  long long ret = 0LL;
  for (int i = 0; i < blocks.size(); i++) {
    ret += blocks[i].sum(l, r);
  }
  return ret % mod;
}
void doChange(int ind, long long vv) {
  for (int i = 0; i < blocks.size(); i++) {
    blocks[i].change(ind, vv);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> kk;
  vector<int> list[n];
  int a[n + 1];
  int bef[n + 1];
  int bef2[n + 1];
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    a[i]--;
    list[a[i]].push_back(i);
    int siz = list[a[i]].size();
    if (list[a[i]].size() == 1) {
      bef[i] = -1;
      bef2[i] = -1;
    } else if (list[a[i]].size() == 2) {
      bef[i] = list[a[i]][siz - 2];
      bef2[i] = -1;
    } else {
      bef[i] = list[a[i]][siz - 2];
      bef2[i] = list[a[i]][siz - 3];
    }
  }
  build();
  doChange(0, 1LL);
  for (int i = 1; i <= n; i++) {
    if (bef[i] == -1) {
      add(0, i - 1, 1);
    } else if (bef2[i] == -1) {
      add(0, bef[i] - 1, -1);
      add(bef[i], i - 1, 1);
    } else {
      add(bef2[i], bef[i] - 1, -1);
      add(bef[i], i - 1, 1);
    }
    long long got = gsum(0, i - 1) % mod;
    doChange(i, got);
  }
  cout << blocks.back().vals.back() << endl;
}
