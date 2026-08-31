#include <bits/stdc++.h>
using namespace std;
const long long mod = 1000000007;
template <typename T>
T gcd(T a, T b) {
  return b != 0 ? gcd(b, a % b) : a;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  long long n;
  cin >> n;
  map<long long, long long> m;
  long long a[n];
  long long t;
  for (int i = 0; i < n; i++) {
    cin >> a[i] >> t;
    m[a[i]] = t;
  }
  if (n == 1) {
    cout << 1;
    return 0;
  }
  if (n == 2) {
    cout << 2;
    return 0;
  }
  long long last = a[0];
  long long count = 2;
  for (int i = 1; i < n - 1; i++) {
    int flag = 0, flag1 = 0;
    if (a[i] - last > m[a[i]]) {
      last = a[i];
      count++;
      flag = 1;
    }
    if (flag == 0) {
      if (a[i] + m[a[i]] < a[i + 1]) {
        last = a[i] + m[a[i]];
        count++;
        flag1 = 1;
      }
      if (flag == 0 && flag1 == 0) {
        last = a[i];
      }
    }
  }
  cout << count << " ";
  return 0;
}
