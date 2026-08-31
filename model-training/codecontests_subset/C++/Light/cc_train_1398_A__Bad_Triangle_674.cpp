#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
int main() {
  int t;
  scanf("%d", &t);
  ;
  while (t--) {
    int n;
    scanf("%d", &n);
    ;
    long long arr[n];
    for (int i = 0; i < n; i++) scanf("%lld", &arr[i]);
    ;
    if (arr[0] + arr[1] <= arr[n - 1]) {
      cout << 1 << " " << 2 << " " << n << "\n";
    } else {
      cout << -1 << "\n";
    }
  }
}
