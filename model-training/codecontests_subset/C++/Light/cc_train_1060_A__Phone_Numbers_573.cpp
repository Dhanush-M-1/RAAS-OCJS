#include <bits/stdc++.h>
using namespace std;
int n;
char s[101];
int main() {
  while (scanf("%d", &n) != EOF) {
    int count = 0;
    scanf("%s", s);
    for (int i = 0; i < n; i++) {
      if (s[i] == '8') count++;
    }
    int ans = n / 11;
    cout << min(count, ans) << endl;
  }
  return 0;
}
