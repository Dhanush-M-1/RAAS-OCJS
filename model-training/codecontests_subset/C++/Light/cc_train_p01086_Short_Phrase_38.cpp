#include <bits/stdc++.h>
using namespace std;

int seps[] = {5, 7, 5, 7, 7};

int n;
char buf[114514];
int gs[114514];

int main() {
  while (1) {
    scanf("%d", &n);
    if (n == 0) return 0;

    for (int i=0; i<n; i++) {
      scanf("%s", buf);
      gs[i] = strlen(buf);
    }

    for (int i=0; i<n; i++) {
      int k = 0;
      int sum = 0;
      bool fail = false;
      for (int j=i; j<n; j++) {
        sum += gs[j];

        if (seps[k] < sum) {
          fail = true;
          break;
        }

        if (seps[k] == sum) {
          ++k;
          sum = 0;
        }

        if (k == 5) break;
      }

      if (k != 5) fail = true;
      if (!fail) {
        printf("%d\n", i+1);
        break;
      }
    }
  }
}