#include <bits/stdc++.h>
using namespace std;
int ax, ay, bx, by, cx, cy;
inline bool isok(int ex, int ey) {
  if (cx == 0 && cy == 0) return ex == 0 && ey == 0;
  long long a = 1ll * ex * cx + 1ll * ey * cy,
            b = 1ll * ey * cx - 1ll * ex * cy,
            c = 1ll * cx * cx + 1ll * cy * cy;
  return a % c == 0 && b % c == 0;
}
int main() {
  scanf("%d%d%d%d%d%d", &ax, &ay, &bx, &by, &cx, &cy);
  if (isok(bx - ax, by - ay) || isok(bx + ay, by - ax) ||
      isok(bx + ax, by + ay) || isok(bx - ay, by + ax))
    printf("YES");
  else
    printf("NO");
}
