#include <bits/stdc++.h>
using namespace std;
bool isPrime(int n) {
  for (int i = 2; i * i <= n; ++i) {
    if (n % i == 0) {
      return false;
    }
  }
  if (n == 1) return false;
  return true;
}
int main() {
  int ch[28] = {0};
  string x;
  int n;
  cin >> n >> x;
  for (int i = 0; i < x.length(); i++) {
    ch[x[i] - 'a']++;
  }
  for (int i = 0; i < x.length(); i++) {
    if (ch[x[i] - 'a'] % n != 0) {
      cout << -1;
      return 0;
    }
  }
  for (int i = 0; i < n; i++) {
    for (int c = 0; c < 28; c++) {
      for (int y = 0; y < ch[c] / n; y++) {
        char s = c + 'a';
        cout << s;
      }
    }
  }
  return 0;
}
