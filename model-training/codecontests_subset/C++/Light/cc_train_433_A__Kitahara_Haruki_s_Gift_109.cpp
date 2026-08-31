#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e4;
int cnt1, cnt2;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x == 100) cnt1++;
  }
  if ((cnt1 & 1) || (n % 2 == 1 && cnt1 == 0))
    puts("NO");
  else
    puts("YES");
  return 0;
}
