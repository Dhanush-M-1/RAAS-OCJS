#include <bits/stdc++.h>
using namespace std;
int m[3];
int main() {
  int n;
  scanf("%d", &n);
  int tmp;
  int s = 0;
  for (int i = 0; i < n; i++) {
    scanf("%d", &tmp);
    m[tmp / 100]++;
  }
  s = (100 * m[1] + 200 * m[2]) / 2;
  s %= 200;
  if (s == 0)
    cout << "YES";
  else if (s == 100) {
    if (m[1] != 0)
      cout << "YES";
    else
      cout << "NO";
  } else
    cout << "NO";
  return 0;
}
