#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3F3F3F3F;
const double EPS = 1E-10;
inline int cmp(double x, double y = 0, double tol = EPS) {
  return (x <= y + tol) ? (x + tol < y) ? -1 : 0 : 1;
}
int T, M;
int main() {
  int MEM[110] = {0};
  int id = 1;
  scanf("%d %d", &T, &M);
  for (int i = 0; i < T; i++) {
    char op[1000];
    scanf("%s", op);
    if (string(op) == "alloc") {
      int N;
      scanf("%d", &N);
      int k = 0;
      bool ok = 0;
      for (int i = 1; i <= M; i++) {
        if (MEM[i])
          k = 0;
        else {
          k++;
          if (k == N) {
            int b = i - k + 1;
            for (int j = b; j <= i; j++) MEM[j] = id;
            printf("%d\n", id++);
            ok = 1;
            break;
          }
        }
      }
      if (!ok) puts("NULL");
    } else if (string(op) == "erase") {
      int N;
      scanf("%d", &N);
      bool ok = 0;
      for (int i = 1; i <= M; i++)
        if (MEM[i] == N) MEM[i] = 0, ok = 1;
      if (!ok || !N) puts("ILLEGAL_ERASE_ARGUMENT");
    } else {
      int l = 1, i = 1;
      while (i <= M) {
        if (MEM[i] != 0) swap(MEM[i], MEM[l++]);
        i++;
      }
      while (l <= M) MEM[l++] = 0;
    }
  }
  return 0;
}
