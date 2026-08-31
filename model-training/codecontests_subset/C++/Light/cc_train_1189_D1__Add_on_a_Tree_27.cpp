#include <bits/stdc++.h>
const int inff = 0x3f3f3f3f;
const double eqs = 1e-9;
const double E = 2.718281828459;
const double pi = acos(-1.0);
using namespace std;
const int maxn = 1e5 + 5;
int in[maxn];
int main() {
  int n, x, y;
  cin >> n;
  for (int i = 1; i <= n; i++) in[i] = 0;
  for (int i = 1; i < n; i++) {
    scanf("%d %d", &x, &y);
    in[x]++, in[y]++;
  }
  for (int i = 1; i <= n; i++)
    if (in[i] == 2) {
      puts("NO");
      return 0;
    }
  puts("YES");
  return 0;
}
