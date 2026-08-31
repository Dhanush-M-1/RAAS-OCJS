#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  string Str1, StrTmp;
  int n;
  while (cin >> n >> Str1) {
    int n8 = 0, nx = 0, n_pair = 0, ans = 0;
    for (int i = 0; i < n; i++) {
      if (Str1[i] == '8') ++n8;
    }
    n_pair = n / 11;
    if (n_pair <= n8)
      ans = n_pair;
    else if (n8 <= n_pair && n8 != 0)
      ans = n8;
    if (n8 == 0) {
      ans = 0;
    }
    cout << ans << endl;
  }
  return 0;
}
