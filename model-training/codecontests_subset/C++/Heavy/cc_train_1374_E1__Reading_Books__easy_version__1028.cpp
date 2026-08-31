#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k;
  cin >> n >> k;
  vector<long long> a;
  vector<long long> b;
  vector<long long> m;
  for (long long i = 0; i < n; i = i + 1) {
    long long t, aa, bb;
    cin >> t >> aa >> bb;
    if (aa == 1 && bb == 0) {
      a.push_back(t);
    }
    if (aa == 0 && bb == 1) {
      b.push_back(t);
    }
    if (aa == 1 && bb == 1) {
      m.push_back(t);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(m.begin(), m.end());
  long long na = a.size();
  long long nb = b.size();
  long long nm = m.size();
  for (long long i = 1; i < na; i = i + 1) a[i] += a[i - 1];
  for (long long i = 1; i < nb; i = i + 1) b[i] += b[i - 1];
  for (long long i = 1; i < nm; i = i + 1) m[i] += m[i - 1];
  long long ans = 1e18;
  if (na >= k && nb >= k) ans = a[k - 1] + b[k - 1];
  long long mi = min(nm, k);
  for (long long i = 0; i < mi; i = i + 1) {
    if (k - i - 2 >= 0 && k - i - 2 < na && k - i - 2 < nb)
      ans = min(ans, m[i] + a[k - i - 2] + b[k - i - 2]);
  }
  if (nm >= k) ans = min(ans, m[k - 1]);
  if (ans == 1e18)
    cout << -1 << endl;
  else
    cout << ans << endl;
}
