#include <bits/stdc++.h>
bool DEBUG = false;
using namespace std;
int k;
int len;
char buf[2000];
int mas[26];
int main() {
  scanf("%d\n", &k);
  gets(buf);
  len = strlen(buf);
  for (int i = 0; i < (len); ++i) mas[buf[i] - 'a']++;
  for (int i = 0; i < (26); ++i)
    if (mas[i] % k != 0) {
      printf("-1");
      return 0;
    }
  len = 0;
  for (int i = 0; i < (26); ++i)
    for (int j = 0; j < (mas[i] / k); ++j) buf[len++] = 'a' + i;
  buf[len] = '\0';
  for (int i = 0; i < (k); ++i) printf("%s", buf);
  return 0;
}
