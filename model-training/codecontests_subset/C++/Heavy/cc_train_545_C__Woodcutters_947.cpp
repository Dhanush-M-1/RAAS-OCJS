#include <bits/stdc++.h>
using namespace std;
struct X {
  long long x, h;
};
X ara[100005];
bool func(X a, X b) { return a.x < b.x; }
int main() {
  long long n;
  scanf("%I64d", &n);
  for (long long i = 0; i < n; i++) {
    scanf("%I64d%I64d", &ara[i].x, &ara[i].h);
  }
  sort(ara, ara + n, func);
  long long c = 1;
  long long occup = ara[0].x;
  for (long long i = 1; i < n - 1; i++) {
    if (ara[i].x - ara[i].h > occup) {
      occup = ara[i].x;
      c++;
    } else if (ara[i].x + ara[i].h < ara[i + 1].x) {
      occup = ara[i].x + ara[i].h;
      c++;
    } else {
      occup = ara[i].x;
    }
  }
  if (n > 1) {
    c++;
  }
  printf("%I64d\n", c);
}
