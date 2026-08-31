#include <bits/stdc++.h>
using namespace std;
const int N = 203600;
char s[2000];
int rev(int first) {
  int n;
  sprintf(s, "%d%n", first, &n);
  reverse(s, s + n);
  sscanf(s, "%d", &first);
  return first;
}
int gcd(int first, int second) {
  return first ? gcd(second % first, first) : second;
}
map<int, int> MP;
pair<int, int> frac[N];
pair<int, int> recp[N];
map<pair<int, int>, int> cntx;
map<pair<int, int>, int> cnty;
int main() {
  for (int i = (1); i <= (int)(100000); i++) {
    int j = rev(i);
    int g = gcd(i, j);
    frac[i] = pair<int, int>(i / g, j / g);
    recp[i] = pair<int, int>(j / g, i / g);
  }
  int mx, my, w;
  scanf("%d%d%d", &mx, &my, &w);
  int cx, cy = 1;
  int ax, ay;
  long long tot = 1LL << 40;
  for (int first = (1); first <= (int)(mx); first++) cntx[recp[first]]++;
  long long cur = 0;
  for (cx = mx; cx; cx--) {
    while (cy <= my && cur < w) {
      cur += cntx[frac[cy]];
      cnty[frac[cy]]++;
      cy++;
    }
    if (cur >= w && (long long)cx * (cy - 1) < tot) {
      tot = (long long)cx * (cy - 1);
      ax = cx;
      ay = cy - 1;
    }
    cur -= cnty[recp[cx]];
    cntx[recp[cx]]--;
  }
  if (tot == (1LL << 40))
    puts("-1");
  else
    printf("%d %d\n", ax, ay);
  return 0;
}
