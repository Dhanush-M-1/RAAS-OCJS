#include <bits/stdc++.h>
bool debug = false;
using namespace std;
int a[400], s[400], n, m;
bool occupied[400];
void push(int position, int identifier) {
  occupied[position] = true;
  a[position] = identifier;
}
void pop(int position) {
  occupied[position] = false;
  a[position] = 0;
}
int main() {
  cin >> n >> m;
  int identifier = 0, size, x;
  string p;
  s[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> p;
    if (p == "alloc") {
      cin >> size;
      if (size > m) {
        cout << "NULL" << endl;
        continue;
      }
      for (int j = 1; j <= m; j++)
        if (occupied[j])
          s[j] = s[j - 1] + 1;
        else
          s[j] = s[j - 1];
      bool ok = true;
      for (int j = 1; j <= m - size + 1; j++)
        if (s[j + size - 1] - s[j - 1] == 0) {
          ok = false;
          for (int t = j; t <= j + size - 1; t++) push(t, identifier + 1);
          break;
        }
      if (ok)
        cout << "NULL" << endl;
      else {
        identifier++;
        cout << identifier << endl;
      }
    } else if (p == "erase") {
      cin >> x;
      bool ok = true;
      if (x <= 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        continue;
      }
      for (int j = 1; j <= m; j++)
        if (a[j] == x) {
          ok = false;
          pop(j);
        }
      if (ok) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      int i = 1, j = 1;
      while (j <= m) {
        if (a[j] != 0) {
          int key = a[j];
          pop(j);
          push(i, key);
          i++;
        }
        j++;
      }
    }
  }
  return 0;
}
