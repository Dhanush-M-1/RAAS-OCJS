#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int sum = 0, mx = 0;
  for (int i = 0; i < n; i++) {
    int x;
    scanf("%d", &x);
    sum += x;
    if (mx < x) mx = x;
  }
  printf("%d\n", max(2 * sum / n + 1, mx));
}
