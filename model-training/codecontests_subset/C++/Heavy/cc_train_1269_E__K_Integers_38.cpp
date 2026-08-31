#include <bits/stdc++.h>
using namespace std;
const int INF = 1061109567;
const long long LINF = 4557430888798830399ll;
const int MOD = 1000000007;
long long qpow(long long x, long long n) {
  long long res = 1;
  while (n) {
    if (n & 1) res = res * x % MOD;
    x = x * x % MOD;
    n >>= 1;
  }
  return res;
}
struct Treap {
  static const int MAXN = 200000 + 5;
  int ch[MAXN][2], dat[MAXN];
  pair<int, int> val[MAXN];
  int cnt[MAXN];
  int siz[MAXN];
  int tot, root;
  inline void Init() {
    tot = 0;
    root = 0;
  }
  inline int NewNode(pair<int, int> v, int num) {
    int id = ++tot;
    ch[id][0] = ch[id][1] = 0;
    dat[id] = rand();
    val[id] = v;
    cnt[id] = num;
    siz[id] = num;
    return id;
  }
  inline void PushUp(int id) {
    siz[id] = siz[ch[id][0]] + siz[ch[id][1]] + cnt[id];
  }
  inline void Rotate(int &id, int d) {
    int temp = ch[id][d ^ 1];
    ch[id][d ^ 1] = ch[temp][d];
    ch[temp][d] = id;
    id = temp;
    PushUp(ch[id][d]);
    PushUp(id);
  }
  inline void Insert(int &id, pair<int, int> v, int num) {
    if (!id)
      id = NewNode(v, num);
    else {
      if (v == val[id])
        cnt[id] += num;
      else {
        int d = val[id] > v ? 0 : 1;
        Insert(ch[id][d], v, num);
        if (dat[id] < dat[ch[id][d]]) Rotate(id, d ^ 1);
      }
      PushUp(id);
    }
  }
  void Remove(int &id, pair<int, int> v, int num) {
    if (!id)
      return;
    else {
      if (v == val[id]) {
        if (cnt[id] > num) {
          cnt[id] -= num;
          PushUp(id);
        } else if (ch[id][0] || ch[id][1]) {
          if (!ch[id][1] || dat[ch[id][0]] > dat[ch[id][1]])
            Rotate(id, 1), Remove(ch[id][1], v, num);
          else
            Rotate(id, 0), Remove(ch[id][0], v, num);
          PushUp(id);
        } else
          id = 0;
      } else {
        val[id] > v ? Remove(ch[id][0], v, num) : Remove(ch[id][1], v, num);
        PushUp(id);
      }
    }
  }
  int GetRank(int id, pair<int, int> v) {
    int res = 1;
    while (id) {
      if (val[id] > v)
        id = ch[id][0];
      else if (val[id] == v) {
        res += siz[ch[id][0]];
        break;
      } else {
        res += siz[ch[id][0]] + cnt[id];
        id = ch[id][1];
      }
    }
    return res;
  }
  pair<int, int> GetValue(int id, int rk) {
    pair<int, int> res = {INF, INF};
    while (id) {
      if (siz[ch[id][0]] >= rk)
        id = ch[id][0];
      else if (siz[ch[id][0]] + cnt[id] >= rk) {
        res = val[id];
        break;
      } else {
        rk -= siz[ch[id][0]] + cnt[id];
        id = ch[id][1];
      }
    }
    return res;
  }
} treap1, treap2;
int n;
int a[200005];
int p[200005];
long long ans[200005];
void test_case() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    p[a[i]] = i;
  }
  treap1.Init();
  treap2.Init();
  int Lmost = p[1], Rmost = p[1];
  long long cnt1 = 0, cnt2 = 0;
  treap1.Insert(treap1.root, {p[1], 1}, 1);
  treap2.Insert(treap2.root, {p[1], 1}, 1);
  pair<int, int> mid1, mid2;
  mid1 = mid2 = {p[1], 1};
  ans[1] = 0;
  for (int i = 2; i <= n; ++i) {
    treap1.Insert(treap1.root, {p[i], i}, 1);
    if (i % 2 == 0) {
      mid1 = treap1.GetValue(treap1.root, i / 2);
      mid2 = treap1.GetValue(treap1.root, i / 2 + 1);
    } else
      mid1 = mid2 = treap1.GetValue(treap1.root, (i + 1) / 2);
    int rk1 = treap1.GetRank(treap1.root, {p[i], i});
    if (p[i] < Lmost) {
      for (int j = Lmost - 1; j >= p[i]; --j)
        treap2.Insert(treap2.root, {j, a[j]}, 1);
      Lmost = p[i];
      cnt2 += treap2.GetRank(treap2.root, mid2) - 1 - i / 2;
    } else if (p[i] > Rmost) {
      for (int j = Rmost + 1; j <= p[i]; ++j)
        treap2.Insert(treap2.root, {j, a[j]}, 1);
      Rmost = p[i];
      cnt2 +=
          treap2.siz[treap2.root] - treap2.GetRank(treap2.root, mid1) - i / 2;
    } else {
      if (p[i] >= mid2.first) {
        cnt2 -= i - rk1;
        cnt2 -= treap2.siz[treap2.root] -
                treap2.GetRank(treap2.root, {p[i], i}) - (i - rk1);
        cnt2 +=
            treap2.siz[treap2.root] - treap2.GetRank(treap2.root, mid1) - i / 2;
      } else if (p[i] <= mid1.first) {
        cnt2 -= rk1 - 1;
        cnt2 -= treap2.GetRank(treap2.root, {p[i], i}) - (rk1 - 1);
        cnt2 += treap2.GetRank(treap2.root, mid2) - i / 2;
      }
    }
    cnt1 += i - rk1;
    ans[i] = cnt1 + cnt2;
  }
  for (int i = 1; i <= n; ++i) printf("%lld%c", ans[i], " \n"[i == n]);
}
int main() {
  int t = 1;
  for (int ti = 1; ti <= t; ++ti) {
    test_case();
  }
}
