#include <bits/stdc++.h>
using namespace std;
void NITRO() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
const int N = 1e+4 * 5 + 55;
const int MOD = 1e+9 + 7;
const long long INF = 1e+18;
void SOLVE() {
  int n, ei = 0;
  string word;
  cin >> n >> word;
  for (int i = 0; i < n; i++) {
    if (word[i] == '8') ei++;
  }
  cout << min(n / 11, ei);
}
int main() {
  NITRO();
  SOLVE();
  return 0;
}
