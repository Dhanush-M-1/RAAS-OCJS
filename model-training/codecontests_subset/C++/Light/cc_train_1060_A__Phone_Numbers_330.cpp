#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string str;
  scanf("%d", &n);
  cin >> str;
  int c = 0;
  for (int i = 0; i < n; i++) {
    if (str[i] == '8') {
      c++;
    }
  }
  int ans = min(n / 11, c);
  printf("%d\n", ans);
}
