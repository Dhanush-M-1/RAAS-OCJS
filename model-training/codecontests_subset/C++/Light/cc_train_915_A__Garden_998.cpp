#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:10000000")
using namespace std;
const double PI = acos(-1.0);
const int INF = 1e9;
const int MOD = INF + 7;
const long long BIGINF = 1e16;
int n, k, elem, mini = 1e9;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    cin >> elem;
    if (k % elem == 0) mini = min(k / elem, mini);
  }
  cout << mini << '\n';
  return 0;
}
