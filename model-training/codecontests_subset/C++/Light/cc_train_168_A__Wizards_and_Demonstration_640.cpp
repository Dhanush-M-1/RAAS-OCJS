#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  float n, x, y;
  cin >> n >> x >> y;
  float a = (n * y) / 100;
  if (ceil(a) > x)
    cout << ceil(a) - x;
  else
    cout << "0";
  cerr << "time taken : " << (float)clock() / CLOCKS_PER_SEC << " secs" << endl;
  return 0;
}
