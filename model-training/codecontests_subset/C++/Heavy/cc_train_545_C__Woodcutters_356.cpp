#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005;
const int mod = 1e9 + 7;
bool comparator(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first == b.first)
    return a.second < b.second;
  else
    return a.first < b.first;
}
long long exp(long long a, long long b) {
  long long ans = 1;
  while (b != 0) {
    if (b % 2) ans = ans * a;
    a = a * a;
    b /= 2;
  }
  return ans;
}
long long x[MAXN];
long long h[MAXN];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  for (long long i = (long long)0; i < (long long)n; i++) {
    cin >> x[i] >> h[i];
  }
  long long ans = 0;
  if (n == 1)
    ans++;
  else
    ans += 2;
  long long pre = x[0];
  for (long long i = (long long)1; i < (long long)n - 1; i++) {
    if (x[i] - pre - 1 >= h[i]) {
      pre = x[i];
      ans++;
    } else if (x[i + 1] - x[i] - 1 >= h[i]) {
      ans++;
      pre = x[i] + h[i];
    } else {
      pre = x[i];
    }
  }
  cout << ans << endl;
  return 0;
}
