#include <bits/stdc++.h>
using namespace std;
template <typename Arg1>
void __f(const char *name, Arg1 &&arg1) {
  cerr << name << " : " << arg1 << endl;
}
template <typename Arg1, typename... Args>
void __f(const char *names, Arg1 &&arg1, Args &&...args) {
  const char *comma = strchr(names + 1, ',');
  cerr.write(names, comma - names) << " : " << arg1 << " | ";
  __f(comma + 1, args...);
}
long long int power(long long int a, long long int b) {
  if (b == 0) return 1;
  if (b % 2 == 0) return (power((a * a) % 998244353, b / 2)) % 998244353;
  return (a * (power((a * a) % 998244353, b / 2)) % 998244353) % 998244353;
}
long long int modInv(long long int n) { return power(n, 1000000007 - 2); }
long long int nCr(long long int n, long long int r,
                  long long int p = 1000000007) {
  if (r == 0) return 1;
  long long int Fact[n + 1];
  Fact[0] = 1;
  for (long long int i = 1; i <= n; i++) {
    Fact[i] = (Fact[i - 1] * i) % p;
  }
  return (((Fact[n] * modInv(Fact[r])) % 1000000007) *
          (modInv(Fact[n - r]) % 1000000007)) %
         1000000007;
}
double PI = 3.14159265359;
void solve() {
  long long int n, i;
  cin >> n;
  string S[n];
  for (i = 0; i < n; i++) cin >> S[i];
  vector<pair<long long int, long long int> > Ans;
  if (S[0][1] == S[1][0]) {
    if (S[n - 2][n - 1] == S[0][1]) {
      Ans.push_back({n - 1, n});
    }
    if (S[n - 1][n - 2] == S[0][1]) {
      Ans.push_back({n, n - 1});
    }
  } else if (S[n - 1][n - 2] == S[n - 2][n - 1]) {
    if (S[n - 2][n - 1] == S[0][1]) {
      Ans.push_back({1, 2});
    }
    if (S[n - 1][n - 2] == S[1][0]) {
      Ans.push_back({2, 1});
    }
  } else {
    if (S[0][1] == '0') {
      Ans.push_back({1, 2});
    } else {
      Ans.push_back({2, 1});
    }
    if (S[n - 1][n - 2] == '1') {
      Ans.push_back({n, n - 1});
    } else {
      Ans.push_back({n - 1, n});
    }
  }
  cout << Ans.size() << endl;
  for (i = 0; i < Ans.size(); i++) {
    cout << Ans[i].first << " " << Ans[i].second << endl;
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  cin >> t;
  for (long long int i = 1; i <= t; i++) {
    solve();
  }
}
