#include <bits/stdc++.h>
using namespace std;
char a[110];
int main() {
  int n;
  scanf("%d", &n);
  cin >> a;
  int t = n / 11;
  int m = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] == '8') m++;
  }
  t = min(t, m);
  printf("%d", t);
  return 0;
}
