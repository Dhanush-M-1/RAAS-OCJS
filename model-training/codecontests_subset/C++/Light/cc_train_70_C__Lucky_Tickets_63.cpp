#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  int t;
  if (b < a) a ^= b ^= a ^= b;
  while (a) {
    t = b % a;
    b = a;
    a = t;
  }
  return b;
}
int reverse(int k) {
  while (k && k % 10 == 0) {
    k /= 10;
  }
  int t = 0;
  while (k) {
    t = t * 10 + k % 10;
    k /= 10;
  }
  return t;
}
map<pair<int, int>, int> mx, my;
int W, X, Y;
pair<int, int> p, q;
int ansx, ansy;
long long ans = 1000000000000000000LL;
int main() {
  scanf("%d%d%d", &X, &Y, &W);
  for (int i = 1; i <= X; ++i) {
    int j = reverse(i);
    int g = gcd(i, j);
    p.first = i / g;
    p.second = j / g;
    mx[p]++;
  }
  int cur = 0;
  int x = X;
  for (int y = 1; y <= Y; ++y) {
    int j = reverse(y);
    int g = gcd(y, j);
    p.first = j / g;
    p.second = y / g;
    cur += mx[p];
    my[p]++;
    if (y == 10) {
    }
    while (x > 0 && cur >= W) {
      if ((long long)((long long)x * (long long)y) < ans) {
        ans = (long long)((long long)x * (long long)y);
        ansx = x;
        ansy = y;
      }
      int j = reverse(x);
      int g = gcd(x, j);
      p.first = x / g;
      p.second = j / g;
      cur -= my[p];
      mx[p]--;
      --x;
    }
  }
  if (ans == 1000000000000000000LL) {
    puts("-1");
  } else {
    printf("%d %d\n", ansx, ansy);
  }
  return 0;
}
