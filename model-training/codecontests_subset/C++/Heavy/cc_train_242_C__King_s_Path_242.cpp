#include <bits/stdc++.h>
using namespace std;
int Set(int N, int pos) { return N |= (1LL << pos); }
int Reset(int N, int pos) { return N &= ~(1LL << pos); }
bool Check(int N, int pos) { return N & (1LL << pos); }
int dx[] = {0, 0, 1, -1, 1, -1, 1, -1}, dy[] = {1, -1, 0, 0, 1, -1, -1, 1};
inline void cn(long &n) {
  n = 0;
  long ch = getchar();
  int sign = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') sign = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9')
    n = (n << 3) + (n << 1) + ch - '0', ch = getchar();
  n = n * sign;
}
template <class T>
void cmin(T &a, T b) {
  if (b < a) a = b;
}
template <class T>
void cmax(T &a, T b) {
  if (b > a) a = b;
}
template <class T>
int len(const T &c) {
  return (int)c.size();
}
template <class T>
int len(char c[]) {
  return (int)strlen(c);
}
string itos(long n) {
  string s;
  while (n) {
    s += (n % 10 + 48);
    n /= 10;
  }
  reverse(s.begin(), s.end());
  return s;
}
long stoi(string s) {
  long n = 0;
  for (int i(0), _n(len(s)); i < _n; ++i) n = n * 10 + (s[i] - 48);
  return n;
}
int main() {
  long x, y, xx, yy, n, r, a, b;
  map<pair<int, int>, int> m;
  cin >> x >> y >> xx >> yy;
  cin >> n;
  for (int i(0), _n(n); i < _n; ++i) {
    cin >> r >> a >> b;
    for (int j(a), _b(b); j <= _b; ++j) {
      m[make_pair(r, j)] = -1;
    }
  }
  pair<int, int> st, end, temp;
  st = make_pair(x, y);
  end = make_pair(xx, yy);
  queue<pair<int, int> > q;
  q.push(st);
  m[st] = 1;
  while (!q.empty()) {
    temp = q.front();
    q.pop();
    x = temp.first;
    y = temp.second;
    for (int i(0), _n(8); i < _n; ++i) {
      if (m[make_pair(x + dx[i], y + dy[i])] < 0) {
        q.push(make_pair(x + dx[i], y + dy[i]));
        m[make_pair(x + dx[i], y + dy[i])] = m[make_pair(x, y)] + 1;
      }
    }
  }
  if (m[end] == -1) m[end] = 0;
  cout << m[end] - 1;
  return 0;
}
