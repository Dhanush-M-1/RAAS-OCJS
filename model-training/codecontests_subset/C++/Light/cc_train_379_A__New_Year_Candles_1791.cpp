#include <bits/stdc++.h>
using namespace std;
int calc(int a, int b, int cnt) {
  if (a < b) return cnt;
  cnt += a / b;
  a = a / b + a % b;
  return calc(a, b, cnt);
}
int main() {
  int a, b;
  scanf("%d%d", &a, &b);
  int cnt = a;
  printf("%d", calc(a, b, cnt));
  return 0;
}
