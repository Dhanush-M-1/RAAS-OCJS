#include <bits/stdc++.h>
using namespace std;
long long bigmod(long long a, long long b, long long m) {
  if (b == 0) return 1 % m;
  long long first = bigmod(a, b / 2, m);
  first = (first * first) % m;
  if (b % 2 == 1) first = (first * a) % m;
  return first;
}
int fx[] = {0, 0, -1, 1, -1, 1, -1, 1};
int fy[] = {1, -1, 0, 0, 1, 1, -1, -1};
int main() {
  ios::sync_with_stdio(false);
  int n;
  cin >> n;
  long long a[n + 1][2];
  int i;
  for (i = 0; i < n; i++) {
    cin >> a[i][0] >> a[i][1];
  }
  a[n][0] = LONG_LONG_MAX;
  int temp = a[0][0], ans = 1;
  for (i = 1; i < n; i++) {
    if (a[i][0] - a[i][1] > temp)
      ans++, temp = a[i][0];
    else if (a[i][0] + a[i][1] < a[i + 1][0])
      ans++, temp = a[i][0] + a[i][1];
    else
      temp = a[i][0];
  }
  cout << ans;
  return 0;
}
