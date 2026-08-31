#include <bits/stdc++.h>
using namespace std;
const int N = 110;
int n, s, ma;
int a[N];
int main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i], s += a[i], ma = max(ma, a[i]);
  while (ma * n <= s * 2) ma++;
  cout << ma;
}
