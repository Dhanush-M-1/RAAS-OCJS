#include <bits/stdc++.h>
using namespace std;
const int kMaxN = 200001;
struct E {
  int i, t;
  bool operator<(const E &e) const { return t < e.t; }
  bool operator>(const E &e) const { return t > e.t; }
} e[4][kMaxN];
bool s[kMaxN];
int c[4];
int n, m, k, x, a, b, ans, sum, tot, p;
priority_queue<E> bh;
priority_queue<E, vector<E>, greater<E> > sh;
void Make(int st) {
  fill_n(s, n + 1, 0);
  bh = priority_queue<E>();
  sh = priority_queue<E, vector<E>, greater<E> >();
  sum = 0, tot = 0;
  for (int i = 1; i <= st; i++, tot++) {
    sum += e[3][i].t;
    s[e[3][i].i] = 1;
  }
  for (int i = 1; i <= k - st; i++, tot += 2) {
    sum += e[1][i].t + e[2][i].t;
    s[e[1][i].i] = s[e[2][i].i] = 1;
  }
  for (int i = 1; i <= c[0]; i++) {
    sh.push(e[0][i]);
  }
  for (int j = 1; j <= 2; j++) {
    for (int i = max(1, k - st + 1); i <= c[j]; i++) {
      sh.push(e[j][i]);
    }
  }
  for (; tot < m; tot++) {
    sum += sh.top().t;
    s[sh.top().i] = 1;
    bh.push(sh.top());
    sh.pop();
  }
  ans = sum;
  p = st;
}
bool Find() {
  int st = max(k - min(c[1], c[2]), 0);
  st = max(st, m - c[0] - c[1] - c[2]);
  st = max(st, 2 * k - m);
  if (st > c[3] || st > m) {
    return 0;
  }
  Make(st);
  for (int i = st; i < min(c[3], m); i++) {
    sum += e[3][i + 1].t;
    s[e[3][i + 1].i] = 1;
    tot++;
    for (int j = 1; j <= 2; j++) {
      if (i < k) {
        sum -= e[j][k - i].t;
        s[e[j][k - i].i] = 0;
        sh.push(e[j][k - i]);
        tot--;
      }
    }
    while (!bh.empty() && !sh.empty() && bh.top() > sh.top()) {
      sum += sh.top().t - bh.top().t;
      s[sh.top().i] = 1;
      s[bh.top().i] = 0;
      sh.push(bh.top());
      bh.push(sh.top());
      sh.pop();
      bh.pop();
    }
    for (; tot < m; tot++) {
      sum += sh.top().t;
      s[sh.top().i] = 1;
      bh.push(sh.top());
      sh.pop();
    }
    for (; tot > m; tot--) {
      sum -= bh.top().t;
      s[bh.top().i] = 0;
      sh.push(bh.top());
      bh.pop();
    }
    if (sum < ans) {
      ans = sum;
      p = i + 1;
    }
  }
  return 1;
}
int main() {
  cin >> n >> m >> k;
  for (int i = 1; i <= n; i++) {
    cin >> x >> a >> b;
    a |= b * 2;
    e[a][++c[a]] = {i, x};
  }
  for (int i = 0; i <= 3; i++) {
    sort(e[i] + 1, e[i] + 1 + c[i]);
  }
  if (Find()) {
    cout << ans << endl;
    Make(p);
    for (int i = 1; i <= n; i++) {
      if (s[i]) {
        cout << i << " ";
      }
    }
  } else {
    cout << -1;
  }
  return 0;
}
