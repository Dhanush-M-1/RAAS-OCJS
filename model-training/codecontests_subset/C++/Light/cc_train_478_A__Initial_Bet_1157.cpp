#include <bits/stdc++.h>
using namespace std;
long long min(long long a, long long b) {
  if (a <= b)
    return a;
  else
    return b;
}
long long max(long long a, long long b) {
  if (a >= b)
    return a;
  else
    return b;
}
long long ceil(long long a, long long b) {
  long long res = a / b;
  if (res * b != a) res++;
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T = 1;
  while (T--) {
    vector<int> v(5);
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      cin >> v[i];
      sum += v[i];
    }
    if (sum % 5 == 0 && sum / 5 > 0)
      cout << sum / 5;
    else
      cout << -1;
  }
}
