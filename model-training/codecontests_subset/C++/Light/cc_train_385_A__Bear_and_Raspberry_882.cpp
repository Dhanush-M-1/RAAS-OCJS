#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, c, max = 0;
  cin >> n >> c;
  int x[n];
  for (int i = 0; i < n; i++) {
    cin >> x[i];
  }
  for (int i = 0; i < n - 1; i++) {
    int temp = x[i] - x[i + 1] - c;
    if (temp > max) max = temp;
  }
  cout << max;
  return 0;
}
