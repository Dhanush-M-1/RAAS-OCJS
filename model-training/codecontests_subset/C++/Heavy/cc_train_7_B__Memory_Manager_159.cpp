#include <bits/stdc++.h>
using namespace std;
int mem[200];
int mt[200];
int main() {
  memset(mem, 0, sizeof(mem));
  int t, m;
  cin >> t >> m;
  int cnt = 1;
  for (int it = 0; it < t; it++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int n;
      cin >> n;
      int ind = -1;
      for (int i = 0; i + n <= m; i++) {
        bool ok = true;
        for (int j = 0; j < n; j++)
          if (mem[i + j]) {
            ok = false;
            break;
          }
        if (ok) {
          ind = i;
          break;
        }
      }
      if (ind == -1) {
        cout << "NULL\n";
        continue;
      }
      for (int i = 0; i < n; i++) mem[ind + i] = cnt;
      cout << cnt << endl;
      cnt++;
    } else if (s == "erase") {
      int x;
      cin >> x;
      if (x == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
        continue;
      }
      int tot = 0;
      for (int i = 0; i < m; i++)
        if (mem[i] == x) tot++, mem[i] = 0;
      if (!tot) cout << "ILLEGAL_ERASE_ARGUMENT\n";
    } else {
      memset(mt, 0, sizeof(mt));
      int w = 0;
      for (int i = 0; i < m; i++)
        if (mem[i]) mt[w++] = mem[i];
      memcpy(mem, mt, sizeof(mt));
    }
  }
  return 0;
}
