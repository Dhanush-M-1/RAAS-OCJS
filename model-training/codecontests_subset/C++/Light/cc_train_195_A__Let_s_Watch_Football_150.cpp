#include <bits/stdc++.h>
using namespace std;
double a, b, c, ans;
int xceptor() {
  cin >> a >> b >> c;
  ans = ((a - b) * c) / b;
  cout << (long long)(ceil(ans * 1LL)) << endl;
  return 0;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  return xceptor();
}
