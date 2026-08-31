#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  string s;
  cin >> s;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      printf("YES\n%d %d\n", i + 1, i + 2);
      return 0;
    }
  }
  printf("NO\n");
  return 0;
}
