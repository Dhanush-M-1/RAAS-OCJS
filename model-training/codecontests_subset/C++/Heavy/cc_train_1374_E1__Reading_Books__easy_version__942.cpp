#include <bits/stdc++.h>
using namespace std;
vector<int> a, b, c, tmp;
int main() {
  ios::sync_with_stdio(false);
  long long n, k;
  cin >> n >> k;
  for (long long i = 1; i <= n; i++) {
    long long a1, b1, t;
    cin >> t >> a1 >> b1;
    if (a1 == 1 && b1 == 1) {
      c.push_back(t);
    } else {
      if (a1) {
        a.push_back(t);
      }
      if (b1) {
        b.push_back(t);
      }
    }
  }
  sort(b.begin(), b.end());
  sort(a.begin(), a.end());
  for (long long i = 0; i < a.size() && i < b.size(); i++) {
    c.push_back(a[i] + b[i]);
  }
  if (c.size() < k)
    cout << -1 << "\n";
  else {
    sort(c.begin(), c.end());
    long long sum = 0;
    for (long long i = 0; i < k; i++) {
      sum += c[i];
    }
    cout << sum << "\n";
  }
}
