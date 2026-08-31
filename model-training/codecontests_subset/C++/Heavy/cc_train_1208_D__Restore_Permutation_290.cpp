#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1e9 + 7;
long long n = 1, n2, s[200010], ans[200010], dat[800010];
void INIT(long long k, long long lb, long long ub) {
  if (lb == ub) return;
  INIT(k * 2 + 1, lb, (lb + ub) / 2);
  INIT(k * 2 + 2, (lb + ub) / 2 + 1, ub);
  dat[k] = dat[k * 2 + 1] + dat[k * 2 + 2];
}
long long query(long long k, long long lb, long long ub, long long tlb,
                long long tub) {
  if (ub < tlb || tub < lb) return 0;
  if (tlb <= lb && ub <= tub) return dat[k];
  return query(k * 2 + 1, lb, (lb + ub) / 2, tlb, tub) +
         query(k * 2 + 2, (lb + ub) / 2 + 1, ub, tlb, tub);
}
void upd(long long val) {
  long long k = val - 1 + n - 1;
  dat[k] -= val;
  while (k > 0) {
    dat[(k - 1) / 2] -= val;
    k = (k - 1) / 2;
  }
}
bool check(long long mid, long long i) {
  return query(0, 0, n - 1, 0, mid - 2) <= s[i];
}
int main() {
  cin >> n2;
  while (n < n2) n *= 2;
  for (int i = 0; i < n2; i++) scanf("%I64d", &s[i]);
  for (int i = 0; i < n; i++) dat[i + n - 1] = i + 1;
  INIT(0, 0, n - 1);
  for (int i = n2 - 1; i >= 0; i--) {
    int lb = 1, ub = n2, mid;
    while (lb < ub) {
      mid = (lb + ub + 1) / 2;
      if (check(mid, i))
        lb = mid;
      else
        ub = mid - 1;
    }
    ans[i] = lb;
    upd(lb);
  }
  check(2, 2);
  for (int i = 0; i < n2; i++) cout << ans[i] << ' ';
  cout << endl;
  return 0;
}
