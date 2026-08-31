#include <bits/stdc++.h>
using namespace std;
int N, M, s[105];
int main() {
  scanf("%d %d", &N, &M);
  for (int i = 1; i <= (N); i++) {
    int x;
    scanf("%d", &x);
    for (int j = 1; j <= (x); j++) {
      int y;
      scanf("%d", &y);
      s[y] = 1;
    }
  }
  for (int i = 1; i <= (M); i++)
    if (!s[i]) {
      puts("NO");
      return 0;
    }
  puts("YES");
  return 0;
}
