#include <bits/stdc++.h>
using namespace std;
const int S = 100010;
int x[S], h[S];
int main(int argc, const char* argv[]) {
  int a = 2;
  int n;
  cin >> n;
  if (n == 1) {
    cout << 1;
    return 0;
  }
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  int left = x[0];
  for (int i = 1; i < n - 1; i++) {
    if (left < (x[i] - h[i])) {
      a++;
      left = x[i];
    } else if ((x[i] + h[i]) < x[i + 1]) {
      a++;
      left = x[i] + h[i];
    } else
      left = x[i];
  }
  cout << a;
  return 0;
}
