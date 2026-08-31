#include <bits/stdc++.h>
using namespace std;
int n, c, x[105], ans;
int main() {
  ios::sync_with_stdio(false), cout.tie(NULL), cin.tie(NULL);
  ;
  cin >> n >> c;
  for (int i = 0; i < n; i++) cin >> x[i];
  for (int i = 0; i < n - 1; i++) ans = max(ans, x[i] - x[i + 1]);
  cout << max(ans - c, 0) << endl;
  return 0;
}
