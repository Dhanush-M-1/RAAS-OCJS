#include <bits/stdc++.h>
using namespace std;
const int maxn = (1e5) + 9;
int mem[110];
string s;
int t, m;
bool add(int len, int name) {
  int i, j, d = m - len + 1;
  bool flag = false;
  for (i = 1; i <= d; i++) {
    flag = false;
    for (j = i; j < i + len; j++) {
      if (mem[j]) flag = true;
    }
    if (flag == false) {
      for (j = i; j < i + len; j++) {
        mem[j] = name;
      }
      return true;
    }
  }
  return false;
}
int main() {
  int i, j, k;
  int len, na, name = 1;
  bool flag;
  scanf("%d%d\n", &t, &m);
  memset(mem, 0, sizeof(int) * 110);
  for (k = 0; k < t; k++) {
    cin >> s;
    if (s[0] == 'a') {
      scanf("%d", &len);
      if (add(len, name)) {
        printf("%d\n", name);
        name++;
      } else {
        printf("NULL\n");
      }
    } else if (s[0] == 'e') {
      scanf("%d", &na);
      if (na == 0) {
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      } else {
        for (i = 1; i <= m; i++) {
          if (mem[i] == na) break;
        }
        if (i > m) {
          printf("ILLEGAL_ERASE_ARGUMENT\n");
        } else {
          while (mem[i] == na) {
            mem[i] = 0;
            i++;
          }
        }
      }
    } else if (s[0] == 'd') {
      i = j = 1;
      while (j <= m) {
        mem[i] = mem[j];
        if (mem[i]) {
          i++;
          if (j >= i) mem[j] = 0;
        }
        j++;
      }
    }
  }
  return 0;
}
