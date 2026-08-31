#include <bits/stdc++.h>
using namespace std;
vector<bool> prime(1000000000 + 1, 1);
void SieveOfEratosthenes(int n) {
  prime[0] = 0;
  prime[1] = 0;
  for (long long unsigned int p = 2; p * p <= n; p++) {
    if (prime[p] == true) {
      for (long long unsigned int i = p * p; i <= n; i += p) prime[i] = false;
    }
  }
}
long long unsigned int countDivisors(long long unsigned int n) {
  long long unsigned int cnt = 0;
  for (long long unsigned int i = 1; i <= sqrt(n); i++) {
    if (n % i == 0) {
      if (n / i == i)
        ++cnt;
      else
        cnt += 2;
    }
  }
  return cnt;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, ans = 0, ans1 = 0;
    cin >> a >> b >> c;
    int a1 = a, b1 = b, c1 = c;
    int temp = min(b / 2, a);
    ans += temp * 3;
    a -= temp;
    b -= temp * 2;
    int temp1 = min(b, c / 2);
    ans += temp1 * 3;
    b -= temp1;
    c -= temp1 * 2;
    int temp_ = min(b1, c1 / 2);
    ans1 += temp_ * 3;
    b1 -= temp_;
    c1 -= temp_ * 2;
    int temp1_ = min(b1 / 2, a1);
    ans1 += temp1_ * 3;
    a1 -= temp1_;
    b1 -= temp1_ * 2;
    cout << max(ans, ans1) << endl;
  }
  return 0;
}
