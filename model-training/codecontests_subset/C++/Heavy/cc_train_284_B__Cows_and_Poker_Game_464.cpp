#include <bits/stdc++.h>
using namespace std;
long long countdigit(long long n);
long long power(long long x, long long y);
long long eg(long long a, long long b);
bool isprime(long long n);
vector<long long> aaja(long long n);
vector<long long> soe(long long n);
vector<long long> aaja(long long n) {
  long long i, j;
  vector<long long> v;
  for (i = 0; i < n; i++) {
    cin >> j;
    v.push_back(j);
  }
  return v;
}
long long mjekrtehai() {
  long long i, n, a = 0, I = 0;
  string s;
  cin >> n >> s;
  for (i = 0; i < s.size(); i++) {
    if (s[i] == 'A') a++;
    if (s[i] == 'I') I++;
  }
  if (I and I <= 1) {
    cout << 1 << "\n";
    return 0;
  } else if (I > 1) {
    cout << 0 << "\n";
    return 0;
  }
  cout << a << "\n";
  return 0;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  while (t--) mjekrtehai();
  return 0;
}
