#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i = 0, res = 0;
  cin >> n;
  int h[n], a[n];
  while (i < n) {
    cin >> h[i] >> a[i];
    i++;
  }
  for (i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (h[i] == a[j]) res++;
  cout << res;
  return 0;
}
