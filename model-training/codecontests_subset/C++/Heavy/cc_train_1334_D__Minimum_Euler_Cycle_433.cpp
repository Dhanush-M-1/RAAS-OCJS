#include <bits/stdc++.h>
using namespace std;
const long long INF = (long long)2e9;
const long long inf = (long long)2e18;
const long double eps = (long double)1e-8;
const long long mod = (long long)1e9 + 7;
const long long MAXN = (long long)1e5 + 1;
const long long MAXC = (long long)1e6 + 1;
const long long MAXE = (long long)1000;
const long long MAXLOG = 21;
const long long maxlen = (long long)1e5;
const long long asci = (long long)256;
const long long block = 480;
const long double PI = acos(-1);
const long double e = 2.7182818284;
template <class T>
istream &operator>>(istream &in, vector<T> &arr) {
  for (T &cnt : arr) {
    in >> cnt;
  }
  return in;
};
void solve() {
  long long n, l, r;
  cin >> n >> l >> r;
  l--, r--;
  vector<long long> a;
  long long i = 0;
  for (; i < n - 1; ++i) {
    if (l >= 2 * (n - i - 1))
      l -= 2 * (n - i - 1), r -= 2 * (n - i - 1);
    else
      break;
  }
  while (a.size() <= r && i < n) {
    for (long long j = i + 1; j < n; ++j) {
      a.push_back(i);
      a.push_back(j);
    }
    ++i;
  }
  if (i == n) a.push_back(0);
  for (; l <= r; ++l) {
    cout << a[l] + 1 << " ";
  }
  cout << "\n";
}
int main() {
  srand(time(0));
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cout.precision(30);
  long long t;
  cin >> t;
  while (t--) solve();
  return 0;
}
