#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, n = 0;
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    printf("%d ", i);
    for (int j = 2; j < n; j++) {
      a = (i * j) / n;
      a = a * 10;
      a += (i * j) % n;
      printf("%d ", a);
    }
    cout << endl;
  }
  return 0;
}
