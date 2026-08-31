#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 5;
long long p[maxn];
long long has[maxn << 1];
int main() {
  long long n;
  long long bigger = 0, smaller = 0, equ = 0, ans1 = 0, ans2 = 0;
  scanf("%I64d", &n);
  for (long long i = 1LL; i <= n; i++) {
    scanf("%I64d", &p[i]);
    if (p[i] > i) {
      bigger++;
      has[p[i] - i]++;
    } else if (p[i] == i) {
      equ++;
      has[0]++;
    } else
      smaller++;
    ans1 += abs(p[i] - i);
  }
  long long temp = ans1;
  for (long long last = n - 1LL, now = 1LL; last >= 1LL; last--, now++) {
    temp += (equ + smaller);
    temp -= bigger;
    smaller += equ;
    bigger -= has[now];
    if (p[last + 1] >= last + 1LL) has[p[last + 1] - last - 1]--;
    has[p[last + 1] - 1 + now]++;
    equ = has[now];
    if (p[last + 1] > 1LL) bigger++;
    smaller = n - equ - bigger;
    temp -= abs(p[last + 1] - n - 1LL);
    temp += abs(p[last + 1] - 1LL);
    if (temp < ans1) {
      ans1 = temp;
      ans2 = now;
    }
  }
  printf("%I64d %I64d\n", ans1, ans2);
  return 0;
}
