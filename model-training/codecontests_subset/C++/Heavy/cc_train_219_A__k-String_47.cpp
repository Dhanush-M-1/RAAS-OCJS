#include <bits/stdc++.h>
const long long INF = 1 << 28;
using namespace std;
long long POWER(long long base, long long expo) {
  long long num = 1;
  long long i = expo;
  while (i) {
    num = num * base;
    i--;
  }
  return num;
}
int main() {
  long long t = 1;
  while (t--) {
    long long k;
    cin >> k;
    string s;
    cin >> s;
    long long a[27] = {0};
    for (long long i = 0; i < s.length(); i++) a[s[i] - 'a']++;
    for (long long i = 0; i <= 26; i++) {
      if (a[i] % k != 0) {
        cout << -1;
        return 0;
      }
    }
    vector<char> v;
    for (long long i = 0; i <= 26; i++) {
      if (a[i] != 0) {
        for (long long j = 1; j <= a[i] / k; j++) {
          v.push_back(char(i + 'a'));
        }
      }
    }
    for (long long j = 1; j <= k; j++) {
      for (long long i = 0; i < v.size(); i++) cout << v[i];
    }
  }
  return 0;
}
