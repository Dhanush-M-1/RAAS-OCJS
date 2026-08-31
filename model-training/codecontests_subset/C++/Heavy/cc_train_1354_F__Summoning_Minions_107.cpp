#include <bits/stdc++.h>
using namespace std;
const int N = 75 + 10;
struct re {
  int a, b, id;
} a[N];
long long f[N][N];
bool plan[N][N];
bool choose[N];
vector<int> actions;
void get_plan(int x, int y) {
  if (x == 0) return;
  if (plan[x][y]) choose[x] = true;
  get_plan(x - 1, y - plan[x][y]);
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n, k;
    scanf("%d%d", &n, &k);
    for (int i = 1; i <= n; ++i) {
      scanf("%d%d", &a[i].a, &a[i].b);
      a[i].id = i;
    }
    sort(a + 1, a + n + 1, [&](const re &a, const re &b) { return a.b < b.b; });
    memset(f, -1, sizeof(f[0]) * (n + 3));
    f[0][0] = 0;
    for (int i = 1; i <= n; ++i) {
      int upb = min(i - 1, k);
      for (int j = 0; j <= upb; ++j) {
        if (f[i - 1][j] == -1) continue;
        long long tmp = f[i - 1][j] + (long long)(k - 1) * a[i].b;
        if (tmp > f[i][j]) {
          f[i][j] = tmp;
          plan[i][j] = false;
        }
        tmp = f[i - 1][j] + a[i].a + (long long)j * a[i].b;
        if (tmp > f[i][j + 1]) {
          f[i][j + 1] = tmp;
          plan[i][j + 1] = true;
        }
      }
    }
    memset(choose, 0, sizeof(choose[0]) * (n + 3));
    get_plan(n, k);
    actions.clear();
    int cnt = 0;
    for (int i = 1; i <= n && cnt < k - 1; ++i) {
      if (!choose[i]) continue;
      cnt++;
      actions.push_back(a[i].id);
    }
    for (int i = 1; i <= n; ++i) {
      if (choose[i]) continue;
      actions.push_back(a[i].id);
      actions.push_back(-a[i].id);
    }
    for (int i = n; i; --i) {
      if (!choose[i]) continue;
      actions.push_back(a[i].id);
      break;
    }
    int actions_tot = actions.size();
    printf("%d\n", actions_tot);
    for (int i = 0; i < actions_tot; ++i)
      printf("%d%c", actions[i], " \n"[i == actions_tot - 1]);
  }
  return 0;
}
