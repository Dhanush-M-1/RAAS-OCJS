#include <bits/stdc++.h>
using namespace std;

struct Event {
  int t;
  int d;
  int a;
  bool operator<(const Event& r) const {
    return t < r.t;
  }
};

int R, K, Q;
int s[100000];
int t[100000];
int a[100000];

void sub(int t, int d, int a) {
  static int prev_d = 1;
  static int prev_t = 0;
  static int l = 0;
  static int r = R;
  static int x = 0;
  
  bool q = d == 0;
  if (q) {
    d = -prev_d;
  }
  
  x += d * (t - prev_t);
  l = min(max(l, -x), -x + R);
  r = min(max(r, -x), -x + R);
  
  if (q) {
    a = max(a, l);
    a = min(a, r);
    cout << x + a << endl;
  }
  
  if (!q) {
    prev_d = d;
  }
  prev_t = t;
}

int main() {
  cin >> R >> K;
  for (int i = 0; i < K; ++i) cin >> s[i];
  cin >> Q;
  for (int i = 0; i < Q; ++i) cin >> t[i] >> a[i];
  
  vector<Event> es;
  int d = -1;
  for (int i = 0; i < K; ++i) {
    es.push_back(Event{ s[i], d, 0 });
    d = -d;
  }
  for (int i = 0; i < Q; ++i) {
    es.push_back(Event{ t[i], 0, a[i] });
  }
  sort(es.begin(), es.end());
  for (auto e : es) {
    sub(e.t, e.d, e.a);
  }
}