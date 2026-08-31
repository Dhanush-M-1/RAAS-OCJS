#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long int a, i;
  long long int ar[26] = {0};
  string s, ans;
  cin >> a;
  cin >> s;
  for (i = 0; i < s.size(); i++) {
    long long int d = s[i] - 97;
    ar[d]++;
  }
  bool ch = 1;
  for (i = 0; i < 26; i++) {
    if (ar[i] % a == 0)
      ar[i] /= a;
    else
      ch = 0;
  }
  if (ch == 0)
    cout << -1 << endl;
  else {
    long long int j, k;
    for (j = 0; j < a; j++) {
      for (i = 0; i < 26; i++) {
        for (k = 0; k < ar[i]; k++) ans += (i + 97);
      }
    }
    cout << ans << endl;
  }
  return 0;
}
