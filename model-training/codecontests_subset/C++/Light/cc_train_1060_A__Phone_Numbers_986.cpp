#include <bits/stdc++.h>
using namespace std;
int n, ans;
char str[1000];
int main() {
  while (cin >> n) {
    cin >> str;
    ans = 0;
    for (int i = 0; i < n; ++i)
      if (str[i] == '8') ans++;
    ans = min(ans, n / 11);
    cout << ans << endl;
  }
  return 0;
}
