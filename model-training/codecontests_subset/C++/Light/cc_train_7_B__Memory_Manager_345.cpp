#include <bits/stdc++.h>
using namespace std;
int mem[128];
int main() {
  int n, m, cnt = 0;
  cin >> n >> m;
  fill(mem, mem + m, 0);
  string s;
  for (int i = 0; i < n; i++) {
    cin >> s;
    if (s == "alloc") {
      int len;
      cin >> len;
      int ok = -1;
      for (int j = 0; j < m; j++) {
        if (mem[j] != 0) continue;
        for (int k = 0; k < len; k++)
          if (j + k >= m || mem[j + k] != 0) goto end;
        ok = j;
        break;
      end:;
      }
      if (ok == -1)
        cout << "NULL" << endl;
      else {
        cnt++;
        cout << cnt << endl;
        mem[ok] = cnt;
        for (int j = 1; j < len; j++) mem[ok + j] = -1;
      }
    } else if (s == "erase") {
      int num, ok = -1;
      cin >> num;
      for (int j = 0; j < m; j++)
        if (num == mem[j]) {
          ok = j;
          break;
        }
      if (ok == -1 || num <= 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      } else {
        do {
          mem[ok] = 0;
          ok += 1;
        } while (ok < m && mem[ok] == -1);
      }
    } else {
      int k = 0;
      for (int j = 0; j < m; j++)
        if (mem[j] != 0) mem[k++] = mem[j];
      for (int j = k; j < m; j++) mem[j] = 0;
    }
  }
}
