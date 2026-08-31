#include <bits/stdc++.h>
using namespace std;
template <class Ch, class Tr, class Container>
basic_ostream<Ch, Tr>& operator<<(basic_ostream<Ch, Tr>& os,
                                  Container const& x) {
  os << "{ ";
  for (auto& y : x) os << y << " ";
  return os << "}";
}
template <class X, class Y>
ostream& operator<<(ostream& os, pair<X, Y> const& p) {
  return os << "[ " << p.first << ", " << p.second << "]";
}
typedef struct {
  long long pos, v;
} Point;
long long P[200005], V[200005], sum = 0, maxNeg = 0;
long long l = 0, r = 100000000;
int n;
vector<Point> v;
set<long long> usados;
map<long long, long long> DondeEsta;
bool sort_vel(Point a, Point b) {
  if (a.v == b.v) return a.pos > b.pos;
  return a.v > b.v;
}
bool sort_pos(Point a, Point b) { return a.pos < b.pos; }
long long ft[200005];
long long ft2[200005];
void upd(int i0, long long v) {
  for (int i = i0 + 1; i <= 200005; i += i & -i) ft[i] += v;
}
long long get(int i0) {
  long long r = 0;
  for (int i = i0; i; i -= i & -i) r += ft[i];
  return r;
}
long long get_sum(int i0, int i1) { return get(i1) - get(i0); }
void upd2(int i0, long long v) {
  for (int i = i0 + 1; i <= 200005; i += i & -i) ft2[i] += v;
}
long long get2(int i0) {
  long long r = 0;
  for (int i = i0; i; i -= i & -i) r += ft2[i];
  return r;
}
long long get_sum2(int i0, int i1) { return get2(i1) - get2(i0); }
int main() {
  cin >> n;
  for (int i = 0; i < (n); i++) cin >> P[i];
  for (int i = 0; i < (n); i++) {
    cin >> V[i];
    v.push_back({P[i], V[i]});
  }
  sort((v.begin()), (v.end()), sort_pos);
  for (int i = 0; i < (n); i++) {
    upd(i, r - v[i].pos);
    upd2(i, 1);
  }
  for (int i = 0; i < (n); i++) DondeEsta[v[i].pos] = i;
  sort((v.begin()), (v.end()), sort_vel);
  for (auto x : v) {
    long long i = DondeEsta[x.pos];
    sum += get_sum(0, i) - ((r - x.pos) * get_sum2(0, i));
    upd(i, x.pos - r);
    upd2(i, -1);
  }
  cout << sum << endl;
  return 0;
}
