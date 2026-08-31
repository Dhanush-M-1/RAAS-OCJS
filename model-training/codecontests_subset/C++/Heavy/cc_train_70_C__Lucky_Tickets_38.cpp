#include <bits/stdc++.h>
using namespace std;
int rev(int a) {
  int b = 0;
  while (a) {
    b = b * 10 + a % 10;
    a /= 10;
  }
  return b;
}
int gcd(int a, int b) {
  while (b) {
    int t = a % b;
    a = b;
    b = t;
  }
  return a;
}
int main() {
  int mx, my, w;
  scanf("%d%d%d", &mx, &my, &w);
  multimap<pair<int, int>, pair<int, int> > cor;
  for (int i = 1; i <= my; i++) {
    int r = rev(i);
    int d = gcd(i, r);
    int a = i / d, b = r / d;
    cor.insert(make_pair(make_pair(a, b), make_pair(i, r)));
  }
  static vector<int> list[110000];
  int count = 0;
  for (int i = 1; i <= mx; i++) {
    int r = rev(i);
    int d = gcd(i, r);
    int a = i / d, b = r / d;
    pair<int, int> t(b, a);
    for (multimap<pair<int, int>, pair<int, int> >::iterator p =
             cor.lower_bound(t);
         p != cor.end() && p->first == t; p++) {
      list[i].push_back(p->second.first);
      count++;
    }
  }
  if (count < w) {
    puts("-1");
    return 0;
  }
  priority_queue<int> ids;
  int sy = my, sx = mx;
  for (int i = 1; i <= mx; i++) {
    for (vector<int>::iterator j = list[i].begin(); j != list[i].end(); j++) {
      ids.push(*j);
    }
    while ((int)ids.size() > w) ids.pop();
    if ((int)ids.size() >= w) {
      int y = i;
      int x = ids.top();
      if ((long long)sy * (long long)sx > (long long)y * (long long)x) {
        sy = y;
        sx = x;
      }
    }
  }
  printf("%d %d\n", sy, sx);
  return 0;
}
