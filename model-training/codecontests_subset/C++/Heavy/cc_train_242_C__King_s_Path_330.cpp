#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  long long x1, y1, x2, y2;
  cin >> x1 >> y1 >> x2 >> y2;
  pair<long long, long long> s1, d1;
  s1 = make_pair(x1, y1);
  d1 = make_pair(x2, y2);
  long long n;
  cin >> n;
  set<pair<long long, long long> > s;
  for (long long i = 0; i < n; i++) {
    long long r, a, b;
    cin >> r >> a >> b;
    for (long long j = a; j <= b; j++) {
      s.insert(make_pair(r, j));
    }
  }
  long long t[3] = {1, -1, 0};
  queue<pair<long long, long long> > q;
  q.push(s1);
  map<pair<long long, long long>, long long> m;
  m[s1] = 0;
  while (!q.empty()) {
    pair<long long, long long> temp;
    temp = q.front();
    q.pop();
    for (long long i = 0; i < 3; i++) {
      for (long long j = 0; j < 3; j++) {
        if (i == 2 && j == 2) continue;
        pair<long long, long long> w;
        w.first = temp.first + t[i];
        w.second = temp.second + t[j];
        if (s.find(w) != s.end() && m.find(w) == m.end()) {
          m[w] = m[temp] + 1;
          q.push(w);
        }
      }
    }
  }
  if (m.find(d1) != m.end()) {
    cout << m[d1];
    return 0;
  }
  cout << -1;
  return 0;
}
