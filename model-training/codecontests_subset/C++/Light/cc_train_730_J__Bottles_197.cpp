#include <bits/stdc++.h>
using namespace std;
const long double PI = 3.141592653589793238462643383279;
const long double EPS = 1e-7;
const long long INF = 1e9 + 7;
const long long MOD = INF;
const long long maxn = 2e5 + 1;
int a[101];
int b[101];
pair<int, int> dp[101][20001];
bool used[101][20001];
pair<int, int> calc(int i, int capac) {
  if (!i) {
    if (capac <= 10000) return make_pair(0, 0);
    return make_pair(1e9, 0);
  }
  if (used[i][capac]) return dp[i][capac];
  used[i][capac] = true;
  pair<int, int> p1, p2;
  p1 = calc(i - 1, capac - (b[i] - a[i]));
  p1.first += 1;
  p2 = calc(i - 1, capac + a[i]);
  p2.second += a[i];
  return dp[i][capac] = min(p1, p2);
}
int main() {
  int n;
  cin >> n;
  for (long long i = 1; i < n + 1; ++i) cin >> a[i];
  for (long long i = 1; i < n + 1; ++i) cin >> b[i];
  pair<int, int> res = calc(n, 10000);
  cout << res.first << " " << res.second;
}
