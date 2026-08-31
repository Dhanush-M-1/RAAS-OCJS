#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int n;
int a[MAXN];
int pos[MAXN];
struct BIT {
  long long tree[MAXN];
  BIT() {}
  int LB(int x) { return x & -x; }
  void Modify(int p, long long k) {
    while (p <= n) {
      tree[p] += k;
      p += LB(p);
    }
  }
  long long Query(int p) {
    long long res = 0;
    while (p >= 1) {
      res += tree[p];
      p -= LB(p);
    }
    return res;
  }
  int GetPos(long long sum) {
    int l = 1, r = n, res = 0;
    while (l <= r) {
      int mid = (l + r) >> 1;
      if (Query(mid) <= sum) {
        res = mid;
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return res;
  }
} T1, T2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    pos[a[i]] = i;
  }
  long long cnt = 0;
  for (int i = 1; i <= n; i++) {
    int p = pos[i];
    T1.Modify(p, 1);
    cnt += (long long)i - T1.Query(p);
    T2.Modify(p, p);
    int midp = T1.GetPos(i >> 1) + 1;
    long long tot = 0;
    long long l = i / 2, r = i - i / 2 - 1;
    tot += l * midp - l * (l + 1) / 2 - T2.Query(midp - 1);
    tot += (T2.Query(n) - T2.Query(midp)) - r * midp - r * (r + 1) / 2;
    cout << tot + cnt << ' ';
  }
  return 0;
}
