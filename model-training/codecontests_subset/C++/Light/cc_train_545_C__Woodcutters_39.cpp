#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n, i, x[100005], h[100005], ans[10005], c = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  c++;
  ans[0] = x[0];
  for (i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > ans[i - 1]) {
      ans[i] = x[i];
      c++;
    } else if (x[i] + h[i] < x[i + 1]) {
      ans[i] = x[i] + h[i];
      c++;
    } else {
      ans[i] = x[i];
    }
  }
  if (n > 1) c++;
  cout << c << endl;
  return 0;
}
