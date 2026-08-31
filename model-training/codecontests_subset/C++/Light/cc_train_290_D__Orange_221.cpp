#include <bits/stdc++.h>
using namespace std;
char a[100];
int b[100];
char ans[100];
int k;
int main() {
  while (scanf("%s %d", a, &k) != EOF) {
    int len = strlen(a);
    for (int i = 0; i < len; i++) {
      if (a[i] <= 'z' && a[i] >= 'a')
        b[i] = a[i] - 'a';
      else
        b[i] = a[i] - 'A';
    }
    for (int i = 0; i < len; i++) {
      if (b[i] < k)
        ans[i] = b[i] + 'A';
      else
        ans[i] = b[i] + 'a';
    }
    ans[len] = 0;
    puts(ans);
  }
}
