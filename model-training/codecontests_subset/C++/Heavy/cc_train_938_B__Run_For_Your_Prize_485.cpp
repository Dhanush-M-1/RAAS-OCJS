#include <bits/stdc++.h>
using namespace std;
int bmod(int a, int b, int m) {
  if (b == 0) return 1;
  int x = bmod(a, b / 2, m);
  x = (x * x) % m;
  if (b % 2 == 1) x = (x * a) % m;
  return x;
}
long long int a[3000007];
long long int mapp[3000007];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long int n, ans = -1, cnt1 = 1, cnt2 = 1, an1 = -1, an2 = -1;
  scanf("%lld", &n);
  for (int i = 0; i < n; i++) {
    scanf("%lld", &a[i]);
    mapp[a[i]] = 1;
  }
  for (int i = 2, j = 999999; i < j; i++, j--) {
    if (mapp[i] == 1) {
      an1 = cnt1;
    }
    if (mapp[j] == 1) {
      an2 = cnt2;
    }
    cnt1++;
    cnt2++;
  }
  ans = max(an1, an2);
  printf("%lld", ans);
}
