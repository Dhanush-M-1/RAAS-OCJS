#include <bits/stdc++.h>
using namespace std;
inline void printInt(int a) { printf("%d", a); }
inline void printDbl(double a) { printf("%.10lf", a); }
inline int getInt() {
  int res;
  scanf("%d", &res);
  return res;
}
inline double getDbl() {
  double res;
  scanf("%lf", &res);
  return res;
}
const int maxn = 100;
const int maxs = 210 * 100 * 2;
int sign[maxn];
int a[maxn][maxn];
bool can[maxn][maxn];
int ans[maxn];
int n = 0;
int inits;
int d;
void print() {
  printf("Possible\n");
  for (int i = (0); i < (n); i++) {
    if (i != 0) printf("%c ", sign[i] == 1 ? '+' : '-');
    printf("%d ", ans[i] + 1);
  }
  printf("= %d", inits);
}
int main() {
  srand(time(0));
  sign[0] = 1;
  int plus = 1;
  int minus = 0;
  while (true) {
    char c;
    scanf("%c", &c);
    assert(c == '?');
    n++;
    scanf("%c", &c);
    assert(c == ' ');
    scanf("%c", &c);
    assert(c == '-' || c == '+' || c == '=');
    if (c == '=') {
      break;
    }
    sign[n] = c == '-' ? -1 : +1;
    if (c == '-')
      minus++;
    else
      plus++;
    scanf("%c", &c);
    assert(c == ' ');
  }
  d = plus - minus;
  int s = getInt();
  int lim = s - 1;
  inits = s;
  s -= d;
  vector<int> ms;
  vector<int> ps;
  int mR = minus * lim;
  int pR = plus * lim;
  if (-mR <= s && s <= pR) {
    if (s < 0) {
      while (s < 0) {
        int v = min(-s, lim);
        ms.push_back(v);
        s += v;
      }
    } else {
      while (s > 0) {
        int v = min(s, lim);
        ps.push_back(v);
        s -= v;
      }
    }
    for (int i = (0); i < (n); i++) {
      if (sign[i] == 1 && ((int)(ps).size()) > 0) {
        ans[i] = ps[((int)(ps).size()) - 1];
        ps.pop_back();
      }
      if (sign[i] == -1 && ((int)(ms).size()) > 0) {
        ans[i] = ms[((int)(ms).size()) - 1];
        ms.pop_back();
      }
    }
    print();
  } else {
    printf("Impossible");
    return 0;
  }
  return 0;
}
