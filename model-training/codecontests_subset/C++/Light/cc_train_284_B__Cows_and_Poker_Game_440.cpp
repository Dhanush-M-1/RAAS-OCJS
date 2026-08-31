#include <bits/stdc++.h>
using namespace std;
const int maxn = 200002;
char str[maxn];
int n;
int main() {
  while (~scanf("%d", &n)) {
    scanf("%s", str);
    int cnt = 0;
    for (int i = 0; str[i] != '\0'; i++) {
      if (str[i] == 'I') cnt++;
    }
    if (cnt == 1)
      puts("1");
    else if (cnt > 1)
      puts("0");
    else {
      cnt = 0;
      for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] == 'A') cnt++;
      }
      printf("%d\n", cnt);
    }
  }
  return 0;
}
