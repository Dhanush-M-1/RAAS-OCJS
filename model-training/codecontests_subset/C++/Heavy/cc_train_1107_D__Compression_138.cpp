#include <bits/stdc++.h>
using namespace std;
using ll = long long;
bitset<(int)(5200)> mat[(int)(5200)];
int gcd(int a, int b) {
  int r = a % b;
  while (r) {
    a = b;
    b = r;
    r = a % b;
  }
  return b;
}
int hex(char ch) { return isdigit(ch) ? ch - '0' : ch - 'A' + 10; }
int main() {
  ios_base ::sync_with_stdio(NULL);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string st;
    cin >> st;
    for (char ch : st) {
      mat[i] <<= 4;
      mat[i] |= hex(ch);
    }
  }
  bool fl = 0;
  int gc;
  for (int i = 0; i < n; i++) {
    int cc = 1;
    for (int j = n - 2; j >= n - n; j--) {
      if (mat[i][j] == mat[i][j + 1]) {
        cc++;
      } else {
        if (!fl) {
          gc = cc;
          fl = 1;
        } else {
          gc = gcd(cc, gc);
        }
        cc = 1;
      }
    }
    if (!fl) {
      gc = cc;
    } else {
      gc = gcd(cc, gc);
    }
  }
  for (int j = n - 1; j >= n - n; j--) {
    int cc = 1;
    for (int i = 1; i < n; i++) {
      if (mat[i - 1][j] == mat[i][j]) {
        cc++;
      } else {
        if (!fl) {
          gc = cc;
        } else {
          gc = gcd(cc, gc);
        }
        cc = 1;
      }
    }
    if (!fl) {
      gc = cc;
    } else {
      gc = gcd(cc, gc);
    }
  }
  cout << gc << "\n";
}
