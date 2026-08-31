#include <bits/stdc++.h>
using namespace std;
const long long inff = 0x3f3f3f3f3f3f3f3f;
int n, x, y, du[100008];
int main() {
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i(1); i <= (n - 1); ++i) {
    scanf("%d", &x), scanf("%d", &y);
    du[x]++, du[y]++;
  }
  for (int i(1); i <= (n); ++i)
    if (du[i] == 2) return puts("NO"), 0;
  puts("YES");
  return 0;
}
