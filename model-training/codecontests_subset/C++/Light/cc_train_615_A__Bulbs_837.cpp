#include <bits/stdc++.h>
using namespace std;
bool b[100000];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    int x, y;
    cin >> x;
    for (int j = 1; j <= x; j++) {
      cin >> y;
      b[y] = 1;
    }
  }
  int f = 1;
  for (int i = 1; i <= m; i++) {
    if (b[i] == 0) {
      f = 0;
      break;
    }
  }
  if (f)
    printf("YES\n");
  else
    printf("NO\n");
}
