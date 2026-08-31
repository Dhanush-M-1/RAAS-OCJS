#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, pos, num[100005];
  cin >> n;
  for (i = 1; i <= n; i++) scanf("%d", &num[i]);
  pos = upper_bound(num + 1, num + 1 + n, 5e5) - num;
  if (pos > n)
    cout << num[n] - 1 << endl;
  else if (pos <= 1)
    cout << 1e6 - num[1] << endl;
  else {
    cout << max((int)1e6 - num[pos], num[pos - 1] - 1) << endl;
  }
  return 0;
}
