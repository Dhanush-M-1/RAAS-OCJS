#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string s;
  cin >> n >> s;
  int k = 0;
  for (int i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      k = i;
    }
  }
  if (k)
    printf("YES\n%d %d", k, k + 1);
  else
    printf("NO");
}
