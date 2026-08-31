#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x;
  scanf("%d", &n);
  int asum = 0, bsum = 0, csum = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    asum += x;
  }
  for (int i = 1; i < n; i++) {
    scanf("%d", &x);
    bsum += x;
  }
  for (int i = 2; i < n; i++) {
    scanf("%d", &x);
    csum += x;
  }
  printf("%d\n%d", asum - bsum, bsum - csum);
}
