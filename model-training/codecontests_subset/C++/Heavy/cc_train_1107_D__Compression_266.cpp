#include <bits/stdc++.h>
using namespace std;
const int N = 5200 + 10;
int n;
vector<int> p;
char a[N][N];
bool check(int x) {
  for (int i = 1; i <= n; i += x) {
    for (int j = 1; j <= n; j += x) {
      for (int ii = i; ii < i + x; ii++) {
        for (int jj = j; jj < j + x; jj++) {
          if (a[ii][jj] != a[i][j]) return false;
        }
      }
    }
  }
  return true;
}
int main() {
  cin >> n;
  for (int i = 1; i * i <= n; i++)
    if (n % i == 0) p.push_back(i);
  int k = p.size() - 1;
  if (p.back() * p.back() == n) k--;
  for (int i = k; i >= 0; i--) p.push_back(n / p[i]);
  string s;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    k = 4;
    for (char &c : s) {
      int x;
      if (!isdigit(c))
        x = 10 + c - 'A';
      else
        x = c - '0';
      for (int j = 0; j < 4; j++) {
        a[i][k - j] = (x & 1) + '0';
        x >>= 1;
      }
      k += 4;
    }
  }
  for (int i = p.size() - 1; i >= 0; i--) {
    if (check(p[i])) {
      cout << p[i] << endl;
      return 0;
    }
  }
  return 0;
}
