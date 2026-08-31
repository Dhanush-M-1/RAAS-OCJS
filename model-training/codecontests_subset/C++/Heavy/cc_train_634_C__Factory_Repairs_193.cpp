#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 9;
const long long mod = 1e9 + 7;
int fen1[maxn], fen2[maxn], num[maxn];
void upd1(int x, int val) {
  for (; x < maxn; x += x & -x) fen1[x] += val;
}
void upd2(int x, int val) {
  for (; x < maxn; x += x & -x) fen2[x] += val;
}
int get1(int x) {
  int res = 0;
  for (; x; x -= x & -x) res += fen1[x];
  return res;
}
int get2(int x) {
  int res = 0;
  for (; x; x -= x & -x) res += fen2[x];
  return res;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int type, d, x, p;
    cin >> type;
    if (type == 1) {
      cin >> d >> x;
      upd1(d, -min(num[d], b));
      upd2(d, -min(num[d], a));
      num[d] += x;
      upd1(d, min(num[d], b));
      upd2(d, min(num[d], a));
    }
    if (type == 2) {
      cin >> p;
      cout << get1(p - 1) + get2(maxn - 1) - get2(p + k - 1) << "\n";
    }
  }
}
