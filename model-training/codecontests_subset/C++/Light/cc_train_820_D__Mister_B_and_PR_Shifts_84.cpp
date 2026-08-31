#include <bits/stdc++.h>
using namespace std;
long long n, no, add, a[1000100], cf[1000100];
int main() {
  scanf("%lld", &n);
  for (int i = 1; i <= n; ++i)
    scanf("%lld", &a[i]), ++cf[(a[i] + n - i) % n], no += abs(a[i] - i),
        a[i] >= i ? --add : ++add;
  long long ans = no, id = 0;
  for (int i = 1; i < n; ++i)
    add += cf[i - 1] * 2 - 2,
        no += abs(a[n - i + 1] - 1) - abs(a[n - i + 1] - n) + 1 + add,
        no < ans ? ans = no, id = i : 0;
  printf("%lld %lld", ans, id);
}
