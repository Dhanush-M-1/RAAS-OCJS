#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  std::cout.tie(NULL);
  int n, k, c, i, j;
  cin >> k;
  string a;
  cin >> a;
  c = 0;
  int z[27] = {0};
  int z1[27] = {0};
  for (i = 0; a[i] != '\0'; i++) {
    if ((int)a[i] >= 97 && (int)a[i] <= 122) {
      z[(int)a[i] - 97]++;
    }
  }
  string b = "";
  for (i = 0; i < 26; i++) {
    if (z[i] != 0) {
      if (z[i] % k == 0)
        z1[i] = z[i] / k;
      else {
        c = -1;
        break;
      }
    }
  }
  if (c == -1)
    cout << -1;
  else {
    for (i = 0; i < 26; i++) {
      while (z1[i]--) {
        b += (char)i + 97;
      }
    }
    while (k--) cout << b;
  }
  return 0;
}
