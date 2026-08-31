#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
int n, m;
int p[1000010];
set<int> st[1000010];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &p[i]);
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    st[x].insert(y);
  }
  int x = p[n];
  for (int i = n - 1; i >= 1; i--) {
    int j = i;
    while (j < n && st[p[j]].find(p[j + 1]) != st[p[j]].end()) {
      swap(p[j], p[j + 1]);
      j++;
    }
  }
  int pos = 0;
  for (int i = 1; i <= n; i++)
    if (p[i] == x) pos = i;
  printf("%d", n - pos);
  return 0;
}
