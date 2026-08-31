#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LL_INF = 0x3f3f3f3f3f3f3f3f;
const int mod = 1000 * 1000 * 1000 + 7;
long long n, k, a, b, q, type, d, x, p, arr[200005], arrb[200005], tree[200005],
    treeb[200005], upd, updb;
void update(int x, long long val) {
  while (x < 200005) {
    tree[x] += val;
    x += (x & -x);
  }
}
void updateb(int x, long long val) {
  while (x < 200005) {
    treeb[x] += val;
    x += (x & -x);
  }
}
long long sum(int x) {
  long long res = 0;
  while (x > 0) {
    res += tree[x];
    x -= (x & -x);
  }
  return res;
}
long long sumb(int x) {
  long long res = 0;
  while (x > 0) {
    res += treeb[x];
    x -= (x & -x);
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    cin >> type;
    if (type == 1) {
      cin >> d >> x;
      if (arr[d] + x > a) {
        upd = a - arr[d];
        arr[d] = a;
      } else {
        arr[d] += x;
        upd = x;
      }
      if (arr[d] > b) {
        updb = b - arrb[d];
        arrb[d] = b;
      } else {
        arrb[d] = arr[d];
        updb = x;
      }
      update(d, upd);
      updateb(d, updb);
    } else {
      cin >> p;
      cout << (sum(n) - sum(p + k - 1)) + sumb(p - 1) << "\n";
    }
  }
  return 0;
}
