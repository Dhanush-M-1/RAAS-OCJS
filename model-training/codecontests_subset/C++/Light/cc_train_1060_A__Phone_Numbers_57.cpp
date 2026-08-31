#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, cnt = 0, temp;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%01d", &temp);
    if (temp == 8) cnt++;
  }
  printf("%d\n", min(cnt, n / 11));
}
