#include <bits/stdc++.h>
using namespace std;
const long long MaxN = 2E5 + 10;
const long double eps = 1E-8;
const long long INF = 1E9 + 7;
const long long MOD = 1000 * 1000 * 1000 + 7;
vector<char> pm;
vector<long long> num;
long long bpow(long long n, long long k) {
  if (k == 0) return 1;
  long long cnt = bpow(n, k / 2);
  if (k % 2 == 0)
    return (cnt * cnt) % MOD;
  else
    return (n * cnt * cnt) % MOD;
}
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie();
  cout.tie();
  cout << fixed << setprecision(12);
  string s;
  getline(cin, s);
  pm.push_back('+');
  for (long long i = 0; i < s.size(); ++i)
    if (s[i] == '-' || s[i] == '+') pm.push_back(s[i]);
  long long ind = s.size() - 1;
  while (s[ind] >= '0' && s[ind] <= '9') {
    num.push_back(s[ind] - '0');
    --ind;
  }
  reverse(num.begin(), num.end());
  long long n = 0;
  for (long long i = 0; i < num.size(); ++i) {
    n *= 10;
    n += num[i];
  }
  num.clear();
  long long cnt = 0;
  for (long long i = 0; i < pm.size(); ++i) {
    if (pm[i] == '+') {
      cnt += n;
      num.push_back(n);
    } else {
      --cnt;
      num.push_back(1);
    }
  }
  if (cnt < n) {
    cout << "Impossible";
    return 0;
  }
  cnt -= n;
  for (long long i = 0; i < num.size(); ++i) {
    if (pm[i] == '+') {
      long long x = min(cnt, num[i] - 1);
      num[i] -= x;
      cnt -= x;
    } else {
      long long x = min(cnt, n - num[i]);
      num[i] += x;
      cnt -= x;
    }
  }
  if (cnt) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible" << endl << num[0] << " ";
  for (long long i = 1; i < num.size(); ++i)
    cout << pm[i] << " " << num[i] << " ";
  cout << "= " << n;
}
