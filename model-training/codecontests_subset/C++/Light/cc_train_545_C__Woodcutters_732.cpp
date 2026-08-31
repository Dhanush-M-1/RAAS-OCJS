#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int n, count = 1, i;
  cin >> n;
  int a[n + 1], b[n];
  a[n] = 2000000001;
  for (i = 0; i < n; i++) cin >> a[i] >> b[i];
  for (i = 1; i < n; i++)
    if (a[i] - a[i - 1] > b[i])
      ++count;
    else if (a[i + 1] - a[i] > b[i])
      a[i] += b[i], ++count;
  cout << count;
}
