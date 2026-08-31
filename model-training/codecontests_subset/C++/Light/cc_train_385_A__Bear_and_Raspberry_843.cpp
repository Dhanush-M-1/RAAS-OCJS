#include <bits/stdc++.h>
using namespace std;
long long a[100005], b[100005], c[100005], n, kq, m, d[100005], k;
string s;
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 2; i <= n; i++) kq = max(kq, a[i - 1] - a[i] - k);
  cout << kq;
}
