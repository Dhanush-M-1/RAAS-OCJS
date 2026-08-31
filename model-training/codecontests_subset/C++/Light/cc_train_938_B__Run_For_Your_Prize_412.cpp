#include <bits/stdc++.h>
using namespace std;
void A7med_S3d() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
bool isprime(long long n) {
  if (n == 2) return true;
  if (n < 2 || n % 2 == 0) return false;
  for (long long i = 3; i * i <= n; i += 2)
    if (n % i == 0) return false;
  return true;
}
long long fact(short n) {
  long long sum = 1;
  if (n == 1) return sum;
  for (int i = 2; i <= n; i++) sum *= i;
  return sum;
}
int main() {
  A7med_S3d();
  int x;
  cin >> x;
  int a, ans = 0, mx = 0;
  for (int i = 0; i < x; i++) {
    cin >> a;
    if (a - 1 <= 1000000 - a)
      ans = a - 1;
    else
      ans = 1000000 - a;
    mx = max(mx, ans);
  }
  cout << mx << endl;
  return 0;
}
