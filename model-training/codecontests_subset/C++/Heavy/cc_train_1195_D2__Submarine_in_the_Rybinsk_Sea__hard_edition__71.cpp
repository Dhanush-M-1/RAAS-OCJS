#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
const long long MNOGO = 2e9;
const long long MD = 998244353;
const double EPS = 1e-7;
struct pryama {
  double a, b, c;
};
class segmentTree {
 public:
  long long val = 0;
  segmentTree* left = nullptr;
  segmentTree* right = nullptr;
  long long tl = 0, tr = 1ll << 22;
  void createSons() {
    if (left == nullptr) {
      left = new segmentTree();
      left->tl = tl;
      left->tr = (tl + tr) / 2;
    }
    if (right == nullptr) {
      right = new segmentTree();
      right->tr = tr;
      right->tl = (tl + tr) / 2 + 1;
    }
  }
  void update(long long pos, long long q) {
    if (tl == tr) {
      val += q;
      return;
    }
    long long tm = (tl + tr) / 2;
    createSons();
    if (pos <= tm) {
      left->update(pos, q);
    } else {
      right->update(pos, q);
    }
    val = left->val + right->val;
  }
  long long get(long long l, long long r) {
    if (l > r) {
      return 0;
    }
    if (l > tr || r < tl) {
      return 0;
    }
    if (tl >= l && tr <= r) {
      return val;
    }
    createSons();
    return left->get(l, r) + right->get(l, r);
  }
};
long long n;
long long ans[10];
string a[100005];
long long dl1[15], dl2[15];
long long cnt[15], cdl2[15];
long long sqr(long long a) { return a * a; }
long long binpow(long long a, long long b) {
  if (b == 0) {
    return 1;
  }
  if (b % 2 == 0) {
    return sqr(binpow(a, b / 2)) % MD;
  }
  return a * binpow(a, b - 1) % MD;
}
long long modify(string& st, long long type, long long sz) {
  long long wsz = sz;
  if (type == 1) {
    string res;
    long long rz = 0, curSz = 0;
    for (long long j = st.size() - 1; j >= 0; j--, sz--) {
      rz += (binpow(10, curSz) * (st[j] - '0')) % MD;
      rz %= MD;
      curSz++;
      if (sz > 0) {
        curSz++;
      }
    }
    return rz % MD;
  } else {
    string res;
    long long rz = 0, curSz = 0;
    for (long long j = st.size() - 1; j >= 0; j--, sz--) {
      if (sz > 0) {
        curSz++;
      }
      rz += (binpow(10, curSz) * (st[j] - '0')) % MD;
      rz %= MD;
      curSz++;
    }
    return rz % MD;
  }
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    string st2(a[i].size() * 2, '0');
    long long indx = a[i].size() - 1;
    long long curSz = 0, curNum = 0;
    for (long long j = st2.size() - 1; j >= 0; j -= 2) {
      curNum += (binpow(10, curSz) * (a[i][indx--] - '0')) % MD;
      curNum %= MD;
      curSz += 2;
    }
    dl1[a[i].size()] += curNum;
    dl1[a[i].size()] %= MD;
    st2.assign(a[i].size() * 2, '0');
    indx = a[i].size() - 1;
    curNum = 0;
    if (a[i].size() != 10) {
      long long curSz = 1;
      for (long long j = (long long)st2.size() - 2; j >= 0; j -= 2) {
        curNum += (binpow(10, curSz) * (a[i][indx--] - '0')) % MD;
        curNum %= MD;
        curSz += 2;
      }
      dl2[a[i].size()] += curNum;
      dl2[a[i].size()] %= MD;
    }
    cnt[a[i].size()]++;
  }
  for (long long i = 1; i <= n; i++) {
    string st = a[i];
    for (long long d = 1; d <= st.size(); d++) {
      ans = (ans + dl1[d]) % MD;
      ans = (ans + (cnt[d] * modify(a[i], 2, d)) % MD) % MD;
    }
    for (long long d = 1; d < st.size(); d++) {
      ans = (ans + dl2[d]) % MD;
      ans = (ans + (cnt[d] * modify(a[i], 1, d)) % MD) % MD;
    }
  }
  cout << ans << '\n';
}
