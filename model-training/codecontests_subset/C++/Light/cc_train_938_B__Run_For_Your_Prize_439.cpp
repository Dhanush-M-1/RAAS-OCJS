#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-10;
long long a[100005];
int main(int argc, char** argv) {
  string s;
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i]);
  long long mx = a[n] - 1;
  for (int i = 1; i <= n; i++) {
    mx = min(mx, max(1000000 - a[i], a[i - 1] - 1));
  }
  cout << mx;
  return 0;
}
