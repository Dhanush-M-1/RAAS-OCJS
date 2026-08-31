#include <bits/stdc++.h>
using namespace std;
int totalCases, testNum;
int rev[100001];
pair<int, int> aByRevA[100001];
map<int, int> pf[100001];
set<pair<int, int> > validwRank[100001];
map<pair<int, int>, vector<int> > mymap;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int reverse(int n) {
  int ret = 0;
  while (n > 0) {
    ret = ret * 10 + (n % 10);
    n /= 10;
  }
  return ret;
}
void preprocess() {
  for (int i = 1; i <= 100000; i++) rev[i] = reverse(i);
  aByRevA[1] = make_pair(1, 1);
  mymap[make_pair(1, 1)].push_back(1);
  for (int a = 2; a <= 100000; a++) {
    int reva = rev[a];
    int g = gcd(a, reva);
    pair<int, int> arg = make_pair(a / g, reva / g);
    aByRevA[a] = arg;
    mymap[arg].push_back(a);
  }
}
int mx, my, w;
bool input() {
  scanf("%d", &mx);
  scanf("%d", &my);
  scanf("%d", &w);
  return true;
}
void solve() {
  long long bestx, besty;
  bestx = mx + 1;
  besty = my + 1;
  long long found = 0;
  long long x, y;
  pair<int, int> argx, argy;
  y = my;
  for (x = 1; x <= mx; x++) {
    argx = aByRevA[x];
    argy = make_pair(argx.second, argx.first);
    int now = upper_bound(mymap[argy].begin(), mymap[argy].end(), y) -
              mymap[argy].begin();
    found += now;
    while (found >= w) {
      if (x * y < bestx * besty) {
        bestx = x;
        besty = y;
      }
      argy = aByRevA[y];
      argx = make_pair(argy.second, argy.first);
      now = upper_bound(mymap[argx].begin(), mymap[argx].end(), x) -
            mymap[argx].begin();
      found -= now;
      y--;
    }
  }
  if (bestx > mx) {
    cout << -1 << endl;
    return;
  }
  cout << bestx << " " << besty << endl;
}
int main() {
  preprocess();
  totalCases = 1;
  for (testNum = 1; testNum <= totalCases; testNum++) {
    if (!input()) break;
    solve();
  }
}
