#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x[100005], h[100005];
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> x[i] >> h[i];
  int count = 1;
  int newarr[100005];
  newarr[1] = x[0] - h[0];
  for (int i = 1; i < n - 1; ++i) {
    if ((x[i] - h[i] > x[i - 1]) && (x[i] - h[i] > newarr[count])) {
      count++;
      newarr[count] = x[i] - h[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      count++;
      newarr[count] = x[i] + h[i];
    } else
      continue;
  }
  if (n == 1)
    puts("1");
  else
    cout << count + 1 << endl;
  return 0;
}
