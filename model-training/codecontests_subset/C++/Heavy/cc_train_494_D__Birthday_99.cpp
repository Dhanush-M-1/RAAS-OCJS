#include <bits/stdc++.h>
using namespace std;
class sp {
 public:
  int q;
  long long w, t, t1, t2;
  sp *e, *r;
  sp(int q1, long long w1, sp *e1) {
    q = q1;
    w = w1;
    e = e1;
    t = t1 = t2 = 0;
  }
};
sp *a[100000], *s1[100000];
int s[100000], s2[100000], d[100000], d1[100000], d2[100000], p = 1000000007;
int u = 0, d3[100000], *f[100000], *f1[100000], h[100000], h1[100000];
int d00[100000], d01[100000], d02[100000];
long long m(long long w, long long e) {
  if (w < 0) w += p;
  if (e < 0) e += p;
  return (w * e) % p;
}
void l(int q, sp *w) {
  sp *c;
  if (s[q] == -1) {
    s[q] = 0;
    s1[q] = w;
    if (w == 0) s[q] = -2;
    for (c = a[q]; c; c = c->e)
      if (c != w) {
        l(c->q, c->r);
        d[q] += c->t;
        d1[q] = (d1[q] + c->t1) % p;
        d2[q] = (d2[q] + c->t2) % p;
      }
  }
  if (s[q] == 0)
    if (s1[q] == w) {
      w->r->t = d[q];
      w->r->t1 = (d[q] * (w->w) + d1[q]) % p;
      w->r->t2 = (m(w->w, w->w) * d[q] + 2 * m(w->w, d1[q]) + d2[q]) % p;
      return;
    } else {
      s[q] = -2;
      l(s1[q]->q, s1[q]->r);
      d[q] = d[q] + s1[q]->t;
      d1[q] = (d1[q] + s1[q]->t1) % p;
      d2[q] = (d2[q] + s1[q]->t2) % p;
    }
  if ((s[q] == -2) && (w != 0)) {
    w->r->t = d[q] - w->t;
    w->r->t1 = (m(d[q] - w->t, w->w) + d1[q] - w->t1 + p) % p;
    w->r->t2 = (m(m(w->w, w->w), d[q] - w->t) + 2 * m(w->w, d1[q] - w->t1) +
                d2[q] - w->t2 + p) %
               p;
  }
}
void l1(int q, sp *w, int t) {
  sp *c;
  h[q] = u;
  u++;
  s[t] = q;
  s2[t] = 0;
  if (w != 0) s2[t] = (s2[t - 1] + w->w) % p;
  for (c = a[q]; c; c = c->e)
    if (c != w) l1(c->q, c->r, t + 1);
  h1[q] = u - 1;
  if (w != 0) {
    d[q] = d[q] - w->t;
    d1[q] = (d1[q] - w->t1 + p) % p;
    d3[q] = (d2[q] - w->t2 + p) % p;
    d00[q] = w->t;
    d01[q] = w->t1;
    d02[q] = w->t2;
  }
  int e, r;
  for (e = 0, r = 1; e < 17; e++, r <<= 1)
    if (t >= r) {
      f[q][e] = s[t - r];
      f1[q][e] = s2[t] - s2[t - r];
      if (f1[q][e] < 0) f1[q][e] += p;
    } else
      f[q][e] = -1;
}
int k(int q, int w) {
  int e, c;
  long long t = 0;
  c = q;
  for (e = 16; e >= 0; e--)
    if (f[c][e] >= 0)
      if (!((h[f[c][e]] <= h[w]) && (h[w] <= h1[f[c][e]]))) {
        t += f1[c][e];
        c = f[c][e];
      }
  if (f[c][0] >= 0)
    if (!((h[c] <= h[w]) && (h[w] <= h1[c]))) t += f1[c][0];
  c = w;
  for (e = 16; e >= 0; e--)
    if (f[c][e] >= 0)
      if (!((h[f[c][e]] <= h[q]) && (h[q] <= h1[f[c][e]]))) {
        t += f1[c][e];
        c = f[c][e];
      }
  if (f[c][0] >= 0)
    if (!((h[c] <= h[q]) && (h[q] <= h1[c]))) t += f1[c][0];
  return t % p;
}
int main() {
  int q, w, e, r;
  long long t, c;
  cin >> q;
  for (w = 0; w < q; w++) {
    s[w] = -1;
    d[w] = 1;
    d1[w] = d2[w] = 0;
    a[w] = 0;
    f[w] = new int[17];
    f1[w] = new int[17];
  }
  for (w = 1; w < q; w++) {
    scanf("%d%d%I64d", &e, &r, &t);
    e--;
    r--;
    a[e] = new sp(r, t, a[e]);
    a[r] = new sp(e, t, a[r]);
    a[e]->r = a[r];
    a[r]->r = a[e];
  }
  for (w = 0; w < q; w++)
    if (s[w] != -2) l(w, 0);
  d00[0] = d01[0] = d02[0] = 0;
  d3[0] = d2[0];
  l1(0, 0, 0);
  for (cin >> w; w; w--) {
    scanf("%d%d", &e, &r);
    e--;
    r--;
    t = k(e, r);
    if ((h[r] <= h[e]) && (h[e] <= h1[r])) {
      c = (m(d00[r], m(t, t)) + 2 * m(t, d01[r]) + d02[r]) % p;
      c = (d2[e] - ((c * 2) % p) + p) % p;
      printf("%d\n", c);
    } else {
      c = (m(d[r], m(t, t)) + 2 * m(t, d1[r]) + d3[r]) % p;
      c = (-(d2[e] - ((c * 2) % p)) + p) % p;
      printf("%d\n", c);
    }
  }
  return 0;
}
