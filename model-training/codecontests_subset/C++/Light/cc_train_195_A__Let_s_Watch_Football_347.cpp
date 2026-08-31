#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1e9 + 7;
const long long LINF = INF * 1LL * INF;
const int MAXN = 100500;
const double EPS = 1e-5;
int a, b, c;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> a >> b >> c;
  int top = (a * c + b - 1) / b;
  for (int i = 1; i <= top; ++i)
    if ((i + c) * b >= a * c) {
      cout << i;
      break;
    }
  return 0;
}
