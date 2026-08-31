#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, i, sum = 0, j = 0, tmp = 0;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a[i];
    a[i] /= 100;
    sum += a[i];
  }
  if (sum % 2) {
    puts("NO");
    return 0;
  }
  sum /= 2;
  sort(a, a + n);
  i = 0;
  tmp = a[0];
  while (i < n && j < n) {
    if (tmp < sum) {
      j++;
      tmp += a[j];
    } else if (tmp == sum) {
      puts("YES");
      return 0;
    } else {
      tmp -= a[i];
      i++;
    }
  }
  puts("NO");
  return 0;
  return 0;
}
