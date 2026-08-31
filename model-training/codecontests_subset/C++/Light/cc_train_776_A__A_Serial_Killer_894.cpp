#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3fffffff;
const int SINF = 0x7fffffff;
const long long LINF = 0x3fffffffffffffff;
const long long SLINF = 0x7fffffffffffffff;
const int MAXN = 1007;
int n;
string a, b, nk, np;
void init();
void input();
void work();
int main() {
  init();
  input();
  work();
}
void init() { ios::sync_with_stdio(false); }
void input() {}
void work() {
  cin >> a >> b;
  cin >> n;
  cout << a << " " << b << endl;
  for (int i = 1; i <= n; ++i) {
    cin >> nk >> np;
    if (a == nk)
      a = np;
    else
      b = np;
    cout << a << " " << b << endl;
  }
}
