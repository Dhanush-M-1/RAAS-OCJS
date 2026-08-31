#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  string s;
  while (cin >> n) {
    cin >> s;
    int cnt8 = 0;
    for (int i = 0; i < n; i++)
      if (s[i] == '8') cnt8++;
    int n8 = n - cnt8;
    int ans = min(n / 11, cnt8);
    cout << ans << endl;
  }
  return 0;
}
