#include <bits/stdc++.h>
using namespace std;
int toint(string s) {
  int first = 0;
  int k = (int)pow(10, (double)s.length() - 1);
  for (int i = 0; i < (int)s.length(); i++) {
    first += (s[i] - '0') * k;
    k /= 10;
  }
  return first;
}
string tostr(int first) {
  if (first == 0) {
    return "0";
  }
  string s = "";
  bool f = first < 0;
  first = abs(first);
  while (first != 0) {
    s += (first % 10) + '0';
    first /= 10;
  }
  string t = "";
  if (f) {
    t = "-";
  }
  for (int i = s.length() - 1; i >= 0; i--) {
    t += s[i];
  }
  return t;
}
int gcd(int a, int b) {
  if (b == 0) {
    return a;
  }
  return gcd(b, a % b);
}
int factorial(int first) {
  int sum = 1;
  for (long long i = 1; i <= first; i++) {
    sum *= i;
  }
  return sum;
}
bool pr(int n) {
  for (int i = 2; i * i <= n; ++i) {
    if (n % i == 0) {
      return false;
    }
  }
  return true;
}
inline void out(int mas[], int s) {
  for (int i = 0; i < s; i++) {
    cout << mas[i] << endl;
  }
}
int sum(int n) {
  int first = 0;
  while (n) {
    first += n % 10;
    n /= 10;
  }
  return first;
}
inline int nxt() {
  int first;
  scanf("%d", &first);
  return first;
}
int main() {
  string s, s1;
  cin >> s >> s1;
  int n = nxt();
  vector<pair<string, string> > mas(n);
  for (int i = 0; i < n; i++) cin >> mas[i].first >> mas[i].second;
  cout << s << " " << s1 << endl;
  for (int i = 0; i < n; i++) {
    if (s == mas[i].first)
      s = mas[i].second;
    else if (s1 == mas[i].first)
      s1 = mas[i].second;
    else if (s == mas[i].second)
      s = mas[i].first;
    else if (s1 == mas[i].second)
      s1 = mas[i].first;
    cout << s << " " << s1 << endl;
  }
  return 0;
}
