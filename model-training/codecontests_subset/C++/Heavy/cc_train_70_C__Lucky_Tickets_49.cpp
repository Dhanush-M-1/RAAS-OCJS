#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
pair<int, int> val[100000];
map<pair<int, int>, set<int> > C;
int rev(int a) {
  int ans = 0;
  while (a) ans = ans * 10 + a % 10, a /= 10;
  return ans;
}
struct by_x {
  bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.first == b.first) return a.second < b.second;
    return a.first < b.first;
  }
};
struct by_y {
  bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.second == b.second) return a.first < b.first;
    return a.second < b.second;
  }
};
int main() {
  int X, Y, W;
  cin >> X >> Y >> W;
  for (int i = (1); i <= (max(X, Y)); ++i) {
    int r = rev(i);
    int g = gcd(i, r);
    val[i] = make_pair(i / g, r / g);
    C[val[i]].insert(i);
  }
  vector<pair<int, int> > evt;
  for (int a = (1); a <= (X); ++a) {
    pair<int, int> p = val[a];
    swap(p.first, p.second);
    for (set<int>::iterator it = C[p].begin(); it != C[p].end(); it++) {
      int b = (*it);
      if (b > Y) continue;
      evt.push_back(make_pair(a, b));
      assert(a * (long long)b == rev(a) * (long long)rev(b));
    }
  }
  int N = evt.size();
  if (W > N) {
    cout << -1 << endl;
    return 0;
  }
  int bestx = X + 1;
  int besty = Y + 1;
  long long area = bestx * (long long)besty;
  priority_queue<pair<int, int>, vector<pair<int, int> >, by_y> Q;
  for (int i = 0; i < N; ++i) {
    Q.push(evt[i]);
    while (Q.size() > W) Q.pop();
    if (Q.size() < W) continue;
    int x = evt[i].first;
    int y = Q.top().second;
    if (x * (long long)y <= area) {
      area = x * (long long)y;
      bestx = x;
      besty = y;
    }
  }
  cout << bestx << " " << besty << endl;
  return 0;
}
