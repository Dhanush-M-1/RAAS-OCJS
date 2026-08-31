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
struct TreapNode {
  int val1, val2;
  TreapNode() {}
  TreapNode(int val1, int val2) : val1(val1), val2(val2) {}
  bool operator<(const TreapNode& tn) const { return val1 < tn.val1; }
  bool operator<=(const TreapNode& tn) const { return val1 <= tn.val1; }
  bool operator==(const TreapNode& tn) const { return val1 == tn.val1; }
  bool operator>=(const TreapNode& tn) const { return val1 >= tn.val1; }
  bool operator>(const TreapNode& tn) const { return val1 > tn.val1; }
} TNINF(INF, INF);
struct Treap {
  static const int MAXN = 200000;
  int ch[MAXN + 5][2], dat[MAXN + 5];
  TreapNode val[MAXN + 5];
  int cnt[MAXN + 5];
  int siz[MAXN + 5];
  int tot, root;
  void Init() {
    tot = 0;
    root = 0;
  }
  int NewNode(TreapNode v, int num) {
    int id = ++tot;
    ch[id][0] = ch[id][1] = 0;
    dat[id] = rand();
    val[id] = v;
    cnt[id] = num;
    siz[id] = num;
    return id;
  }
  void PushUp(int id) { siz[id] = siz[ch[id][0]] + siz[ch[id][1]] + cnt[id]; }
  void Rotate(int& id, int d) {
    int temp = ch[id][d ^ 1];
    ch[id][d ^ 1] = ch[temp][d];
    ch[temp][d] = id;
    id = temp;
    PushUp(ch[id][d]);
    PushUp(id);
  }
  void _Insert(int& id, TreapNode v, int num) {
    if (!id)
      id = NewNode(v, num);
    else {
      if (v == val[id])
        cnt[id] += num;
      else {
        int d = val[id] > v ? 0 : 1;
        _Insert(ch[id][d], v, num);
        if (dat[id] < dat[ch[id][d]]) Rotate(id, d ^ 1);
      }
      PushUp(id);
    }
  }
  void _Remove(int& id, TreapNode v, int num) {
    if (!id)
      return;
    else {
      if (v == val[id]) {
        if (cnt[id] > num) {
          cnt[id] -= num;
          PushUp(id);
        } else if (ch[id][0] || ch[id][1]) {
          if (!ch[id][1] || dat[ch[id][0]] > dat[ch[id][1]])
            Rotate(id, 1), _Remove(ch[id][1], v, num);
          else
            Rotate(id, 0), _Remove(ch[id][0], v, num);
          PushUp(id);
        } else
          id = 0;
      } else {
        val[id] > v ? _Remove(ch[id][0], v, num) : _Remove(ch[id][1], v, num);
        PushUp(id);
      }
    }
  }
  int _GetRank(int id, TreapNode v) {
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
  TreapNode _GetValue(int id, int rk) {
    TreapNode res = TNINF;
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
  int Size() { return siz[root]; }
  void Insert(TreapNode v, int num = 1) { _Insert(root, v, num); }
  void Remove(TreapNode v, int num = INF) { _Remove(root, v, num); }
  int GetRank(TreapNode v) { return _GetRank(root, v); }
  TreapNode GetValue(int rk) { return _GetValue(root, rk); }
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
  TreapNode cur(p[1], 1);
  treap1.Insert(cur);
  treap2.Insert(cur);
  TreapNode mid1, mid2;
  mid1 = mid2 = cur;
  ans[1] = 0;
  for (int i = 2; i <= n; ++i) {
    cur = TreapNode(p[i], i);
    treap1.Insert(cur, 1);
    mid1 = treap1.GetValue((i + 1) / 2);
    mid2 = treap1.GetValue(i / 2 + 1);
    if (p[i] < Lmost) {
      for (int j = Lmost - 1; j >= p[i]; --j) treap2.Insert(TreapNode(j, a[j]));
      Lmost = p[i];
    } else if (p[i] > Rmost) {
      for (int j = Rmost + 1; j <= p[i]; ++j) treap2.Insert(TreapNode(j, a[j]));
      Rmost = p[i];
    }
    cnt1 += i - treap1.GetRank(cur);
    if (p[i] >= mid2.val1) {
      cnt2 -= treap2.Size() - treap2.GetRank(cur);
      cnt2 += treap2.Size() - treap2.GetRank(mid1) - i / 2;
    } else if (p[i] <= mid1.val1) {
      cnt2 -= treap2.GetRank(cur);
      cnt2 += treap2.GetRank(mid2) - i / 2;
    }
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
