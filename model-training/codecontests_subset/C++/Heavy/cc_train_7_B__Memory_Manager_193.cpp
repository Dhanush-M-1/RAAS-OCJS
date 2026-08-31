#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
const long long LIM = 1e18;
const int INF = 0x3f3f3f3f;
const double eps = 1e-4;
const double PI = atan(1.0) * 4;
const int mod = 1e9 + 7;
int t, m, x, tot;
int mem[105], tmp[105];
char s[33];
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  ;
  cin >> t >> m;
  while (t--) {
    cin >> s;
    if (s[0] == 'd') {
      memset(tmp, 0, sizeof(tmp));
      int p = 0;
      for (int i = 1; i <= m; i++)
        if (mem[i]) tmp[++p] = mem[i];
      memcpy(mem, tmp, sizeof(tmp));
    } else if (s[0] == 'a') {
      cin >> x;
      int con = 0, f = 0;
      for (int i = 1; i <= m; i++)
        if (mem[i])
          con = 0;
        else {
          con++;
          if (con == x) {
            ++tot;
            f = 1;
            for (; x; i--, x--) mem[i] = tot;
            break;
          }
        }
      if (f)
        cout << tot << "\n";
      else
        cout << "NULL\n";
    } else {
      cin >> x;
      int f = 0;
      for (int i = 1; i <= m; i++)
        if (mem[i] == x) {
          mem[i] = 0;
          f = 1;
        }
      if (!f || x <= 0) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    }
  }
  return 0;
}
