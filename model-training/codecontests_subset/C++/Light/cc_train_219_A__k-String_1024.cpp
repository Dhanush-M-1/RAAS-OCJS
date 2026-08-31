#include <bits/stdc++.h>
using namespace std;
char str[100001];
int mao[50];
int main() {
  int i, j, k, t, len, flag;
  memset(str, 0, sizeof(str));
  cin >> t >> str;
  len = strlen(str);
  for (i = 0; i < len; i++) mao[str[i] - 'a']++;
  flag = 0;
  for (i = 0; i < 30; i++)
    if (mao[i] != 0) {
      if (mao[i] % t != 0) {
        flag = 1;
        break;
      }
    }
  if (flag == 1)
    cout << -1 << endl;
  else {
    for (i = 0; i < t; i++)
      for (j = 0; j < 50; j++) {
        if (mao[j] != 0) {
          for (k = 0; k < mao[j] / t; k++) printf("%c", j + 'a');
        }
      }
    cout << endl;
  }
  return 0;
}
