#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  ;
  int k;
  cin >> k;
  ;
  int cnt = 0;
  ;
  cnt += n;
  while (n >= k) {
    cnt += n / k;
    n = n / k + n % k;
  }
  cout << cnt;
}
