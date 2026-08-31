#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int M = 25;
const int mod = 1e9 + 7;
const double eps = 1e-8;
const double Pi = 2 * acos(0.0);
inline int max(int a, int b) { return a > b ? a : b; }
inline int min(int a, int b) { return a < b ? a : b; }
inline int bit(int x) { return 1 << x; }
inline int abs(int x) { return x > 0 ? x : (-x); }
int n;
char s[55];
int main() {
  ios::sync_with_stdio(0);
  cin >> s >> n;
  for (int i = 0; s[i]; i++) {
    if (s[i] >= 'a')
      s[i] -= 'a';
    else
      s[i] -= 'A';
    if (s[i] < n) {
      s[i] += 'A';
    } else
      s[i] += 'a';
  }
  cout << s << endl;
  return 0;
}
