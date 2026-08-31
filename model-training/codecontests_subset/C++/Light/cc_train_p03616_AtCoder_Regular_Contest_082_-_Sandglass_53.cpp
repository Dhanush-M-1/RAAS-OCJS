#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// a == -1 is a turn query
struct Query {
  int t, a;

  Query (int _t, int _a) : t(_t), a(_a) {}
};

bool operator< (Query p, Query q) {
  return p.t < q.t;
}

int main () {
  ios::sync_with_stdio(false);

  int cap;
  cin >> cap;

  int K;
  cin >> K;

  vector<Query> queries;
  for (int i = 0; i < K; i++) {
    int r;
    cin >> r;

    queries.push_back(Query(r, -1));
  }

  int Q;
  cin >> Q;

  for (int i = 0; i < Q; i++) {
    int t, a;
    cin >> t >> a;

    queries.push_back(Query(t, a));
  }

  sort(queries.begin(), queries.end());

  int speed = -1, last = 0, l = 0, r = cap, add = 0;
  for (Query q : queries) {
    add += speed * (q.t - last);
    last = q.t;
    
    if (speed == -1) {
      l = max(l, -add);
      if (l > r) r = l;
    } else {
      r = min(r, cap - add);
      if (r < l) l = r;
    }

    if (q.a == -1) {
      speed *= -1;
    } else {
      q.a = min(q.a, r);
      q.a = max(q.a, l);
      cout << q.a + add << '\n';
    }
  }
}
