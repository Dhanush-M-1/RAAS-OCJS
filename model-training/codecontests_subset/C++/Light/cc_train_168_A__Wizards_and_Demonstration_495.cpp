#include <bits/stdc++.h>
using namespace std;
long x, y, z;
string s;
bool bb;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> x >> y >> z;
  cout << max((int)(ceil((z / 100.0) * x) - y), 0);
}
