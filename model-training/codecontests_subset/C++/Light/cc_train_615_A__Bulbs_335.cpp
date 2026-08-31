#include <bits/stdc++.h>
using namespace std;
int used[105];
int main(int argc, char const* argv[]) {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; i += 1) {
    int x;
    scanf("%d", &x);
    for (int j = 0; j < x; j += 1) {
      int a;
      scanf("%d", &a);
      used[a] = 1;
    }
  }
  if (accumulate(used, used + m + 1, 0) == m)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
