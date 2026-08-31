#include <bits/stdc++.h>
using namespace std;
int n, res1, res2;
int f[100001];
int s[100001];
int t[100001];
void solve() {
  int sumf = 0, sums = 0, sumt = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> f[i];
    sumf += f[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> s[i];
    sums += s[i];
  }
  res1 = sumf - sums;
  for (int i = 0; i < n - 2; i++) {
    cin >> t[i];
    sumt += t[i];
  }
  res2 = sums - sumt;
  cout << res1 << "\n" << res2 << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  solve();
  return 0;
}
