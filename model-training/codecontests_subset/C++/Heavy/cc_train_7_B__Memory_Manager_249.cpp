#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m;
  cin >> t >> m;
  int a[101] = {};
  int counter = 1;
  char used[101] = {};
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int x;
      cin >> x;
      int start = -1, fin = -1;
      int cur = 0;
      for (int j = 0; j < m; j++) {
        if (a[j] == 0)
          cur++;
        else
          cur = 0;
        if (cur == x) {
          fin = j;
          start = j - x + 1;
          break;
        }
      }
      if (start == -1) {
        cout << "NULL" << endl;
      } else {
        for (int j = start; j <= fin; j++) {
          a[j] = counter;
        }
        used[counter] = true;
        cout << counter << endl;
        counter++;
      }
    }
    if (s == "erase") {
      int x;
      cin >> x;
      if (x < 0 || x > 100 || !used[x])
        puts("ILLEGAL_ERASE_ARGUMENT");
      else {
        used[x] = false;
        int start = -1, fin = -1;
        for (int j = 0; j < m; j++) {
          if (a[j] == x && start == -1) start = j;
          if (a[j] == x) fin = j;
        }
        for (int j = start; j <= fin; j++) {
          a[j] = 0;
        }
      }
    }
    if (s == "defragment") {
      int b[101] = {};
      int p = 0;
      for (int j = 0; j < m; j++) {
        if (a[j] != 0) {
          b[p++] = a[j];
        }
      }
      for (int j = 0; j < m; j++) {
        a[j] = b[j];
      }
    }
  }
  return 0;
}
