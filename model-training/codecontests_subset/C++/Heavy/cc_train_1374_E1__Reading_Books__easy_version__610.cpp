#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, k, i, ok, s = 0, sum = 0, ans = 0;
  multiset<long long> pi1;
  vector<long long> pi2, pi3;
  multimap<long long, long long>::iterator it;
  cin >> n >> ok;
  long long a, b, c;
  for (i = 0; i < n; i++) {
    cin >> a >> b >> c;
    if (b == 1 && c == 1) {
      pi1.insert(a);
      s++;
      sum++;
    } else if (b == 1) {
      pi2.push_back(a);
      s++;
    } else if (c == 1) {
      pi3.push_back(a);
      sum++;
    }
  }
  sort(pi2.begin(), pi2.end());
  sort(pi3.begin(), pi3.end());
  long long l = min(pi2.size(), pi3.size());
  if (s < ok || sum < ok)
    cout << "-1" << endl;
  else {
    for (i = 0; i < l; i++) {
      pi1.insert(pi2[i] + pi3[i]);
    }
    long long ans1 = 0;
    for (auto kk : pi1) {
      ans1 += kk;
      ok--;
      if (ok == 0) break;
    }
    cout << ans1 << endl;
  }
}
