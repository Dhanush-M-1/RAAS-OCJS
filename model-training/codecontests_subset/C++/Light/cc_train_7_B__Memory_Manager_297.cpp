#include <bits/stdc++.h>
using namespace std;
int main() {
  int m, t;
  int a[100], b[100];
  bool used[100];
  while (cin >> t >> m) {
    string s;
    memset(a, 0, sizeof(a));
    memset(used, false, sizeof(used));
    int id = 1;
    while (t--) {
      cin >> s;
      if (s == "alloc") {
        int count = 0;
        int num = 0;
        int first = -1;
        cin >> num;
        for (int i = 0; i < m; i++) {
          if (a[i] == 0)
            count++;
          else
            count = 0;
          if (count == num) {
            first = i - num + 1;
            break;
          }
        }
        if (first == -1)
          puts("NULL");
        else {
          for (int i = first; i < first + num; i++) a[i] = id;
          cout << id << endl;
          id++;
        }
      } else if (s == "erase") {
        unsigned int num;
        cin >> num;
        if (num == 0 || num >= id || used[num - 1]) {
          puts("ILLEGAL_ERASE_ARGUMENT");
        } else {
          for (int i = 0; i < m; i++)
            if (a[i] == num) a[i] = 0;
          used[num - 1] = true;
        }
      } else {
        int idx = 0;
        memset(b, 0, sizeof(b));
        for (int i = 0; i < m; i++) {
          if (a[i] != 0) b[idx++] = a[i];
        }
        memcpy(a, b, sizeof(a));
      }
    }
  }
}
