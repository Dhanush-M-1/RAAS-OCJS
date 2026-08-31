#include <bits/stdc++.h>
using namespace std;
int num[100];
int main() {
  int k;
  while (~scanf("%d", &k)) {
    for (int i = 1; i < k; i++) {
      for (int j = 1; j < k; j++) {
        int x = i * j;
        int cnt = 0;
        while (x) {
          num[++cnt] = x % k;
          x /= k;
        }
        for (int i = cnt; i >= 1; i--) {
          printf("%d", num[i]);
        }
        if (j == k - 1)
          putchar('\n');
        else
          putchar(' ');
      }
    }
  }
}
