#include <bits/stdc++.h>
using namespace std;
char s[1000000];
int main() {
  int N;
  scanf("%d%s", &N, &s);
  int a = 0;
  int f = 0;
  int i = 0;
  for (int j = 0; j < N; j++) {
    if (s[j] == 'A') a++;
    if (s[j] == 'I') i++;
    if (s[j] == 'F') f++;
  }
  int res = 0;
  for (int j = 0; j < N; j++)
    if ((s[j] == 'A' && i == 0) || (i == 1 && s[j] == 'I')) res++;
  printf("%d\n", res);
  return 0;
}
