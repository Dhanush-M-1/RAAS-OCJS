#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, t1 = 0, t2 = 0;
  int a[1000000];
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++) {
    if (a[i] <= 500000) t1 = a[i] - 1;
  }
  for (int i = n - 1; i >= 0; i--) {
    if (a[i] > 500000) t2 = 1000000 - a[i];
  }
  if (t1 > t2)
    cout << t1 << endl;
  else
    cout << t2 << endl;
  return 0;
}
