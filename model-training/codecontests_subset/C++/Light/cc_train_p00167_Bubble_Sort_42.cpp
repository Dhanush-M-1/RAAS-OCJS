#include <bits/stdc++.h>
#define rep(i, n) for (int i = 0; i < (n); i++)
#define shosu(n) setprecision(n)
#define INF 1000000000;
using namespace std;

int main() {
  int n;
  while (cin >> n, n) {
    int d[n], ans = 0;
    rep(i, n) cin >> d[i];
    for (int i = 1; i < n; i++)
      for (int j = 0; j < n - i; j++)
        if (d[j] > d[j + 1]) {
          swap(d[j], d[j + 1]);
          ans++;
        }
    cout << ans << endl;
  }
  return 0;
}