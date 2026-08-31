#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int isPrime(int n) {
  if (n < 2) return 0;
  if (n < 4) return 1;
  if (n % 2 == 0 or n % 3 == 0) return 0;
  for (int i = 5; i * i <= n; i += 6)
    if (n % i == 0 or n % (i + 2) == 0) return 0;
  return 1;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int64_t n, i, k;
  int64_t ans = 0;
  cin >> n >> k;
  vector<int64_t> a, b, c;
  for (i = 0; i < n; i++) {
    int64_t t1, t2, t3;
    cin >> t1 >> t2 >> t3;
    if (t3 and t2) {
      c.push_back(t1);
    } else if (t2) {
      a.push_back(t1);
    } else if (t3) {
      b.push_back(t1);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  if ((a.size() + c.size()) < k or (b.size() + c.size()) < k) {
    cout << -1 << "\n";
    return 0;
  }
  if (a.size() >= k and b.size() >= k) {
    int64_t ind = 0, j = 0;
    for (i = 0; i < k; i++) {
      ans = ans + a[i] + b[i];
    }
    int64_t temp = ans;
    for (i = 0; i < min(k, (int64_t)c.size()); i++) {
      temp = temp - a[k - i - 1] - b[k - i - 1];
      temp = temp + c[i];
      ans = min(ans, temp);
    }
    cout << ans << "\n";
  } else {
    int64_t ind = min(a.size(), b.size());
    for (i = 0; i < ind; i++) {
      ans = ans + a[i] + b[i];
    }
    for (i = 0; i < k - ind; i++) {
      ans += c[i];
    }
    int64_t temp = ans;
    for (i = k - ind; i < min(k, (int64_t)c.size()); i++) {
      temp = temp - a[ind - (i - k + ind) - 1] - b[ind - (i - k + ind) - 1];
      temp = temp + c[i];
      ans = min(ans, temp);
    }
    cout << ans << "\n";
  }
  return 0;
}
