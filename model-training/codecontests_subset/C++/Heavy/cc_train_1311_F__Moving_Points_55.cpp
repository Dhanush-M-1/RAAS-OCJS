#include <bits/stdc++.h>
using namespace std;
template <class T>
struct fen {
  vector<T> fenwick;
  long long size;
  fen(long long sz) {
    size = sz;
    fenwick.resize(size);
    for (long long i = 0; i < size; i++) fenwick[i] = 0;
  }
  fen(vector<T> arr) {
    size = arr.size();
    fenwick.resize(size);
    for (long long i = 0; i < size; i++) fenwick[i](0);
    for (long long i = 0; i < size; i++) update(i, arr[i]);
  }
  void add(long long index, T add) {
    for (long long k = index; k < size; k |= (~k & -~k)) {
      fenwick[k] = fenwick[k] + add;
    }
  }
  void update(long long index, T nval) {
    add(index, nval - rangeQuery(index, index));
  }
  T query(long long to) {
    if (to < 0) return 0;
    T sum = 0;
    for (long long curr = to + 1; curr > 0; curr ^= (curr & -curr)) {
      sum = sum + fenwick[curr - 1];
    }
    return sum;
  }
  T rangeQuery(long long from, long long to) {
    if (from > to) return 0;
    if (!from) return query(to);
    return query(to) - query(from - 1);
  }
  void prll() {
    for (long long i = 0; i < size; i++) cout << query(i) << " ";
    cout << endl;
  }
};
const long long sz = 2e5 + 5;
long long n;
pair<long long, long long> xv[sz];
vector<int> tmp;
map<int, int> rkspeed;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> xv[i].first;
  for (long long i = 0; i < n; i++) cin >> xv[i].second;
  sort(xv, xv + n);
  for (long long i = 0; i < n; i++) tmp.push_back(xv[i].second);
  sort(tmp.begin(), tmp.end());
  vector<int> t2{tmp[0]};
  for (long long i = 1; i < n; i++) {
    if (tmp[i] != t2.back()) t2.push_back(tmp[i]);
  }
  for (long long i = 0; i < t2.size(); i++) rkspeed[t2[i]] = i;
  fen<int> fcnt(n);
  fen<long long> sums(n);
  long long tot = 0;
  for (long long i = 0; i < n; i++) {
    int mrk = rkspeed[xv[i].second];
    long long bamt = fcnt.query(mrk);
    tot += bamt * xv[i].first - sums.query(mrk);
    fcnt.add(mrk, 1);
    sums.add(mrk, xv[i].first);
  }
  cout << tot;
  return 0;
}
