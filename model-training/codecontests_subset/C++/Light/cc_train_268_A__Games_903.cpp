#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int i, n, j, c = 0;
  cin >> n;
  int s[n];
  int a[n];
  for (i = 0; i < n; i++) cin >> s[i] >> a[i];
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++)
      if (i != j && s[i] == a[j]) c++;
  }
  cout << c;
  return (0);
}
