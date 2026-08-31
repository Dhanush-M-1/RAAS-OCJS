#include <bits/stdc++.h>
using namespace std;
unsigned long long mod = 998244353;
string a[100005];
multiset<unsigned long long> s;
map<unsigned long long, unsigned long long> mp;
int main() {
  unsigned long long n;
  cin >> n;
  unsigned long long ans = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    mp[a[i].length()] += 1;
  }
  for (int i = 0; i < n; i++) {
    for (map<unsigned long long, unsigned long long>::iterator it = mp.begin();
         it != mp.end(); it++) {
      unsigned long long fir = it->first;
      unsigned long long sec = it->second;
      unsigned long long t1 = 0;
      unsigned long long t2 = 0;
      unsigned long long t = 0;
      unsigned long long temp;
      if (fir < a[i].length()) {
        for (int j = 0; j < a[i].length() - fir; j++) {
          t *= 10;
          t += (a[i][j] - '0');
        }
        t1 = t;
        t2 = t;
        for (int j = a[i].length() - fir; j <= a[i].length() - 1; j++) {
          t1 *= 100;
          t1 += (a[i][j] - '0');
          t2 *= 10;
          t2 += (a[i][j] - '0');
          t2 *= 10;
        }
        temp = t1 + t2;
      } else if (fir == a[i].length()) {
        for (int j = 0; j < a[i].length(); j++) {
          t *= 10;
          t += (a[i][j] - '0');
          t *= 10;
          t += (a[i][j] - '0');
        }
        temp = t;
      } else {
        for (int j = 0; j < a[i].length(); j++) {
          t1 *= 100;
          t1 += (a[i][j] - '0');
          t2 *= 10;
          t2 += (a[i][j] - '0');
          t2 *= 10;
        }
        temp = t1 + t2;
      }
      temp %= mod;
      temp *= sec;
      temp %= mod;
      ans += temp;
      ans %= mod;
    }
  }
  cout << ans;
  return 0;
}
