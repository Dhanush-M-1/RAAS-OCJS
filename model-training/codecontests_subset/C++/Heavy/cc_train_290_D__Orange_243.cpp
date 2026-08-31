#include <bits/stdc++.h>
using namespace std;
int knightx[] = {-2, -1, +1, +2, +2, +1, -1, -2},
    knighty[] = {+1, +2, +2, +1, -1, -2, -2, -1};
int kingx[] = {-1, -1, 0, +1, +1, +1, 0, -1},
    kingy[] = {0, +1, +1, +1, 0, -1, -1, -1};
int dx2D[] = {-1, 0, +1, 0}, dy2D[] = {0, +1, 0, -1};
int dx3D[] = {0, 0, 0, 0, +1, -1}, dy3D[] = {0, +1, 0, -1, 0, 0},
    dz3D[] = {-1, 0, +1, 0, 0, 0};
int GCD(int a, int b) {
  if (a == b) return a;
  return GCD(b, a % b);
}
int LCM(int a, int b) { return a * (b / GCD(a, b)); }
long long POWER(long long a, long long b) {
  long long res = 1;
  for (long long p = b; p; p >>= 1, a *= a) {
    if (p & 1) res *= a;
  }
  return res;
}
long double Line(complex<long double> a) { return norm(a); }
long double DRG(long double d1, long double d2) {
  return ((asin(d1 / d2) * 180) / 3.14159265359);
}
bool isDigit(char c) { return (c >= '0' && c <= '9'); }
bool isLowerCase(char c) { return (c >= 'a' && c <= 'z'); }
bool isUpperCase(char c) { return (c >= 'A' && c <= 'Z'); }
bool isLetter(char c) { return (isUpperCase(c) || isLowerCase(c)); }
char toLowerCase(char c) { return (isUpperCase(c) ? (c + 32) : c); }
char toUpperCase(char c) { return (isLowerCase(c) ? (c - 32) : c); }
vector<string> Parse(string temp) {
  vector<string> ans;
  ans.clear();
  istringstream is(temp);
  for (string s; is >> s; ans.push_back(s))
    ;
  return ans;
}
long long toInt(string temp) {
  long long num = 0;
  for (int i = 0; i < temp.size(); i++) {
    num *= 10;
    num += (temp[i] - 48);
  }
  return num;
}
void Prim(bool a[]) {
  for (int i = 3; i <= 100001; i += 2) {
    bool k = true;
    for (int j = 2; j < sqrt((double)i) + 1; j++) {
      if (i % j == 0) {
        k = false;
        break;
      }
    }
    if (k == true) a[i] = k;
  }
}
int main() {
  string s;
  int n;
  cin >> s >> n;
  for (int i = 0; i < ((int)s.size()); i++) {
    if (!islower(s[i])) s[i] = (s[i] + 32);
  }
  for (int i = 0; i < ((int)s.size()); i++) {
    if ((int)s[i] < n + 97) {
      s[i] = toUpperCase(s[i]);
    }
  }
  cout << s << endl;
  return 0;
}
