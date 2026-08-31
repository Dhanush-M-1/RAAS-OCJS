#include <bits/stdc++.h>
using namespace std;
char buf[200];
int mem[200];
int Solution() {
  int c, n, ind = 1;
  scanf("%d%d", &c, &n);
  gets(buf);
  vector<int> al(1), sz(1);
  for (int i = 0; i < c; ++i) {
    gets(buf);
    string s = buf;
    switch (s[0]) {
      case 'a': {
        s = s.substr(6, s.size() - 6);
        int x, flag = 0;
        sscanf(s.c_str(), "%d", &x);
        for (int j = 1; j <= n - x + 1; ++j) {
          int f = 1, gde = j;
          for (int k = j; k < j + x; ++k)
            if (mem[k]) {
              f = 0;
              break;
            }
          if (f) {
            al.push_back(gde);
            sz.push_back(x);
            for (int j = gde; j < gde + x; ++j) mem[j] = ind;
            printf("%d\n", ind);
            flag = 1;
            ++ind;
            break;
          }
        }
        if (!flag) {
          printf("NULL\n");
        }
        break;
      }
      case 'e': {
        s = s.substr(6, s.size() - 6);
        int x;
        sscanf(s.c_str(), "%d", &x);
        if (x > ind - 1 || x < 1 || al[x] == 0)
          printf("ILLEGAL_ERASE_ARGUMENT\n");
        else {
          for (int j = al[x]; j < al[x] + sz[x]; ++j) mem[j] = 0;
          al[x] = 0;
        }
        break;
      }
      default: {
        for (int j = 1; j <= n; ++j) {
          if (mem[j] == 0) {
            int k = j + 1;
            while (k <= n && mem[k] == 0) ++k;
            if (k > n) break;
            mem[j] = mem[k];
            if (al[mem[j]] > j) al[mem[j]] = j;
            mem[k] = 0;
          }
        }
      }
    }
  }
  return 0;
}
int main() {
  Solution();
  return 0;
}
