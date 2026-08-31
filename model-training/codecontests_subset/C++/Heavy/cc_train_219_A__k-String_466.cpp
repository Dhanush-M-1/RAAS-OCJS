#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
string to_string(int a) {
  ostringstream temp;
  temp << a;
  return temp.str();
}
bool is_prime(long long n) {
  long long k = sqrt(n);
  for (long long i = 2; i <= k; i++) {
    if (n % i == 0) return false;
  }
  return true;
}
bool is_palindrome(vector<int> a, int n) {
  int ans = 0;
  for (int i = (int)(0); i < (int)(n / 2); ++i) {
    if (a[i] != a[i + (n / 2)]) ans++;
  }
  if (ans == 0)
    return true;
  else
    return false;
}
int solve() {
  string a;
  cin >> a;
  vector<int> m;
  for (int i = (int)(0); i < (int)(a.size()); ++i) {
    if (a[i] == a[i + 1] && a[i] != '?') {
      cout << -1 << "\n";
      return 0;
    }
    if (a[i] == '?') m.push_back(i);
  }
  for (int i = (int)(0); i < (int)(m.size()); ++i) {
    if (a[m[i] - 1] == 'a') {
      (a[m[i] + 1] == 'b') ? a[m[i]] = 'c' : a[m[i]] = 'b';
    } else if (a[m[i] - 1] == 'b') {
      (a[m[i] + 1] == 'c') ? a[m[i]] = 'a' : a[m[i]] = 'c';
    } else
      (a[m[i] + 1] == 'a') ? a[m[i]] = 'b' : a[m[i]] = 'a';
  }
  cout << a << "\n";
  return 0;
}
int check(int n) {
  while (!is_prime(n)) {
    n++;
  }
  return n;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int k;
  cin >> k;
  string s;
  cin >> s;
  map<char, int> m;
  string f = s.substr(0, (s.size() / k));
  if (s.size() % k != 0) {
    cout << -1;
    return 0;
  }
  string d;
  for (int i = (int)(0); i < (int)(s.size()); ++i) m[s[i]]++;
  map<char, int>::iterator it;
  for (it = m.begin(); it != m.end(); it++) {
    if ((it->second) % k != 0) {
      cout << -1;
      return 0;
    }
    for (int i = (int)(0); i < (int)((it->second) / k); ++i) d += it->first;
  }
  for (int i = (int)(0); i < (int)(k); ++i) {
    cout << d;
  }
  return 0;
}
