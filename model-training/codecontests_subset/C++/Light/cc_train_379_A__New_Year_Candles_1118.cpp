#include <bits/stdc++.h>
using namespace std;
int A, B;
int main() {
  cin >> A >> B;
  int ans = A;
  while (A >= B) {
    int newCandle = A / B;
    ans += newCandle;
    A = A % B + newCandle;
  }
  cout << ans;
  return 0;
}
