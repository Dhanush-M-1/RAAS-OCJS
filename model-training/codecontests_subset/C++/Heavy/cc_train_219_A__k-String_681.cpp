#include <bits/stdc++.h>
using namespace std;
void OpenFiles() {}
char x[1 << 10], sol[1 << 10];
int f[30];
int main() {
  OpenFiles();
  int K, lenth, i, j, ind;
  char ch;
  scanf("%d\n", &K);
  gets(x + 1);
  int N = strlen(x + 1);
  if (N % K) {
    printf("-1");
    return 0;
  }
  lenth = N / K;
  bool isSolution = 1;
  for (i = 1; i <= N; i++) f[x[i] - 'a']++;
  for (i = 1; i <= lenth; i++) {
    for (j = 0; j < 30; j++)
      if (f[j]) {
        ch = (char)j + 'a';
        ind = j;
      }
    for (j = i; j <= N; j += lenth)
      if (f[ind] == 0) {
        isSolution = 0;
        break;
      } else {
        sol[j] = ch;
        f[ind]--;
      }
    if (isSolution == 0) {
      printf("-1");
      return 0;
    }
  }
  for (i = 1; i <= N; i++) printf("%c", sol[i]);
  return 0;
}
