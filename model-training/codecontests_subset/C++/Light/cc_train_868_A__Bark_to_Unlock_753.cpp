#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  string s[105];
  cin >> a;
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s[i];
    if (s[i] == a) {
      puts("YES");
      return 0;
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      b = s[i] + s[j];
      if (b[1] == a[0] && b[2] == a[1]) {
        puts("YES");
        return 0;
      }
    }
  }
  puts("NO");
  return 0;
}
