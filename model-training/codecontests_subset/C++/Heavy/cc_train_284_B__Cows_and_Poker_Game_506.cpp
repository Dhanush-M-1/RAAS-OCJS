#include <bits/stdc++.h>
using namespace std;
bool sortinrev(const pair<long long, long long> &a,
               const pair<long long, long long> &b) {
  return (a.first > b.first);
}
long long isPrime(long long n) {
  if (n <= 1) return 0;
  for (long long i = 2; i < n; i++)
    if (n % i == 0) return 0;
  return 1;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  map<char, long long> m;
  string s;
  cin >> s;
  for (long long i = 0; i < s.size(); i++) m[s[i]]++;
  if (m['I'] > 1) {
    cout << "0";
    return 0;
  } else if (m['I'] == 1) {
    cout << "1";
    return 0;
  } else {
    cout << m['A'];
    return 0;
  }
}
