#include <bits/stdc++.h>
using namespace std;
int Rev[100001];
int maxX, maxY, W;
map<pair<int, int>, vector<int> > XSobreInv;
long long rev(int x) {
  if (Rev[x] != -1) return Rev[x];
  int y = 0;
  while (x) {
    y *= 10;
    y += x % 10;
    x /= 10;
  }
  return Rev[x] = y;
}
int gcd(int a, int b) { return b ? gcd(b, a % b) : a; }
pair<int, int> transforma(int x) {
  int inv = rev(x);
  int g = gcd(x, inv);
  x /= g;
  inv /= g;
  if (inv == 0) x = 1;
  return make_pair(x, inv);
}
int usei[100001];
int tenho(int x, int y) {
  int q = 0;
  pair<int, int> ok = transforma(x);
  swap(ok.first, ok.second);
  if (XSobreInv.count(ok)) {
    for (vector<int>::iterator it = XSobreInv[ok].begin();
         it != XSobreInv[ok].end(); it++) {
      if (*it <= y) {
        q++;
        usei[*it]++;
      } else {
        break;
      }
    }
  }
  return q;
}
void atualiza(long long &X, long long &Y, long long x, long long y) {
  if (x * y < X * Y) {
    X = x;
    Y = y;
  }
}
int main() {
  scanf("%d %d %d", &maxX, &maxY, &W);
  memset(Rev, -1, sizeof(Rev));
  XSobreInv.clear();
  for (int i = 1; i < 100001; i++) {
    int x = i;
    pair<int, int> p = transforma(x);
    XSobreInv[p].push_back(i);
  }
  memset(usei, 0, sizeof(usei));
  int total = 0;
  long long X = maxX + 1, Y = maxY + 1;
  for (int x = 1; x <= maxX; x++) {
    total += tenho(x, maxY);
    if (total >= W) {
      X = x;
      Y = maxY;
      break;
    }
  }
  if (X > maxX) {
    printf("-1\n");
    return 0;
  }
  int xat = X;
  for (int y = maxY; y >= 2; y--) {
    total -= usei[y];
    while (xat < maxX && total < W) {
      total += tenho(++xat, y - 1);
    }
    if (total >= W) {
      atualiza(X, Y, xat, y - 1);
    } else {
      break;
    }
  }
  cout << X << " " << Y << endl;
  return 0;
}
