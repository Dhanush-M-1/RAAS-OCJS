#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int tc;
  cin >> tc;
  while (tc--) {
    long long int a, b, c, ans;
    cin >> a >> b >> c;
    long long int kop = min(b, c / 2);
    ans = kop * 3;
    b -= kop;
    b /= 2;
    long long int joss = min(a, b);
    cout << ans + (joss * 3) << endl;
  }
}
