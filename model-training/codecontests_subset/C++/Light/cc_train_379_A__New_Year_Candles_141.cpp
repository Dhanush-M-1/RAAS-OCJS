#include <bits/stdc++.h>
using namespace std;
int arr[100] = {0};
int main() {
  long long int n, m, b = 0;
  cin >> n >> m;
  long long int ans = n;
  while (n >= m) {
    ans += n / m;
    b = n % m;
    n /= m;
    n += b;
  }
  cout << ans << endl;
}
