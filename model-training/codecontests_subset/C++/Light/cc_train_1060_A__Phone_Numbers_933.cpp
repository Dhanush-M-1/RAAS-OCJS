#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  const int sz = 11;
  const char start = '8';
  int n;
  string s;
  cin >> n >> s;
  int cnt = n, cntStart = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == start) {
      cntStart++;
    }
  }
  long long ans = 0;
  while (cntStart > 0 && cnt >= sz) {
    cntStart--;
    cnt -= sz;
    ans++;
  }
  cout << ans << endl;
}
