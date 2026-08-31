#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long arr[10] = {0};
  for (long long i = 0; i < n; i++) {
    arr[s[i] - '0']++;
  }
  long long v = arr[8];
  long long sum = 0;
  for (long long i = 0; i < 10; i++) {
    if (i != 8) {
      sum += arr[i];
    }
  }
  long long x = sum / 10;
  long long z = sum % 10;
  if (v <= x) {
    cout << v << "\n";
  } else {
    long long ans = x;
    long long p = v - x;
    if (p >= 11 - z) {
      ans++;
      p -= (11 - z);
    }
    ans += (p / 11);
    cout << ans << "\n";
  }
  return 0;
}
