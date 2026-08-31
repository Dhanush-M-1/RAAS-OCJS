#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const int M = 1e5 + 7;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  while (T--) {
    long long n, l, r, f = 0;
    cin >> n >> l >> r;
    l--;
    if (r == n * (n - 1) + 1) r--, f = 1;
    long long nl = (n - 1) * 2, nr = (n - 1) * 2;
    while (l >= nl && nl) l -= nl, nl -= 2;
    while (r >= nr && nr) r -= nr, nr -= 2;
    while (nl >= nr && nl) {
      long long tp = n - (nl / 2);
      long long nm = 0;
      vector<long long> v;
      for (long long i = tp + 1; i <= n; i++) v.push_back(tp), v.push_back(i);
      if (nl == nr)
        for (int i = l; i < r; i++) cout << v[i] << " ";
      else {
        for (int i = l; i < v.size(); i++) cout << v[i] << " ";
        l = 0;
      }
      nl -= 2;
    }
    if (f) cout << 1;
    cout << endl;
  }
  return 0;
}
