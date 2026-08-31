#include <bits/stdc++.h>
const int INF = (int)1e9;
const double PI = acos(-1.);
using namespace std;
int n, ans, a[105], b[105];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (i != j)
        if (b[i] == a[j]) ans++;
  cout << ans;
  return 0;
}
