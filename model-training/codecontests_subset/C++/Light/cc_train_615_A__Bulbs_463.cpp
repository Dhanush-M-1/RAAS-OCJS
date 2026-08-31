#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 + 5;
bool ans[maxn];
int main(void) {
  int n, m;
  cin >> n >> m;
  memset(ans, false, sizeof(ans));
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a;
    for (int j = 0; j < a; j++) {
      cin >> b;
      ans[b] = true;
    }
  }
  int ok = 1;
  for (int i = 1; i <= m; i++) {
    if (ans[i] == false) {
      ok = 0;
      break;
    }
  }
  if (ok)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
