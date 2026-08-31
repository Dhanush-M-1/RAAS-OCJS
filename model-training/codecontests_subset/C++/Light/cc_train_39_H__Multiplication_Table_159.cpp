#include <bits/stdc++.h>
using namespace std;
int turn(int src, int n) { return src % n + src / n * 10; }
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      printf(" %2d", turn(i * j, n));
    }
    printf("\n");
  }
  return 0;
}
