#include <bits/stdc++.h>
using namespace std;
const int N = (int)(1e5 + 10);
bool isPowerOfTwo(long long int x) { return x && (!(x & (x - 1))); }
void solve() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int cnte = 0;
  for (int i = 0; i < n; i++) s[i] == '8' ? ++cnte : cnte;
  if (cnte == 0) {
    cout << 0 << endl;
    return;
  } else {
    int div = n / 11;
    cout << min(cnte, div) << endl;
    return;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
