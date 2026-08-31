#include <bits/stdc++.h>
using namespace std;
const int Maxn = 112;
int mem[Maxn];
int main() {
  string str;
  int n, m, t, idx = 1;
  cin >> n >> m;
  while (n--) {
    cin >> str;
    if (str[0] == 'a') {
      cin >> t;
      bool done = false;
      for (int i = 1; i <= m; i++)
        if (!mem[i] && i + t - 1 <= m) {
          bool flags = true;
          for (int j = i; j <= i + t - 1; j++)
            if (mem[j]) {
              flags = false;
              break;
            }
          if (flags) {
            for (int j = i; j <= i + t - 1; j++) mem[j] = idx;
            done = true;
            cout << idx++ << endl;
            break;
          }
        }
      if (!done) cout << "NULL\n";
    } else if (str[0] == 'e') {
      cin >> t;
      bool flags = false;
      for (int i = 1; i <= m; i++)
        if (mem[i] == t) {
          mem[i] = 0;
          flags = true;
        }
      if (t == 0 || !flags) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    } else if (str[0] == 'd') {
      int tmp[Maxn];
      memcpy(tmp, mem, sizeof(mem));
      memset(mem, 0, sizeof(mem));
      for (int i = 1, j = 1; i <= m && j <= m; i++)
        if (tmp[i]) {
          mem[j] = tmp[i];
          j++;
        }
    }
  }
  return 0;
}
