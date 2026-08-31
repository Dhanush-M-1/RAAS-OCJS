#include <bits/stdc++.h>
using namespace std;
void init() {}
const long double EPS = 1e-12;
int main() {
  init();
  vector<char> p;
  long long n = 0, a = 1, b = 0;
  string s;
  while (true) {
    cin >> s;
    if (s == "+") {
      p.push_back('+');
      a++;
    }
    if (s == "-") {
      p.push_back('-');
      b++;
    }
    if ('0' <= s[0] && s[0] <= '9') {
      for (int i = 0; i < (int)s.length(); i++) n = n * 10 + s[i] - '0';
      break;
    }
  }
  if (a * n - b < n || a - b * n > n) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  long long sa = n * a;
  long long sb = b;
  long long d = sa - sb - n;
  vector<long long> aa;
  for (int i = 0; i < a; i++) aa.push_back(n);
  vector<long long> bb;
  for (int i = 0; i < b; i++) bb.push_back(1);
  for (int i = 0; d > 0 && i < a; i++) {
    if (d > n - 1) {
      aa[i] = 1;
      d -= n - 1;
    } else {
      aa[i] -= d;
      d = 0;
    }
  }
  for (int i = 0; d > 0 && i < b; i++) {
    if (d > n - 1) {
      bb[i] = n;
      d -= n - 1;
    } else {
      bb[i] += d;
      d = 0;
    }
  }
  cout << aa.back();
  aa.pop_back();
  for (int i = 0; i < (int)p.size(); i++) {
    cout << " " << p[i] << " ";
    if (p[i] == '+') {
      cout << aa.back();
      aa.pop_back();
    } else {
      cout << bb.back();
      bb.pop_back();
    }
  }
  cout << " = " << n << "\n";
  return 0;
}
