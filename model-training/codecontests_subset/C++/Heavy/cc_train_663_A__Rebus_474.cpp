#include <bits/stdc++.h>
using namespace std;
const int oo = 0x3f3f3f3f;
int n, res, sol[109];
char s[20], sig[109];
int main() {
  n = 0;
  int def = 0;
  scanf("%s", s);
  sig[n++] = '+';
  def++;
  while (1) {
    scanf("%s", s);
    sig[n] = s[0];
    if (s[0] == '+')
      def++;
    else if (s[0] == '-')
      def--;
    else
      break;
    n++;
    scanf("%s", s);
  }
  scanf("%d", &res);
  memset((sol), (0), sizeof(sol));
  for (int(i) = (0); (i) < (n); ++(i)) {
    if (sig[i] == '+') {
      if (def < res) {
        int d = res - def;
        d = min(d, res - 1);
        sol[i] = d;
        def += d;
      }
    } else {
      if (def > res) {
        int d = def - res;
        d = min(d, res - 1);
        sol[i] = d;
        def -= d;
      }
    }
  }
  if (def != res)
    puts("Impossible");
  else {
    puts("Possible");
    printf("%d", sol[0] + 1);
    for (int(i) = (1); (i) < (n); ++(i)) printf(" %c %d", sig[i], sol[i] + 1);
    printf(" = %d\n", res);
  }
  return 0;
}
