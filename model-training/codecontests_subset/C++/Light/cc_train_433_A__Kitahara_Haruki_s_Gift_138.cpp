#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x[101], count100 = 0, count200 = 0;
  cin >> n;
  for (int i = 0; i <= n - 1; i++) cin >> x[i];
  for (int j = 0; j <= n - 1; j++)
    if (x[j] == 100)
      count100++;
    else
      count200++;
  if ((count100 + (count200 * 2)) % 2 == 0)
    if ((count100 == 0 && ((count200) % 2) == 1))
      cout << "NO" << endl;
    else
      cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
