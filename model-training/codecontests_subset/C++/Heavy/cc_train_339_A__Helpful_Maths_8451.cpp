#include <bits/stdc++.h>
using namespace std;
int main() {
  char str[100];
  int num[3];
  memset(num, 0, sizeof(num));
  scanf("%s", str);
  int len = 0;
  len = strlen(str);
  for (int i = 0; i < len; i++) {
    if (str[i] == '1')
      num[0]++;
    else if (str[i] == '2')
      num[1]++;
    else if (str[i] == '3')
      num[2]++;
  }
  char ans[len];
  memset(ans, '/0', sizeof(ans));
  for (int i = 0; i < len - 1; i = i + 2) {
    ans[i + 1] = '+';
    for (int i = 2 * (num[0] + num[1]); i < num[0] + num[1] + num[2]; i++) {
      ans[2 * i] = '2';
    }
  }
  for (int i = 0; i < num[0]; i++) {
    ans[2 * i] = '1';
  }
  for (int i = num[0]; i < (num[0] + num[1]); i++) {
    ans[2 * i] = '2';
  }
  for (int i = (num[0] + num[1]); i < (num[0] + num[1] + num[2]); i++) {
    ans[2 * i] = '3';
  }
  for (int i = 0; i < len; i++) {
    printf("%c", ans[i]);
  }
  return 0;
}
