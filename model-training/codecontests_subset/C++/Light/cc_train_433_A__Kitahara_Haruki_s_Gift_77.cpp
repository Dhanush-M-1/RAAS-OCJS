#include <bits/stdc++.h>
using namespace std;
const int maxn = 110;
int n;
int a[maxn];
int main() {
  cin >> n;
  int sum = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    sum += a[i];
  }
  int ret = sum / 2;
  sort(a, a + n);
  for (int i = n - 1; i >= 0; i--) {
    if (ret >= a[i]) ret -= a[i];
  }
  if (ret == 0)
    cout << "YES";
  else
    cout << "NO";
  return 0;
}
