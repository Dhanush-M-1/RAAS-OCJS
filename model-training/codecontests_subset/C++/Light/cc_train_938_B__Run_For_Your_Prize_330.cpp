#include <bits/stdc++.h>
using namespace std;
int n, a, c[1000005];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a);
    c[a]++;
  }
  int sol = 0, p1 = 1, p2 = 1e6, can = 0;
  while (can < n) {
    p1++;
    p2--;
    can += c[p1] + c[p2];
    sol++;
  }
  printf("%d\n", sol);
  return 0;
}
