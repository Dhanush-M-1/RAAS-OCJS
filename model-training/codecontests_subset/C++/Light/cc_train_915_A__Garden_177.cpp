#include <bits/stdc++.h>
using namespace std;
int a;
int ans, Ans = 10000;
int n, k;
int main() {
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    cin >> a;
    if (a > k) continue;
    if (k % a == 0) {
      ans = k / a;
      if (ans < Ans) Ans = ans;
    }
  }
  cout << Ans;
  return 0;
}
