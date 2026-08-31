#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
template <class T>
T abs(T x) {
  return x > 0 ? x : -x;
}
int n;
int m;
int w;
int rev[100001];
int getrev(int x) {
  vector<int> v;
  while (x) {
    v.push_back(x % 10);
    x /= 10;
  }
  int ans = 0;
  for (int i = 0; i < (((int)(v).size())); i++) ans = ans * 10 + v[i];
  return ans;
}
int gcd(int a, int b) { return a ? gcd(b % a, a) : b; }
vector<pair<pair<int, int>, int> > v;
int s[105000];
int findsum(int l, int r) {
  long long sum = 0;
  int x = r;
  while (x > 0) {
    sum += s[x];
    x &= x - 1;
  }
  x = l - 1;
  while (x > 0) {
    sum -= s[x];
    x &= x - 1;
  }
  return sum;
}
void modify(int x, int val) {
  while (x < m + 5) {
    s[x] += val;
    x |= x - 1;
    x++;
  }
}
int zlo;
void add(int x) {
  int sx = x;
  int y = rev[x];
  int d = gcd(x, y);
  y /= d;
  x /= d;
  int p = lower_bound((v).begin(), (v).end(), make_pair(make_pair(y, x), -1)) -
          v.begin();
  pair<int, int> o = make_pair(y, x);
  while (p < ((int)(v).size()) && v[p].first == o) {
    modify(v[p].second, 1);
    p++;
    zlo++;
  }
}
int main() {
  cin >> n >> m >> w;
  int nn = max(n, m);
  for (int i = 0; i < (nn + 1); i++) rev[i] = getrev(i);
  for (int i = 1; i <= nn; i++) {
    int d = gcd(i, rev[i]);
    v.push_back(make_pair(make_pair(i / d, rev[i] / d), i));
  }
  sort((v).begin(), (v).end());
  long long ax, ay;
  int f = 0;
  ax = 1000000;
  ay = 1000000;
  for (int i = 1; i <= n; i++) {
    add(i);
    int l = 1, r = m;
    if (findsum(1, m) < w) continue;
    int savec = 0;
    while (l <= r) {
      int c = (l + r) / 2;
      if (findsum(1, c) < w)
        l = c + 1;
      else {
        r = c - 1;
        savec = c;
        f = 1;
      }
    }
    if ((long long)savec * (long long)i < ax * ay) {
      ax = i;
      ay = savec;
    }
  }
  if (!f) {
    cout << -1 << endl;
    return 0;
  }
  cout << ax << ' ' << ay << endl;
  return 0;
}
