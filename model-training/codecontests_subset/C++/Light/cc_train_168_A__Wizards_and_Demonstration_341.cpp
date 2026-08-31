#include <bits/stdc++.h>
using namespace std;
int xx[] = {1, 1, 1, 0, -1, -1, -1, 0};
int yy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
int rx[] = {1, -1, 0, 0};
int ry[] = {0, 0, 1, -1};
long long int gcd(long long int a, long long int b) {
  return ((a % b == 0) ? b : gcd(b, a % b));
}
vector<int> g[250];
int main() {
  int n, x, y, ans;
  cin >> n >> x >> y;
  ans = ceil((double)(n * y) / 100);
  ans = ans - x;
  if (ans < 0) ans = 0;
  cout << ans << endl;
  return 0;
}
