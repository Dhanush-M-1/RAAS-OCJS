#include <bits/stdc++.h>
using namespace std;
char s[105];
int main() {
  int n;
  cin >> n;
  cin >> s;
  int cnt = 0;
  for (int i = 0; i < n; i++) {
    if (s[i] == '8') cnt++;
  }
  int ans = min(cnt, n / 11);
  cout << ans << endl;
  return 0;
}
