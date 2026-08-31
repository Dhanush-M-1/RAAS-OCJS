#include <bits/stdc++.h>
int asalmi(int x) {
  int i, k = (int)sqrt(x);
  for (i = 2; i <= k; i++)
    if (x % i == 0) return 0;
  return 1;
}
int ters(int x) {
  int bas = 0, t = x, i, k = 0;
  while (t) {
    bas++;
    t /= 10;
  }
  for (i = 1; i <= bas; i++) {
    k *= 10;
    k += x % 10;
    x /= 10;
  }
  return k;
}
using namespace std;
long long m, n;
void read() {}
void solve() {
  int n;
  string s;
  cin >> s >> n;
  for (int i = 0; i <= int(s.size()) - 1; i += 1) {
    s[i] = tolower(s[i]);
    if (s[i] - 'a' < n) s[i] = toupper(s[i]);
  }
  cout << s << endl;
}
void write() { int i, j; }
int main() {
  read();
  solve();
  write();
  return 0;
}
