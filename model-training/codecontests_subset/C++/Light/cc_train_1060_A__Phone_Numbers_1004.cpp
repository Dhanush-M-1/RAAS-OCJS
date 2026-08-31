#include <bits/stdc++.h>
using namespace std;
int n, con;
char a[100000];
int main() {
  scanf("%d", &n);
  scanf("%s", a);
  for (int i = 0; i < n; ++i)
    if (a[i] == '8') con++;
  printf("%d\n", min(con, n / 11));
  return 0;
}
