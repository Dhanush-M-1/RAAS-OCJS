#include <bits/stdc++.h>
using namespace std;
char s[1000];
int a[50];
int main() {
  int n;
  scanf("%d", &n);
  scanf("%s", s + 1);
  for (int i = 1; i <= n; ++i) {
    a[s[i] - '0']++;
  }
  printf("%d\n", min(a[8], n / 11));
}
