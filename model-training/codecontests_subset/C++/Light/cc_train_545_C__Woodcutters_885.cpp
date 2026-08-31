#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  long long int x[n];
  long long int h[n];
  for (int i = 0; i < n; ++i) cin >> x[i] >> h[i];
  long long int coun = 0;
  coun++;
  for (int i = 1; i < n; ++i) {
    if (x[i] - h[i] > x[i - 1]) {
      coun++;
    } else if (x[i] + h[i] < x[i + 1]) {
      coun++;
      x[i] = x[i] + h[i];
    }
  }
  cout << coun;
  return 0;
}
