#include <bits/stdc++.h>
using namespace std;
int a[100005];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    a[i] = min(a[i] - 1, 1000000 - a[i]);
  }
  sort(a + 1, a + 1 + n);
  cout << a[n] << endl;
  return 0;
}
