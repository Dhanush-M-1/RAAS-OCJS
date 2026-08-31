#include <bits/stdc++.h>
using namespace std;
char card[105];
int noe, noo;
int main() {
  int n;
  while (~scanf("%d", &n)) {
    scanf("%s", card);
    noe = 0;
    noo = 0;
    for (int i = 0; i < n; i++) {
      if (card[i] == '8')
        noe++;
      else
        noo++;
    }
    int res = 0;
    while (noe && n > 10) {
      noe--;
      if (noo >= 10)
        noo -= 10;
      else if (noo + noe >= 10) {
        noe -= (10 - noo);
        noo = 0;
      }
      res++;
      if (noo + noe < 11) break;
    }
    printf("%d\n", res);
  }
  return 0;
}
