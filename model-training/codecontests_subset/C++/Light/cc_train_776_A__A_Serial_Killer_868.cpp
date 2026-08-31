#include <bits/stdc++.h>
using namespace std;
long long power(long long b, long long e, long long m) {
  if (e == 0) return 1;
  if (e == 1) return b;
  if (e % 2 == 0)
    return power(b * b % m, e / 2, m);
  else
    return b * power(b * b % m, (e - 1) / 2, m) % m;
}
bool is_prime(long long n) {
  long long k = sqrt(n);
  for (long long i = 2; i <= k; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  string s1, s2, temp1, temp2;
  cin >> s1 >> s2;
  long long n, i;
  cin >> n;
  cout << s1 << " " << s2 << "\n";
  for (i = 0; i < n; i++) {
    cin >> temp1 >> temp2;
    if (!temp1.compare(s2))
      s2 = temp2;
    else
      s1 = temp2;
    cout << s1 << " " << s2 << "\n";
  }
  return 0;
}
