#include <bits/stdc++.h>
using namespace std;
int main() {
  bool success, chk;
  int t, m, i, j, n, curr, temp, id, iden;
  scanf("%d %d", &t, &m);
  int arr[m + 1];
  memset(arr, 0, sizeof(arr));
  curr = 1;
  temp = 1;
  iden = 1;
  while (t--) {
    string a;
    cin >> a;
    if (a == "alloc") {
      scanf("%d", &n);
      success = false;
      for (i = 1; i <= m - n + 1; i++) {
        if (arr[i] == 0) {
          chk = true;
          temp = n;
          j = i;
          while (temp--) {
            if (arr[j] != 0) {
              chk = false;
              break;
            }
            j++;
          }
          if (chk) {
            success = true;
            j = i;
            temp = n;
            while (temp--) {
              arr[j] = iden;
              j++;
            }
          }
        }
        if (success) {
          break;
        }
      }
      if (!success) {
        printf("NULL\n");
      } else {
        printf("%d\n", iden);
        iden++;
      }
    } else if (a == "erase") {
      scanf("%d", &id);
      if (id <= 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
      chk = false;
      for (i = 1; i <= m; i++) {
        if (arr[i] == id) {
          chk = true;
          arr[i] = 0;
        }
      }
      if (!chk) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
        continue;
      }
    } else if (a == "defragment") {
      int brr[m + 1];
      memset(brr, 0, sizeof(brr));
      j = 1;
      for (i = 1; i <= m; i++) {
        if (arr[i] != 0) {
          brr[j] = arr[i];
          j++;
        }
      }
      for (i = 0; i <= m; i++) {
        arr[i] = brr[i];
      }
      continue;
    }
  }
  return 0;
}
