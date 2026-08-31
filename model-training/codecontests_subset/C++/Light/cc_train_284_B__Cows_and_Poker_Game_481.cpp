#include <bits/stdc++.h>
using namespace std;
const double eps = 1E-8;
char s[200001];
bool solve() {
  int n;
  if (scanf("%d%s", &n, s) == EOF) return false;
  int a = 0, f = 0, i = 0;
  for (char *c = s; *c; ++c) switch (*c) {
      case 'A':
        a++;
        break;
      case 'F':
        f++;
        break;
      case 'I':
        i++;
        break;
    }
  if (i == 1)
    printf("1\n");
  else if (i == 0)
    printf("%d\n", a + i);
  else
    printf("0\n");
  return true;
}
int main() { solve(); }
