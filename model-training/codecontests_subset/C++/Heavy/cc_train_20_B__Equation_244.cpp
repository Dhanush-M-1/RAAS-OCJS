#include <bits/stdc++.h>
using namespace std;
const long long int maxn = 200005;
vector<long long int> adj[maxn];
long long int a[maxn], jvb[maxn];
int main() {
  ios_base::sync_with_stdio(false);
  double a, b, c, delta = 0;
  cin >> a >> b >> c;
  double rt1, rt2;
  cout << fixed << setprecision(12);
  if (a == 0 && b == 0) {
    if (c == 0) {
      cout << "-1";
    } else
      cout << '0';
    return 0;
  }
  if (a == 0) {
    cout << '1' << "\n" << -c / b;
    return 0;
  }
  delta = (b * b) - ((double)4 * a * c);
  delta = sqrt(delta);
  if (delta < 0) {
    cout << '0';
    return 0;
  }
  rt1 = (((double)-1 * b) + delta) / ((double)2 * a);
  rt2 = (((double)-1 * b) - delta) / ((double)2 * a);
  if (delta == 0) {
    cout << '1' << "\n";
    cout << rt1;
    return 0;
  }
  if (rt1 > rt2) swap(rt1, rt2);
  cout << '2' << "\n" << rt1 << "\n" << rt2;
}
