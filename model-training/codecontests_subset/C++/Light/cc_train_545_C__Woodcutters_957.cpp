#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x[100005] = {0}, h[100005] = {0};
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  int count = 2;
  for (int i = 1; i < n - 1; i++) {
    if (x[i] - x[i - 1] > h[i])
      count++;
    else if (x[i + 1] - x[i] > h[i]) {
      count++;
      x[i] = x[i] + h[i];
    }
  }
  if (n == 1)
    cout << 1;
  else
    cout << count;
}
