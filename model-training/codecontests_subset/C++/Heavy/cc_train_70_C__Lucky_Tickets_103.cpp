#include <bits/stdc++.h>
using namespace std;
int MX, MY, W;
map<pair<int, int>, int> m1, m2;
int gcd(int a, int b) {
  if (!b) return a;
  return gcd(b, a % b);
}
int rev(int x) {
  int res = 0;
  while (x) {
    res = res * 10 + (x % 10);
    x /= 10;
  }
  return res;
}
void gs(int x) {
  int a = x, b = rev(x);
  int g = gcd(a, b);
  a /= g;
  b /= g;
  m1[make_pair(a, b)]++;
}
bool okay(int y, int &total) {
  int a = rev(y), b = y;
  int g = gcd(a, b);
  a /= g;
  b /= g;
  m2[make_pair(a, b)]++;
  total += m1[make_pair(a, b)];
  return total >= W;
}
int gety(int a, int b, int &total) {
  if (total >= W) return b;
  for (int i = b + 1; i <= MY; i++) {
    if (okay(i, total)) return i;
  }
  return -1;
}
void sub(int x, int &total) {
  int a = x, b = rev(x);
  int g = gcd(a, b);
  a /= g;
  b /= g;
  m1[make_pair(a, b)]--;
  total -= m2[make_pair(a, b)];
}
int main() {
  while (scanf("%d%d%d", &MX, &MY, &W) == 3) {
    m1.clear();
    m2.clear();
    for (int i = 1; i <= MX; i++) gs(i);
    int total = 0;
    int X = MX;
    int Y = gety(MX, 0, total);
    if (Y == -1) {
      puts("-1");
      continue;
    }
    int AX = X, AY = Y;
    long long ans = (long long)X * Y;
    while (X > 1) {
      sub(X, total);
      X--;
      Y = gety(X, Y, total);
      if (Y == -1) break;
      long long tmp = (long long)X * Y;
      if (ans > tmp) {
        ans = tmp;
        AX = X;
        AY = Y;
      }
    }
    printf("%d %d\n", AX, AY);
  }
  return 0;
}
