#include <bits/stdc++.h>
using namespace std;
using DO = double;
using INT = long long;
using pii = pair<int, int>;
using pi3 = pair<pii, int>;
template <typename T, typename U>
inline void smin(T &a, const U &b) {
  if (a > b) a = b;
}
template <typename T, typename U>
inline void smax(T &a, const U &b) {
  if (a < b) a = b;
}
int power(int a, int b, int mod, int ans = 1) {
  for (; b; b >>= 1, a = 1LL * a * a % mod)
    if (b & 1) ans = 1LL * ans * a % mod;
  return ans;
}
char str[11];
char s[111][11];
int n;
int main() {
  cin >> str;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> s[i];
  for (int i = 1; i <= n; i++)
    if (s[i][0] == str[0] and s[i][1] == str[1]) return puts("YES");
  int flag0 = 0, flag1 = 0;
  for (int i = 1; i <= n; i++) {
    if (s[i][1] == str[0]) flag0 = 1;
    if (s[i][0] == str[1]) flag1 = 1;
  }
  if (flag0 & flag1) return puts("YES");
  puts("NO");
  return 0;
}
