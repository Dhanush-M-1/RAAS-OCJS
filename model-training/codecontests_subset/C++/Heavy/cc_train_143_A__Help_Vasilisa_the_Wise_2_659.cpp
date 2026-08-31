#include <bits/stdc++.h>
using namespace std;
void SR(int &x) { scanf("%d", &x); }
void SR(long long &x) { scanf("%lld", &x); }
void SR(double &x) { scanf("%lf", &x); }
void SR(char *s) { scanf("%s", s); }
void RI() {}
template <typename I, typename... T>
void RI(I &x, T &...tail) {
  SR(x);
  RI(tail...);
}
int main() {
  int r[2], c[2], d[2];
  for (int i = 0; i < int(2); i++) RI(r[i]);
  for (int i = 0; i < int(2); i++) RI(c[i]);
  for (int i = 0; i < int(2); i++) RI(d[i]);
  for (int x = (1); x <= int(9); x++)
    for (int y = (1); y <= int(9); y++)
      for (int z = (1); z <= int(9); z++)
        for (int w = (1); w <= int(9); w++) {
          if (x + y != r[0]) continue;
          if (z + w != r[1]) continue;
          if (x + z != c[0]) continue;
          if (y + w != c[1]) continue;
          if (x + w != d[0]) continue;
          if (y + z != d[1]) continue;
          set<int> s;
          s.insert(x);
          s.insert(y);
          s.insert(z);
          s.insert(w);
          if (((int)(s).size()) != 4) continue;
          printf("%d %d\n%d %d\n", x, y, z, w);
          return 0;
        }
  puts("-1");
  return 0;
}
