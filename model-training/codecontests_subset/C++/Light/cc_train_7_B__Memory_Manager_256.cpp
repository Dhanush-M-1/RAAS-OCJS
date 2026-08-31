#include <bits/stdc++.h>
using namespace std;
static const double EPS = 1e-5;
int main(void) {
  int t, m;
  int i, j, k;
  int count = 0;
  int mem[100];
  memset(mem, 0, sizeof(mem));
  cin >> t;
  cin >> m;
  for (i = 1; i <= t; i++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int n;
      int fnum = 0;
      cin >> n;
      for (j = 0; j < m; j++) {
        if (mem[j] == 0) {
          fnum++;
          if (fnum == n) break;
        } else
          fnum = 0;
      }
      if (fnum == n) {
        count++;
        for (k = (j - n + 1); k <= j; k++) {
          mem[k] = count;
        }
        cout << count << endl;
      } else {
        cout << "NULL" << endl;
      }
    } else if (s == "erase") {
      int n;
      cin >> n;
      int ecount = 0;
      if (n > 0) {
        for (j = 0; j < m; j++) {
          if (mem[j] == n) {
            mem[j] = 0;
            ecount++;
          }
        }
      }
      if (ecount == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else if (s == "defragment") {
      int n;
      int p = 0;
      for (j = 0; j < m; j++) {
        if (mem[j] != 0) {
          mem[p] = mem[j];
          p++;
        }
      }
      for (j = p; j < m; j++) {
        mem[j] = 0;
      }
    }
  }
  return 0;
}
