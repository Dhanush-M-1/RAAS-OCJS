#include <bits/stdc++.h>
using namespace std;
int n;
char s[5][1001];
void print() { printf("%s %s\n", s[1] + 1, s[2] + 1); }
int main() {
  scanf("%s%s", s[1] + 1, s[2] + 1);
  int len1 = strlen(s[1] + 1), len2 = strlen(s[2] + 1);
  scanf("%d", &n);
  print();
  for (int i = 1; i <= n; i++) {
    scanf("%s", s[3] + 1);
    int len3 = strlen(s[3] + 1);
    int flag = 0;
    if (len1 == len3) {
      for (int i = 1; i <= len1; i++) {
        if (s[1][i] != s[3][i]) flag = 2;
      }
      if (flag == 0) flag = 1;
    } else
      flag = 2;
    scanf("%s", s[flag] + 1);
    len1 = strlen(s[1] + 1), len2 = strlen(s[2] + 1);
    print();
  }
  return 0;
}
