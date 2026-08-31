#include <bits/stdc++.h>
using namespace std;
int arr[110];
int main() {
  int t, m;
  int num;
  string cmd;
  int id = 1;
  int qi;
  while (cin >> t >> m) {
    id = 1;
    memset(arr, 0, sizeof arr);
    while (t--) {
      cin >> cmd;
      if (cmd == "alloc") {
        cin >> num;
        qi = -1;
        for (int i = 1; i <= m; i++) {
          int cun = 0;
          for (int j = i; j <= m; j++) {
            if (arr[j] == 0)
              cun++;
            else
              break;
          }
          if (cun >= num) {
            qi = i;
            break;
          }
        }
        if (qi == -1) {
          puts("NULL");
          continue;
        }
        int nw = id++;
        printf("%d\n", nw);
        for (int i = qi; i < qi + num; i++) {
          arr[i] = nw;
        }
      } else if (cmd == "erase") {
        cin >> num;
        if (num <= 0) {
          puts("ILLEGAL_ERASE_ARGUMENT");
          continue;
        }
        int flag = 0;
        for (int i = 1; i <= m; i++) {
          if (arr[i] == num) {
            flag = 1;
            arr[i] = 0;
          }
        }
        if (flag == 0) {
          puts("ILLEGAL_ERASE_ARGUMENT");
          continue;
        }
      } else if (cmd == "defragment") {
        int jj = 1;
        for (int i = 1; i <= m; i++) {
          if (arr[i]) arr[jj++] = arr[i];
        }
        for (int i = jj; i <= m; i++) arr[i] = 0;
      }
    }
  }
  cin >> t;
  return 0;
}
