#include <bits/stdc++.h>
using namespace std;
int n;
int ans[10][10];
int check(int a) { return a == 0 ? 0 : check(a / (n + 1)) * 10 + a % (n + 1); }
int main() {
  cin >> n;
  n--;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++) {
      ans[i][j] = check((i + 1) * (j + 1));
      cout << ans[i][j];
      cout << " ";
      if (j == n - 1) puts("");
    }
  return 0;
}
