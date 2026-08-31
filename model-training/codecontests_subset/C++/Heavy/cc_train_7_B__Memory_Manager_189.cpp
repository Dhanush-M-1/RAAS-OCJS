#include <bits/stdc++.h>
using namespace std;
int used[1000];
int n, t, x, id = 1;
string s;
bool free(int l, int r) {
  bool ok = 1;
  for (int i = l; i < r; i++)
    if (used[i] != 0) ok = 0;
  return ok;
}
int main() {
  cin >> t >> n;
  for (int i = 0; i < t; i++) {
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      bool ok = 0;
      for (int j = 0; j <= n - x; j++)
        if (free(j, j + x)) {
          ok = 1;
          for (int l = j; l < j + x; l++) {
            used[l] = id;
          }
          break;
        }
      if (!ok)
        puts("NULL");
      else {
        cout << id << endl;
        id++;
      }
    } else if (s == "erase") {
      cin >> x;
      bool ok = 0;
      for (int j = 0; j < n; j++) {
        if (used[j] == x && x > 0) {
          ok = 1;
          used[j] = 0;
        }
      }
      if (ok == 0) {
        puts("ILLEGAL_ERASE_ARGUMENT");
      }
    } else {
      int t = 0;
      int i = 0;
      while (i < n) {
        if (used[i] != 0) {
          int k = used[i], ii = i;
          while (i < n && used[i] == k) i++;
          for (int j = ii; j < i; j++) {
            used[t++] = k;
          }
        } else
          i++;
      }
      for (i = t; i < n; i++) used[i] = 0;
    }
  }
  return 0;
}
