#include <bits/stdc++.h>
using namespace std;
const int N = 500100;
char S[N];
int n;
int main(void) {
  scanf("%d", &n);
  scanf("%s", S);
  int len = strlen(S);
  int allin = 0, in = 0, fold = 0;
  for (int i = 0; S[i]; i++) {
    allin += (S[i] == 'A');
    in += (S[i] == 'I');
    fold += (S[i] == 'F');
  }
  int sol = 0;
  for (int i = 0; S[i]; i++) {
    if (S[i] != 'F') {
      if (S[i] == 'A') {
        if (fold + allin == len) sol++;
      } else if (in == 1)
        sol++;
    }
  }
  printf("%d\n", sol);
  return 0;
}
