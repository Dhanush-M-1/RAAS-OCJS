#include <bits/stdc++.h>
using namespace std;
using namespace std;
inline int qpow(int b, int e, int m = 998244353) {
  int a = 1;
  for (; e; e >>= 1, b = (long long)b * b % m)
    if (e & 1) a = (long long)a * b % m;
  return a;
}
int n, m, q, k;
int a[300005], b[300005], c[300005];
const int pp[11] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  vector<long long> v(n + 1);
  v[1] = 1;
  for (long long i = 2; i < n; i++) {
    v[i] = v[i - 1] + 2 * (n - (i - 1));
  }
  v[n] = v[n - 1] + 2;
  auto itr1 = upper_bound(v.begin(), v.end(), l);
  auto itr2 = upper_bound(v.begin(), v.end(), r);
  if (itr1 == v.end()) {
    cout << 1 << endl;
  } else {
    int in1 = -1;
    int in2 = -1;
    auto k1 = itr1;
    auto k2 = itr2;
    int st1;
    st1 = (--k1) - v.begin();
    int st2;
    st2 = k2 - v.begin();
    long long i = v[st1];
    while (i <= r && i < v[n]) {
      for (int j = 0; j < n - st1; j++) {
        if (i >= l && i <= r) cout << st1 << " ";
        i++;
        if (i >= l && i <= r) cout << st1 + j + 1 << " ";
        i++;
      }
      st1++;
    }
    if (r == v[n])
      cout << 1 << endl;
    else
      cout << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t;
  cin >> t;
  while (t--) solve();
  return 0;
}
