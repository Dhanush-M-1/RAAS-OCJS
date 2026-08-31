#include <bits/stdc++.h>
using namespace std;
template <typename T>
T gcd(T a, T b) {
  if (!b) return a;
  return gcd(b, a % b);
}
template <typename T>
T lcm(T a, T b) {
  return a * b / gcd(a, b);
}
int i, k, ct[26];
string s, ans = "";
int main(void) {
  cin >> k >> s;
  memset(ct, 0, sizeof(ct));
  for (i = 0; i < (s.size()); i++) ct[s[i] - 'a'] += 1;
  bool ok = s.size() % k == 0;
  for (i = 0; i < (26); i++) {
    if (ct[i] != 0 && ct[i] % k != 0) {
      ok = false;
      break;
    } else if (ct[i] != 0 && ct[i] % k == 0) {
      for (int j = 0; j < ct[i] / k; j++) {
        ans += 'a' + i;
      }
    }
  }
  if (ok) {
    for (i = 0; i < (k); i++) {
      cout << ans;
    }
    cout << "\n";
  } else {
    cout << -1 << "\n";
  }
  return 0;
}
