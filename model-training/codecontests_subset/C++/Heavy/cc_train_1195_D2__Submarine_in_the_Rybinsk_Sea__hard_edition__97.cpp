#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;
const long long INF = 1e18;
const double EPS = 1e-6;
const int MAX_N = 1e5 + 5;
long long fastExpo(int base, int e) {
  long long ans = 1;
  while (e != 0) {
    if (e % 2 == 1) ans = (long long)ans * base % MOD;
    base = (long long)base * base % MOD;
    e /= 2;
  }
  return ans;
}
namespace modOp {
int add(int a, int b, int mod = MOD) { return (a + b) % mod; }
void ADD(int& a, int b, int mod = MOD) { a = (a + b) % mod; }
int sub(int a, int b, int mod = MOD) { return (a - b + mod) % mod; }
void SUB(int& a, int b, int mod = MOD) { a = (a - b + mod) % mod; }
int mul(int a, int b, int mod = MOD) { return (long long)a * b % mod; }
void MUL(int& a, int b, int mod = MOD) { a = (long long)a * b % mod; }
int divide(int a, int b, int mod = MOD) {
  return (long long)a * fastExpo(b, mod - 2) % mod;
}
void DIVIDE(int& a, int b, int mod = MOD) {
  a = (long long)a * fastExpo(b, mod - 2) % mod;
}
}  // namespace modOp
using namespace modOp;
int n;
string a[MAX_N];
int freq[11];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    ++freq[a[i].size()];
    reverse(a[i].begin(), a[i].end());
  }
  int ans = 0, ans2 = 0;
  for (int i = 0; i < n; ++i) {
    for (int j = 1; j <= a[i].size(); ++j) {
      int total = 0, total2 = 0;
      for (int k = 1; k <= j; ++k) {
        ADD(total, mul(a[i][k - 1] - '0', fastExpo(10, k * 2 - 1)));
        ADD(total2, mul(a[i][k - 1] - '0', fastExpo(10, k * 2 - 2)));
      }
      for (int k = j + 1, power = j * 2; k <= a[i].size(); ++k, ++power) {
        ADD(total, mul(a[i][k - 1] - '0', fastExpo(10, power)));
        ADD(total2, mul(a[i][k - 1] - '0', fastExpo(10, power)));
      }
      MUL(total, freq[j]);
      MUL(total2, freq[j]);
      ADD(ans, total);
      ADD(ans2, total2);
    }
    for (int j = a[i].size() + 1; j <= 10; ++j) {
      int total = 0, total2 = 0;
      for (int k = 1; k <= a[i].size(); ++k) {
        ADD(total, mul(a[i][k - 1] - '0', fastExpo(10, k * 2 - 1)));
        ADD(total, mul(a[i][k - 1] - '0', fastExpo(10, k * 2 - 2)));
      }
      MUL(total, freq[j]);
      MUL(total2, freq[j]);
      ADD(ans, total);
      ADD(ans2, total2);
    }
  }
  cout << add(ans, ans2) << '\n';
  return 0;
}
