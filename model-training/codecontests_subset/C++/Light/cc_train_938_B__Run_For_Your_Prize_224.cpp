#include <bits/stdc++.h>
using namespace std;
int a[1000005];
int main() {
  int n;
  cin >> n;
  int t1 = 0, t2 = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    if (a[i] <= 1000000 / 2)
      t1 = max(t1, a[i] - 1);
    else
      t2 = max(t2, abs(1000000 - a[i]));
  }
  cout << max(t1, t2) << endl;
}
