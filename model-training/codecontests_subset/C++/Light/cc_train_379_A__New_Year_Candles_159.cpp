#include <bits/stdc++.h>
using namespace std;
long long mem[20];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long a, b, cnt = 0;
  cin >> a >> b;
  a *= b;
  a--;
  b--;
  a /= b;
  cout << a << endl;
}
