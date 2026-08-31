#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n;
  scanf("%d", &n);
  int sum = 0;
  int t1 = 0, t2 = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    sum += a[i];
    if (a[i] == 100)
      t1++;
    else
      t2++;
  }
  if ((sum / 100) % 2 != 0) {
    puts("NO");
    return 0;
  }
  int tmp = 0;
  while (t2) {
    tmp += 200;
    if (tmp == sum / 2) {
      puts("YES");
      return 0;
    } else if (tmp > sum / 2) {
      if (t1) {
        puts("YES");
        return 0;
      } else {
        puts("NO");
        return 0;
      }
    }
    t2--;
  }
  puts("YES");
  return 0;
}
