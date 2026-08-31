#include <bits/stdc++.h>
using namespace std;
struct $ {
  $() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
  }
} $;
const int Maxn = 202005;
class BIT {
  int *tree, sz;

 public:
  BIT() {
    sz = 202005;
    tree = new int[sz + 1];
  }
  BIT(int N) {
    sz = N;
    tree = new int[N + 1];
  }
  ~BIT() { delete[] tree; }
  void update(int idx, int Val) {
    if (idx < 1 || idx > sz) return;
    while (idx <= sz) {
      tree[idx] += Val;
      idx += idx & -idx;
    }
  }
  int read(int idx) {
    int Sum = 0;
    while (idx > 0) {
      Sum += tree[idx];
      idx -= (idx & -idx);
    }
    return Sum;
  }
  int rangeSum(int l, int r) {
    int Ret = read(r) - read(l - 1);
    Ret = max(0, Ret);
    return Ret;
  }
  int readSingle(int idx) {
    int sum = tree[idx];
    if (idx > 0) {
      int z = idx - (idx & -idx);
      idx--;
      while (idx != z) {
        sum -= tree[idx];
        idx -= (idx & -idx);
      }
    }
    return sum;
  }
};
int T1[Maxn], T2[Maxn];
int main() {
  int n, k, a, b, q, type, d, val;
  cin >> n >> k >> a >> b >> q;
  BIT B1, B2;
  while (q--) {
    cin >> type;
    if (type == 1) {
      cin >> d >> val;
      if (T1[d] < a) {
        int temp = min(val, a - T1[d]);
        T1[d] += temp;
        B1.update(d, temp);
      }
      if (T2[d] < b) {
        int temp = min(val, b - T2[d]);
        T2[d] += temp;
        B2.update(d, temp);
      }
    } else {
      cin >> d;
      int Ans = 0;
      Ans = B2.rangeSum(1, d - 1);
      int z = B1.rangeSum(min(d + k, Maxn - 1), Maxn - 1);
      Ans += z;
      cout << Ans << endl;
    }
  }
  return 0;
}
