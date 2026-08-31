#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n, flag = 0;
    cin >> n;
    long long m[n], a[n], i;
    for (int i = 1; i <= n; i++) cin >> m[i];
    if (m[1] + m[2] <= m[n])
      cout << "1 2 " << n << endl;
    else
      cout << "-1" << endl;
  }
  return 0;
}
