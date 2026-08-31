#include <bits/stdc++.h>
using namespace std;
int t, m, ord;
string s;
int n;
int mm[110];
int alloc(int mem) {
  int i, j;
  for (i = 0; i <= m - mem; i++) {
    for (j = i; j < i + mem; j++)
      if (mm[j] != 0) break;
    if (j == i + mem) {
      ord++;
      for (j = i + mem - 1; j >= i; j--) mm[j] = ord;
      return ord;
    }
  }
  return -1;
}
int erase(int num) {
  bool f = 0;
  for (int i = 0; i < m; i++) {
    if (mm[i] == num) {
      f = 1;
      mm[i] = 0;
    }
  }
  if (f) return 1;
  return -1;
}
void defragment() {
  int nw[110];
  int np = 0;
  memset(nw, 0, sizeof(nw));
  for (int i = 0; i < m; i++) {
    if (mm[i] != 0) nw[np++] = mm[i];
    mm[i] = 0;
  }
  for (int i = 0; i < np; i++) mm[i] = nw[i];
}
int main() {
  cin >> t >> m;
  for (int i = 0; i < t; i++) {
    cin >> s;
    if (s == "alloc") {
      cin >> n;
      int y = alloc(n);
      if (y == -1)
        cout << "NULL" << endl;
      else
        cout << y << endl;
    }
    if (s == "erase") {
      cin >> n;
      int y = erase(n);
      if (y == -1 || n <= 0) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    }
    if (s == "defragment") {
      defragment();
    }
  }
  return 0;
}
