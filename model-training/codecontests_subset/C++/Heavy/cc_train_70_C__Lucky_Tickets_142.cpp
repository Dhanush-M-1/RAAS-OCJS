#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:100000000000000")
using namespace std;
const long long int INF = 2e15;
int rev(int a) {
  vector<int> temp;
  while (a) {
    temp.push_back(a % 10);
    a /= 10;
  }
  int sz = (int)temp.size();
  for (int i = (int)temp.size() - 1; i >= 0; i--) {
    if (temp[i] == '0')
      sz = i;
    else
      break;
  }
  temp.resize(sz);
  reverse(temp.begin(), temp.end());
  int last = 1;
  int out = 0;
  for (int i = 0; i < ((int)temp.size()); i++) {
    out += temp[i] * last;
    last *= 10;
  }
  return out;
}
int gcd(int a, int b) { return b ? gcd(b, a % b) : a; }
map<pair<int, int>, vector<int> > cnt;
void pre(int to) {
  for (int i = 1; i <= to; i++) {
    int f = rev(i);
    int s = i;
    int gc = gcd(f, s);
    f /= gc;
    s /= gc;
    cnt[make_pair(f, s)].push_back(i);
  }
}
long long int fen[1000000];
void inc(int id, int n) {
  for (; id <= n; id += ((id + 1) & -(id + 1))) {
    fen[id]++;
  }
}
long long int geti(int id) {
  long long int out = 0;
  for (; id >= 0; id -= ((id + 1) & -(id + 1))) {
    out += fen[id];
  }
  return out;
}
void upd(long long int &r1, int &outx, int &outy, int w, int w2) {
  long long int r2 = (long long int)w * 1LL * (long long int)w2;
  if (r2 < r1) {
    r1 = r2;
    outx = w;
    outy = w2;
  }
}
int main() {
  int mx, my, w;
  cin >> mx >> my >> w;
  pre(my);
  memset(fen, 0, sizeof fen);
  int outx = -1, outy = -1;
  long long int r1 = INF;
  for (int i = 1; i <= mx; i++) {
    int f = i;
    int s = rev(f);
    int gc = gcd(f, s);
    f /= gc;
    s /= gc;
    map<pair<int, int>, vector<int> >::iterator it = cnt.find(make_pair(f, s));
    if (it == cnt.end()) continue;
    int last = 1;
    long long int val;
    for (int j = 0; j < ((int)it->second.size()); j++) {
      int to = it->second[j];
      val = geti(to - 1);
      if (val >= w && last <= to - 1) {
        int l = last, r = to - 1;
        while (l != r) {
          int mid = (l + r) / 2;
          val = geti(mid);
          if (val < w)
            l = mid + 1;
          else
            r = mid;
        }
        upd(r1, outx, outy, i, l);
      }
      last = to;
      inc(to, my);
      val = geti(to);
      if (val >= w) {
        upd(r1, outx, outy, i, to);
      }
    }
    val = geti(my);
    if (val >= w) {
      int l = last, r = my;
      while (l != r) {
        int mid = (l + r) / 2;
        val = geti(mid);
        if (val < w)
          l = mid + 1;
        else
          r = mid;
      }
      upd(r1, outx, outy, i, l);
    }
  }
  if (outx == -1) {
    cout << -1;
  } else {
    cout << outx << " " << outy;
  }
}
