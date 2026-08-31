#include <bits/stdc++.h>
using namespace std;
template <typename T>
T Abs(T first) {
  return (first < 0 ? -first : first);
}
template <typename T>
T Sqr(T first) {
  return (first * first);
}
string plural(string s) {
  return (int((s).size()) && s[int((s).size()) - 1] == 'x' ? s + "en"
                                                           : s + "s");
}
const int INF = (int)1e9;
const long double EPS = 1e-9;
const long double PI = acos(-1.0);
bool Read(int &first) {
  char c, r = 0, n = 0;
  first = 0;
  for (;;) {
    c = getchar();
    if ((c < 0) && (!r)) return (0);
    if ((c == '-') && (!r))
      n = 1;
    else if ((c >= '0') && (c <= '9'))
      first = first * 10 + c - '0', r = 1;
    else if (r)
      break;
  }
  if (n) first = -first;
  return (1);
}
int main() {
  if (0) freopen("in.txt", "r", stdin);
  int T;
  int i, j, k, a, b, c;
  long long ans[6];
  char s[19];
  int dig[19];
  bool dyn[20][10];
  int prevA[20][10], prevB[20][10], prevC[20][10], prevJ[20][10];
  Read(T);
  while (T--) {
    scanf("%s", &s);
    memset(dig, 0, sizeof(dig));
    j = strlen(s);
    for (i = 0; i < j; i++) dig[i] = s[j - i - 1] - '0';
    memset(dyn, 0, sizeof(dyn));
    dyn[0][0] = 1;
    for (i = 0; i < 19; i++)
      for (j = 0; j < 10; j++)
        if (dyn[i][j])
          for (a = 0; a < 7; a++)
            for (b = 0; b < 7 - a; b++) {
              c = 6 - a - b;
              k = j + b * 4 + c * 7;
              if (k % 10 != dig[i]) continue;
              k /= 10;
              if (!dyn[i + 1][k]) {
                dyn[i + 1][k] = 1;
                prevA[i + 1][k] = a;
                prevB[i + 1][k] = b;
                prevC[i + 1][k] = c;
                prevJ[i + 1][k] = j;
              }
            }
    if (!dyn[19][0])
      printf("-1\n");
    else {
      memset(ans, 0, sizeof(ans));
      j = 0;
      for (i = 19; i > 0; i--) {
        a = prevA[i][j];
        b = prevB[i][j];
        c = prevC[i][j];
        for (k = 0; k < a; k++) ans[k] = ans[k] * 10;
        for (k = a; k <= a + b - 1; k++) ans[k] = ans[k] * 10 + 4;
        for (k = a + b; k <= 5; k++) ans[k] = ans[k] * 10 + 7;
        j = prevJ[i][j];
      }
      for (i = 0; i < 6; i++) {
        cout << ans[i];
        if (i == 5)
          printf("\n");
        else
          printf(" ");
      }
    }
  }
  return (0);
}
