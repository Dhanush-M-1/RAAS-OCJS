#include <bits/stdc++.h>
using namespace std;
long long max(long long a, long long b) { return a > b ? a : b; }
void swap(long long& a, long long& b) {
  long long tmp = a;
  a = b;
  b = tmp;
}
long long t, n;
long long x[200006], v[200006];
pair<long long, long long> xv[200006];
long long prfxSum[200006];
pair<long long, long long> sgmTree[4 * 200006];
pair<long long, long long> get(long long node, long long st, long long en,
                               long long pos) {
  if (st > en) {
    return make_pair(0, 0);
  }
  if (en == pos) {
    return sgmTree[node];
  }
  if ((st + en) / 2 >= pos) {
    return get(2 * node, st, (st + en) / 2, pos);
  } else {
    pair<long long, long long> to_ret =
        get(2 * node + 1, (st + en) / 2 + 1, en, pos);
    return make_pair(sgmTree[2 * node].first + to_ret.first,
                     sgmTree[2 * node].second + to_ret.second);
  }
}
void remove(long long node, long long st, long long en, long long pos) {
  if (st > en) {
    return;
  }
  if (st == en) {
    sgmTree[node] = make_pair(0, 0);
    return;
  }
  if ((st + en) / 2 >= pos) {
    remove(2 * node, st, (st + en) / 2, pos);
  } else {
    remove(2 * node + 1, (st + en) / 2 + 1, en, pos);
  }
  sgmTree[node].first = sgmTree[2 * node].first + sgmTree[2 * node + 1].first;
  sgmTree[node].second =
      sgmTree[2 * node].second + sgmTree[2 * node + 1].second;
}
void buildtree(long long node, long long st, long long en) {
  if (st > en) {
    return;
  }
  if (st == en) {
    sgmTree[node] = make_pair(x[st], 1);
    return;
  }
  buildtree(2 * node, st, (st + en) / 2);
  buildtree(2 * node + 1, (st + en) / 2 + 1, en);
  sgmTree[node].first = sgmTree[2 * node].first + sgmTree[2 * node + 1].first;
  sgmTree[node].second =
      sgmTree[2 * node].second + sgmTree[2 * node + 1].second;
}
void solve() {
  cin >> n;
  for (int i = 1; i <= 4 * n; ++i) {
    sgmTree[i] = make_pair(0, 0);
  }
  for (int i = 1; i <= n; ++i) {
    cin >> x[i];
  }
  for (int i = 1; i <= n; ++i) {
    cin >> v[i];
  }
  for (int i = 1; i <= n; ++i) {
    xv[i] = make_pair(x[i], v[i]);
  }
  sort(xv + 1, xv + 1 + n);
  for (int i = 1; i <= n; ++i) {
    x[i] = xv[i].first;
  }
  for (int i = 1; i <= n; ++i) {
    v[i] = xv[i].second;
  }
  priority_queue<pair<long long, long long> > pq;
  for (int i = 1; i <= n; ++i) {
    pq.push(make_pair(v[i], i));
  }
  prfxSum[1] = x[1];
  for (int i = 2; i <= n; ++i) {
    prfxSum[i] = prfxSum[i - 1] + x[i];
  }
  buildtree(1, 1, n);
  long long ans = 0;
  while (!pq.empty()) {
    pair<long long, long long> pair = pq.top();
    long long mxv = pair.first;
    long long pos = pair.second;
    pq.pop();
    long long val = 0;
    val += get(1, 1, n, pos).first;
    val -= get(1, 1, n, pos).second * x[pos];
    remove(1, 1, n, pos);
    if (val < 0) {
      val *= -1;
    }
    ans += val;
  }
  cout << ans << endl;
  return;
}
int main(int argc, char const* argv[]) {
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
