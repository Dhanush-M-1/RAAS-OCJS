#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long int n;
  cin >> n;
  long long int tmp = n;
  if (n == 1) {
    cout << 1 << '\n' << 0;
    return 0;
  }
  long long int d = 3;
  int cnt = 0;
  vector<pair<long long int, int> > prime_div;
  if (n % 2 == 0) {
    while (n % 2 == 0) {
      cnt++;
      n >>= 1;
    }
    prime_div.push_back({2, cnt});
    cnt = 0;
  }
  for (; d * d <= n; d += 2) {
    if (n % d == 0) {
      while (n % d == 0) {
        cnt++;
        n /= d;
      }
      prime_div.push_back({d, cnt});
      cnt = 0;
    }
  }
  if (n > 2) prime_div.push_back({n, 1});
  if (prime_div.size() == 1) {
    if (prime_div[0].second == 2)
      cout << 2;
    else {
      cout << 1 << '\n';
      if (prime_div[0].second == 1)
        cout << 0;
      else {
        long long int p = prime_div[0].first;
        cout << p * 1ll * p;
      }
    }
  } else {
    long long int ans = 1;
    ans = prime_div[0].first * 1ll * prime_div[1].first;
    if (ans == tmp)
      cout << 2;
    else
      cout << 1 << '\n' << ans;
  }
  return 0;
}
