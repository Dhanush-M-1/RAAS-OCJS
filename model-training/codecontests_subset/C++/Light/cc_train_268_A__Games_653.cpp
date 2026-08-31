#include <bits/stdc++.h>
using namespace std;
int a[101], b[101];
int n, i, j, nr;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  for (i = 1; i <= n; i++) cin >> a[i] >> b[i];
  for (i = 1; i <= n; i++)
    for (j = 1; j <= n; j++)
      if (a[i] == b[j]) nr++;
  cout << nr;
}
