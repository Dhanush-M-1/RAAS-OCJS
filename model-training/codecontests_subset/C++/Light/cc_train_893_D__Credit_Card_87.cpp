#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1};
int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
long long gcd(long long a, long long b) { return !b ? a : gcd(b, a % b); }
long long lcm(long long a, long long b) { return (a / gcd(a, b)) * b; }
void PLAY() {
  cout << fixed << setprecision(4);
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
int main() {
  PLAY();
  long long n, d;
  cin >> n >> d;
  vector<long long> v(n), sum(n, 0);
  for (int i = 0; i < n; i++) {
    cin >> v[i];
    sum[i] = v[i];
  }
  for (int i = 1; i < n; i++) sum[i] += sum[i - 1];
  vector<long long> mx(n, 0);
  mx.back() = sum.back();
  for (int i = n - 2; i >= 0; i--) mx[i] = max(mx[i + 1], sum[i]);
  long long cur = 0, res = 0;
  for (int i = 0; i < n; i++) {
    if (sum[i] + cur > d) {
      cout << -1 << endl;
      return 0;
    }
    if (!v[i] && sum[i] + cur < 0) {
      long long tmp = d - mx[i] - cur;
      if (sum[i] + cur + tmp < 0) {
        cout << -1 << endl;
        return 0;
      }
      cur += tmp;
      res++;
    }
  }
  cout << res << endl;
  return 0;
}
