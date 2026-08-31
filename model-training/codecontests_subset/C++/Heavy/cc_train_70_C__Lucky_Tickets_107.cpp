#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
struct frac {
  int num, den;
  frac(int a, int b) {
    num = a / gcd(a, b);
    den = b / gcd(a, b);
  }
  bool operator<(const frac& b) const {
    if (num != b.num)
      return num < b.num;
    else
      return den < b.den;
  }
};
map<frac, vector<int> > M;
int reverseVal(int x) {
  char s[10];
  int x2;
  sprintf(s, "%d", x);
  reverse(s, s + strlen(s));
  sscanf(s, "%d", &x2);
  return x2;
}
frac get(int x) { return frac(x, reverseVal(x)); }
frac invget(int x) { return frac(reverseVal(x), x); }
int mx, my;
long long int w;
int getminx(int y, int w) {
  int did = 0;
  for (int x = 1; x <= 10000; x++) {
    frac f = get(x);
    vector<int>::iterator it = upper_bound(M[f].begin(), M[f].end(), y);
    if (it != M[f].begin()) {
      did += int(--it - M[f].begin() + 1);
    }
    if (did >= w) return x;
  }
  return -1;
}
long long int bit[100001];
void add(int x) {
  while (x <= my) {
    bit[x]++;
    x += (x & -x);
  }
}
long long int query(int x) {
  long long int answ = 0;
  while (x > 0) {
    answ += (long long int)bit[x];
    x -= (x & -x);
  }
  return answ;
}
int main(void) {
  cin >> mx >> my >> w;
  for (int i = 1; i <= my; i++) M[invget(i)].push_back(i);
  int tot = 0;
  for (map<frac, vector<int> >::iterator it = M.begin(); it != M.end(); it++)
    sort(it->second.begin(), it->second.end());
  memset(bit, 0, sizeof bit);
  long long int best = -1;
  int bx, by;
  for (int i = 1; i <= mx; i++) {
    frac t = get(i);
    int s = M[t].size();
    for (int j = 0; j < s; j++) add(M[t][j]);
    long long int tot = query(my);
    if (tot >= w) {
      int lo = 1, hi = my;
      while (hi - lo > 1) {
        int mid = (lo + hi) / 2;
        if (query(mid) >= w)
          hi = mid;
        else
          lo = mid + 1;
      }
      if (query(lo) >= w) {
        if (best == -1 || lo * i <= best) best = lo * i, bx = i, by = lo;
      } else if (best == -1 || hi * i <= best)
        best = hi * i, bx = i, by = hi;
    }
  }
  if (best == -1)
    cout << -1 << endl;
  else
    cout << bx << " " << by << endl;
  return 0;
}
