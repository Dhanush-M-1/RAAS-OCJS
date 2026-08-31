#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100001], b[100001];
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i] >> b[i];
  int s = 2;
  for (int i = 2; i <= n - 1; i++)
    if (a[i] - a[i - 1] > b[i])
      s++;
    else if (a[i + 1] - a[i] > b[i]) {
      s++;
      a[i] += b[i];
    }
  if (n == 1) s = 1;
  cout << s;
  return 0;
}
