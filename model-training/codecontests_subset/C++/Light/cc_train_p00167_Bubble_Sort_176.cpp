#include <cstdio>
using namespace std;

int bsort(int *a, int n) {
  int t, c = 0;
  for (int i=0; i<n-1; i++) {
    for (int j=0; j<n-i-1; j++) {
      if (a[j] > a[j+1]) {
        t = a[j];
        a[j] = a[j+1];
        a[j+1] = t;
        ++c;
      }
    }
  }
  return c;
}

int main() {
  int n, a[100];
  while (1) {
    scanf("%d", &n);
    if (!n) break;
    for (int i=0; i<n; i++) {
      scanf("%d", &a[i]);
    }
    printf("%d\n", bsort(a, n));
  }
  return 0;
}