#include <bits/stdc++.h>
using namespace std;
int a[100008];
int p[7];
multimap<double, int>::iterator it[100008];
void get(int m) {
  int q = 0;
  int k = m;
  while (m) {
    int cc = m % 10;
    m /= 10;
    if (cc == 0 && q == 0)
      continue;
    else
      p[++q] = cc;
  }
  for (int i = 1; i <= q; i++) {
    a[k] = a[k] * 10 + p[i];
  }
}
int main() {
  int aa, bb, w, flag = 0;
  scanf("%d%d%d", &aa, &bb, &w);
  if (aa > bb) {
    flag = 1;
    swap(aa, bb);
  }
  fill(a, a + bb + 2, 0);
  for (int i = 1; i <= bb; i++) get(i);
  multimap<double, int> mm;
  multimap<double, int> mm2;
  for (int i = 1; i <= bb; i++) {
    it[i] = mm.insert(make_pair((double)(i) / a[i], i));
  }
  int sum = 0;
  int x, y;
  int x1, y1;
  long long ans = (long long)aa * bb + 1;
  for (int i = 1; i <= aa; i++) {
    double k = (double)(a[i]) / i;
    int cnt = mm.count(k);
    sum += cnt;
    mm2.insert(make_pair(k, i));
    if (sum >= w) {
      x = i;
      y = bb;
      ans = x * y;
      x1 = x;
      y1 = y;
      while (1) {
        if (sum >= w) {
          if (y > 1) {
            double kk = (double)(y) / a[y];
            int cnt = mm2.count(kk);
            sum -= cnt;
            mm.erase(it[y]);
            y--;
            if (sum >= w) {
              if (x * y < ans) {
                x1 = x;
                y1 = y;
                ans = x1 * y1;
              }
            }
          } else
            break;
        } else {
          if (x < aa) {
            x++;
            double kk = double(a[x]) / (x);
            int cnt = mm.count(kk);
            sum += cnt;
            mm2.insert(make_pair(kk, x));
            if (sum >= w) {
              if (x * y < ans) {
                x1 = x;
                y1 = y;
                ans = x * y;
              }
            }
          } else
            break;
        }
      }
      break;
    }
  }
  if (ans == ((long long)aa * bb + 1))
    cout << "-1" << endl;
  else if (flag) {
    cout << y1 << " " << x1 << endl;
  } else
    cout << x1 << " " << y1 << endl;
  return 0;
}
