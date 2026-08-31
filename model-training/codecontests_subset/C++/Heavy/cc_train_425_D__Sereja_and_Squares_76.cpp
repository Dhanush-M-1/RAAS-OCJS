#include <bits/stdc++.h>
using namespace std;
struct st {
  int x, y;
  bool operator<(const st& B) const { return x < B.x || (x == B.x && y < B.y); }
} a[100005];
int N, M;
set<long long> F[100005];
void ins(int x, int y) { F[x].insert(y); }
bool find(int x, int y) {
  if (x < 0 || x > 1e5) return 0;
  set<long long>::iterator p = F[x].lower_bound(y);
  return p != F[x].end() && *p == y;
}
void init() {
  scanf("%d", &N), M = sqrt(N) + 1;
  for (int i = 1; i <= N; i++)
    scanf("%d%d", &a[i].x, &a[i].y), ins(a[i].x, a[i].y);
  sort(a + 1, a + N + 1);
}
void doit() {
  int ans = 0;
  for (int i = 1, j, d; i <= N; i = j) {
    for (j = i; j <= N && a[j].x == a[i].x; j++)
      ;
    if (j - i <= M)
      for (int k = i; k < j; k++)
        for (int l = k + 1; l < j; l++)
          d = a[l].y - a[k].y,
          ans += find(a[k].x - d, a[k].y) && find(a[l].x - d, a[l].y);
    else
      for (int k = 1; k < i; k++)
        d = a[i].x - a[k].x, ans += find(a[i].x, a[k].y) &&
                                    find(a[i].x, a[k].y + d) &&
                                    find(a[k].x, a[k].y + d);
  }
  printf("%d\n", ans);
}
int main() {
  init();
  doit();
  return 0;
}
