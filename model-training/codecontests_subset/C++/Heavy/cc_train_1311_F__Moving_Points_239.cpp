#include <bits/stdc++.h>
using ll = long long;
using namespace std;
template <class T>
class SegmentTree {
 private:
  int _size = 1;
  T _def;
  std::vector<T> _nodes;
  std::function<T(T, T)> _op;
  std::function<T(T, T)> _update_op;

 public:
  SegmentTree(int size, T default_value, std::function<T(T, T)> op,
              std::function<T(T, T)> update_op)
      : _def(default_value), _op(op), _update_op(update_op) {
    while (_size < size) _size *= 2;
    _nodes = std::vector<T>(2 * _size, default_value);
  }
  SegmentTree(std::vector<T> nodes, T default_value, std::function<T(T, T)> op,
              std::function<T(T, T)> update_op)
      : _def(default_value), _op(op), _update_op(update_op) {
    int real_size = nodes.size();
    while (_size < real_size) _size *= 2;
    _nodes = std::vector<T>(2 * _size, default_value);
    for (int i = 0; i < real_size; ++i) _nodes[i + _size] = nodes[i];
    for (int i = _size - 1; i >= 0; --i)
      _nodes[i] = _op(_nodes[i * 2], _nodes[i * 2 + 1]);
  }
  T find(int l, int r) { return find(l, r, 1, 0, _size); }
  T find(int l, int r, int index, int cover_l, int cover_r) {
    if (cover_r <= l || r <= cover_l) return _def;
    if (l <= cover_l && cover_r <= r) return _nodes[index];
    return _op(find(l, r, index * 2, cover_l, (cover_l + cover_r) >> 1),
               find(l, r, index * 2 + 1, (cover_l + cover_r) >> 1, cover_r));
  }
  void update(int index, T value) {
    index += _size;
    _nodes[index] = _update_op(_nodes[index], value);
    while (index > 0) {
      index >>= 1;
      _nodes[index] = _op(_nodes[index * 2], _nodes[index * 2 + 1]);
    }
  }
};
struct Point {
  ll x, v;
  bool operator<(const Point &other) const { return x < other.x; }
};
int main() {
  cin.tie(nullptr);
  ios::sync_with_stdio(false);
  cout << fixed << setprecision(15);
  int n;
  cin >> n;
  int x, v;
  set<int> vs;
  vector<Point> ps;
  for (ll i = 0, iLen = (n); i < iLen; ++i) {
    cin >> x;
    ps.push_back(Point{x, 0});
  }
  for (ll i = 0, iLen = (n); i < iLen; ++i) {
    cin >> v;
    ps[i].v = v;
    vs.insert(v);
  }
  map<int, int> v_comp;
  int i = 0;
  for (auto &v : vs) {
    v_comp[v] = i++;
  }
  int v_size = v_comp.size() + 10;
  auto x_cnt = SegmentTree<ll>(
      v_size, 0, [](ll x, ll y) { return x + y; },
      [](ll x, ll y) { return x + y; });
  auto x_acc = SegmentTree<ll>(
      v_size, 0, [](ll x, ll y) { return x + y; },
      [](ll x, ll y) { return x + y; });
  for (ll i = 0, iLen = (n); i < iLen; ++i) {
    ps[i].v = v_comp[ps[i].v];
    x_cnt.update(ps[i].v, 1);
    x_acc.update(ps[i].v, ps[i].x);
  }
  sort(ps.begin(), ps.end());
  ll ans = 0;
  for (auto &[x, v] : ps) {
    x_cnt.update(v, -1);
    x_acc.update(v, -x);
    ans += x_acc.find(v, v_size) - x_cnt.find(v, v_size) * x;
  }
  cout << ans << endl;
}
