#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T cal(T n, T k) {
  T sum = n, m;
  while (n >= k) {
    m = n % k;
    n /= k;
    sum += n;
    n += m;
  }
  return sum;
}
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  printf("%d\n", cal(a, b));
  return 0;
}
