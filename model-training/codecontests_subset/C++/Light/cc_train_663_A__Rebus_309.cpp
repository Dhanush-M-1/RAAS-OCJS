#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7;
const int INF = 2e9 + 7;
const int MOD = 1e9 + 7;
const long long LINF = 1e17 + 7;
const double Pi = acos(-1.);
const double EPS = 1e-8;
int n, x, y;
vector<int> p;
char nxtChar() {
  char ch = getchar();
  while (!(ch == '?' || ch == '+' || ch == '-' || ch == '=')) ch = getchar();
  return ch;
}
int main() {
  x = 1, y = 0;
  char ch = nxtChar();
  while (ch != '=') {
    if (ch == '+') {
      ++x;
      p.push_back(1);
    } else if (ch == '-') {
      ++y;
      p.push_back(-1);
    }
    ch = nxtChar();
  }
  scanf("%d", &n);
  if (x * n < n + y || y * n + n < x) {
    puts("Impossible");
  } else {
    puts("Possible");
    int v = max(x, n + y), xx = v % x, yy = (y > 0 ? (v - n) % y : 0);
    printf("%d", v / x);
    for (int i = 0; i < ((int)(p.size())); ++i)
      if (p[i] > 0) {
        printf(" + ");
        xx > 0 ? printf("%d", v / x + 1), --xx : printf("%d", v / x);
      } else {
        printf(" - ");
        yy > 0   ? printf("%d", (v - n) / y + 1),
            --yy : printf("%d", (v - n) / y);
      }
    printf(" = %d\n", n);
  }
  return 0;
}
