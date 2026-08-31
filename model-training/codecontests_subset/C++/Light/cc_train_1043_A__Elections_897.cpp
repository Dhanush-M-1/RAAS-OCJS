#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, n, a, maxx, i, sum;
  int m[102];
  cin >> n;
  maxx = 0;
  for (i = 0; i < n; i++) {
    cin >> m[i];
    maxx = max(m[i], maxx);
  }
  sum = 0;
  for (i = 0; i < n; i++) {
    sum += m[i];
  }
  a = 0;
  a = maxx * n - sum;
  if (sum < a) {
    cout << maxx;
  } else {
    while (sum >= a) {
      maxx++;
      a += n;
    }
    cout << maxx;
  }
  return 0;
}
