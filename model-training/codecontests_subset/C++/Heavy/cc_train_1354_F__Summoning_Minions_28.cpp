#include <bits/stdc++.h>
using namespace std;
long long mod = 998244353;
long long powmod(long long a, long long b) {
  long long res = 1;
  a %= mod;
  assert(b >= 0);
  for (; b; b >>= 1) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
  }
  return res;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
double PI = 3.14159265358979323846;
long double e = 2.71828182845904523536028747135266249775724709369995;
long long fill(vector<pair<pair<long long, long long>, long long> > &v,
               vector<vector<long long> > &dp, long long idx, long long k,
               long long n, long long realn) {
  assert(idx >= 0 && k >= 0);
  if (dp[idx][k] != -1) return dp[idx][k];
  if (idx + 1 == k) {
    if (idx == 0) {
      dp[idx][k] = v[idx].first.second;
      return dp[idx][k];
    }
    dp[idx][k] = v[idx].first.second + v[idx].first.first * (n) +
                 fill(v, dp, idx - 1, k - 1, n - 1, realn);
    return dp[idx][k];
  }
  if (k == 0) {
    if (idx == 0) {
      dp[idx][k] = v[idx].first.first * (realn - 1);
      return dp[idx][k];
    }
    long long a = fill(v, dp, idx - 1, k, n, realn);
    dp[idx][k] = a + v[idx].first.first * (realn - 1);
    return dp[idx][k];
  }
  long long a =
      fill(v, dp, idx - 1, k, n, realn) + v[idx].first.first * (realn - 1);
  long long b = fill(v, dp, idx - 1, k - 1, n - 1, realn) +
                v[idx].first.second + v[idx].first.first * (n);
  dp[idx][k] = max(a, b);
  return dp[idx][k];
}
void solve() {
  long long k, n;
  cin >> n >> k;
  vector<pair<pair<long long, long long>, long long> > v(n);
  for (long long i = 0; i < n; i++) {
    cin >> v[i].first.second >> v[i].first.first;
    v[i].second = i + 1;
  }
  sort(v.begin(), v.end());
  vector<vector<long long> > dp(n, vector<long long>(k + 1, -1));
  fill(v, dp, n - 1, k, k - 1, k);
  vector<long long> choose;
  long long cnt = 0;
  for (long long i = n - 1; i >= 0; i--) {
    if (cnt == k) break;
    if (i == 0) {
      choose.push_back(i);
      cnt++;
      break;
    }
    if (dp[i][k - cnt] == dp[i - 1][k - cnt - 1] +
                              (k - 1 - cnt) * v[i].first.first +
                              v[i].first.second) {
      cnt++;
      choose.push_back(i);
    } else {
      continue;
    }
  }
  assert(cnt == k);
  cout << 2 * n - k << endl;
  set<long long> s;
  for (long long i = cnt - 1; i >= 1; i--) {
    cout << v[choose[i]].second << " ";
    s.insert(v[choose[i]].second);
  }
  for (long long i = 1; i <= n; i++) {
    if (s.find(i) == s.end() && i != v[choose[0]].second)
      cout << i << " " << -i << " ";
  }
  cout << v[choose[0]].second << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.precision(20);
  int t = 1;
  cin >> t;
  for (int i = 0; i < t; i++) {
    solve();
  }
  return 0;
}
