#include <bits/stdc++.h>
using namespace std;
int sta[300] = {0};
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  while (n--) {
    int x;
    cin >> x;
    while (x--) {
      int y;
      cin >> y;
      sta[y] = 1;
    }
  }
  int ans = 0;
  for (int i = 0; i <= 100; ++i) ans += sta[i];
  if (ans == m)
    puts("YES");
  else
    puts("NO");
  return 0;
}
