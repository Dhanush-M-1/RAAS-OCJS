#include <bits/stdc++.h>
using namespace std;
const long long infl = 1e18 + 5;
long long int m, n, p, q, x, y, cn, k, tmp1, tmp, mx = 0, mn, f, val, sz, sm,
                                                  cntt, ans, t = 1, i, j;
long long int cnt[4123456];
vector<int> v;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  if (fopen("inp.txt", "r")) {
    freopen("myfile.txt", "w", stdout);
    freopen("inp.txt", "r", stdin);
  }
  cin >> n;
  val = sqrt(n);
  for (i = 2; i < val + 1; i++) {
    while (n % i == 0) {
      n = n / i;
      cnt[i]++;
      v.push_back(i);
    }
  }
  if (n > 1) {
    if (n < 4123456) cnt[n]++;
    v.push_back(n);
  }
  for (i = 0; i < 4123456; i++) {
    sm += cnt[i];
  }
  if (v.size() <= 1) {
    cout << "1 \n0";
    return 0;
  } else if (v.size() == 2) {
    cout << "2 \n";
  } else {
    cout << "1 \n";
    cout << v[0] * v[1];
  }
  return 0;
}
