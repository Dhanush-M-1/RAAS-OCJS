#include <bits/stdc++.h>
using namespace std;
char str[1100];
vector<int> flag;
int main() {
  int n;
  while (gets(str)) {
    flag.clear();
    int len = strlen(str);
    int num[2] = {0, 0};
    int id = 0;
    flag.push_back(1);
    while (str[id] != '=') {
      if (str[id] == '?')
        ++num[flag.back()];
      else if (str[id] == '+')
        flag.push_back(1);
      else if (str[id] == '-')
        flag.push_back(0);
      ++id;
    }
    id += 2;
    sscanf(str + id, "%d", &n);
    if (n >= num[1] - num[0] * n && n <= num[1] * n - num[0]) {
      puts("Possible");
      vector<int> ans(flag.size(), 1);
      int tmp = num[1] - num[0];
      for (int i = 0; tmp != n && i < flag.size(); ++i) {
        if (flag[i])
          while (tmp < n && ans[i] < n) ++tmp, ++ans[i];
        else
          while (tmp > n && ans[i] < n) --tmp, ++ans[i];
      }
      for (int i = 0; i < (flag.size()); ++i) {
        if (i != 0) putchar(flag[i] ? '+' : '-'), putchar(' ');
        printf("%d ", ans[i]);
      }
      printf("= %d\n", n);
    } else
      puts("Impossible");
  }
  return 0;
}
