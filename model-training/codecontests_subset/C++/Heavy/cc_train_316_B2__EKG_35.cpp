#include <bits/stdc++.h>
using namespace std;
const double EPS = 1E-9;
const int INF = 1000000000;
const long long INF64 = (long long)1E18;
const double PI = 3.1415926535897932384626433832795;
typedef struct {
  int a;
  double p;
} tpo;
int main() {
  long long i, j, n, x;
  int a[2000];
  int o[2000];
  memset(&o, 0, sizeof(int) * 2000);
  cin >> n >> x;
  for (i = 0; i < n; ++i) cin >> a[i + 1];
  for (i = 0; i < n; ++i)
    if (a[i + 1] != 0) {
      int k = a[i + 1];
      while (a[k] != 0) k = a[k];
      o[k] += 1;
    }
  int my = 0, myI = -1;
  if (a[x] != 0) {
    int u = a[x];
    my = 1;
    while (a[u] != 0) {
      u = a[u];
      my++;
    }
    myI = u;
  }
  int list[4000], ilist = 1;
  list[0] = 0;
  int blist[4000], iblist;
  int cl[4000];
  memset(&cl, 0, sizeof(int) * 4000);
  cl[0] = 1;
  for (i = 1; i <= n; ++i)
    if ((a[i] == 0) && x != i && (myI != i)) {
      int l = 1;
      if (o[i] > 0) l = o[i] + 1;
      iblist = 0;
      for (j = 0; j < ilist; ++j) {
        if (cl[list[j] + l] == 0) blist[iblist++] = list[j] + l;
        cl[list[j] + l] = 1;
      }
      for (j = 0; j < iblist; ++j) list[ilist++] = blist[j];
    }
  for (i = 0; i <= n; ++i)
    if (cl[i] == 1) cout << i + 1 + my << endl;
  return 0;
}
