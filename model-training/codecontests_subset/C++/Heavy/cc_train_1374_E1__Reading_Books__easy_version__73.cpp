#include <bits/stdc++.h>
using namespace std;
struct books {
  int t, i;
};
bool cmp(books a, books b) {
  if (a.t != b.t) return (a.t < b.t);
  return (a.i < b.i);
}
int main() {
  int n, m, o, x, y, i, j, t, s, k, l, p = 0, q, e[200001], f[200001];
  books a[200001], b[200001], c[200001], d[200001];
  long long ans;
  cin >> n >> o >> m;
  i = 0;
  j = 0;
  k = 0;
  l = 0;
  for (q = 1; q <= n; q++) {
    cin >> t >> x >> y;
    if (x == 1 && y == 1) {
      c[k].t = t;
      c[k++].i = q;
    } else if (x == 1) {
      a[i].t = t;
      a[i++].i = q;
    } else if (y == 1) {
      b[j].t = t;
      b[j++].i = q;
    } else {
      d[l].t = t;
      d[l++].i = q;
    }
  }
  sort(a, a + i, cmp);
  sort(b, b + j, cmp);
  sort(c, c + k, cmp);
  sort(d, d + l, cmp);
  x = 0;
  y = 0;
  t = 0;
  s = 0;
  ans = 0;
  o -= m;
  while (m > 0) {
    if (x < i && y < j && t < k) {
      if (a[x].t + b[y].t <= c[t].t && o > 0) {
        ans += a[x].t + b[y].t;
        e[p++] = a[x].i;
        e[p++] = b[y].i;
        x++;
        y++;
        o--;
      } else {
        ans += c[t].t;
        e[p++] = c[t].i;
        t++;
      }
      m--;
    } else if ((x == i || y == j) && t < k) {
      ans += c[t].t;
      e[p++] = c[t].i;
      t++;
      m--;
    } else if (t == k && x < i && y < j && o > 0) {
      ans += a[x].t + b[y].t;
      e[p++] = a[x].i;
      e[p++] = b[y].i;
      x++;
      y++;
      m--;
      o--;
    } else
      break;
  }
  if (m == 0) {
    q = 0;
    while (o--) {
      m = 10001;
      if (x < i && a[x].t < m) m = a[x].t;
      if (y < j && b[y].t < m) m = b[y].t;
      if (t < k && c[t].t < m) m = c[t].t;
      if (s < l && d[s].t < m) m = d[s].t;
      if (t > 0 && x < i && y < j && c[t - 1].t + m > a[x].t + b[y].t) {
        ans += a[x].t + b[y].t;
        e[p++] = a[x].i;
        e[p++] = b[y].i;
        x++;
        y++;
        ans -= c[t - 1].t;
        f[q++] = c[t - 1].i;
        t--;
      } else {
        ans += m;
        if (x < i && a[x].t == m) {
          e[p++] = a[x].i;
          x++;
        } else if (y < j && b[y].t == m) {
          e[p++] = b[y].i;
          y++;
        } else if (t < k && c[t].t == m) {
          e[p++] = c[t].i;
          t++;
        } else if (s < l && d[s].t == m) {
          e[p++] = d[s].i;
          s++;
        }
      }
    }
    cout << ans << endl;
    sort(e, e + p);
    sort(f, f + q);
    y = 0;
    for (x = 0; x < p; x++) {
      if (y < q && e[x] == f[y])
        y++;
      else
        cout << e[x] << " ";
    }
    cout << endl;
  } else
    cout << -1 << endl;
  return 0;
}
