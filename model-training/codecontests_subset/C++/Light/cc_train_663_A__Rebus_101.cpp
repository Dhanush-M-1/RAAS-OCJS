#include <bits/stdc++.h>
using namespace std;
int main(int argc, char* argv[]) {
  char str[10000];
  int a[110];
  gets(str);
  int addnum = 0, subnum = 0, len = strlen(str), now = 1, num = 0;
  int ans = 0;
  a[num++] = 1;
  for (int i = 0; i < len; i++) {
    if (str[i] == '-')
      subnum++, now--, a[num++] = -1;
    else if (str[i] == '+')
      addnum++, now++, a[num++] = 1;
    else if (str[i] == '=') {
      for (int j = i + 2; j < len; j++) ans = ans * 10 + str[j] - '0';
      break;
    }
  }
  for (int i = 0; i < num; i++) {
    while (now < ans && a[i] > 0 && a[i] < ans) a[i]++, now++;
    while (now > ans && a[i] < 0 && a[i] > -ans) a[i]--, now--;
  }
  if (now != ans)
    printf("Impossible\n");
  else {
    printf("Possible\n");
    for (int i = 0, j = 0; i < len && j <= num; i++) {
      if (str[i] == '?')
        cout << abs(a[j++]);
      else
        cout << str[i];
    }
    cout << endl;
  }
}
