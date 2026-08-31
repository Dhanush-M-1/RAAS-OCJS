#include <bits/stdc++.h>
using std::size_t;
template <typename T, typename Op = std::plus<T>>
class SegmentTree {
  std::vector<T> arr;
  int n;
  Op op;

 public:
  template <class InputIterator>
  SegmentTree(size_t n_, InputIterator begin);
  SegmentTree(size_t n_, const T& value = T());
  const T& operator[](size_t i) const;
  inline T query(size_t l, size_t r) const;
  void modify(size_t i, const T& value);
};
template <class T, typename Op>
template <class InputIterator>
SegmentTree<T, Op>::SegmentTree(size_t n_, InputIterator begin)
    : n(n_), arr(n_ << 1) {
  for (int i = n; i != n << 1; ++i) {
    arr[i] = *begin;
    ++begin;
  }
  for (int i = n - 1; i >= 0; --i) {
    arr[i] = op(arr[i << 1], arr[(i << 1) ^ 1]);
  }
}
template <class T, typename Op>
SegmentTree<T, Op>::SegmentTree(size_t n_, const T& value)
    : n(n_), arr(n_ << 1, value) {
  for (int i = n - 1; i >= 0; --i) {
    arr[i] = op(arr[i << 1], arr[(i << 1) ^ 1]);
  }
}
template <class T, typename Op>
inline const T& SegmentTree<T, Op>::operator[](size_t i) const {
  return arr[i + n];
}
template <class T, typename Op>
T SegmentTree<T, Op>::query(size_t l, size_t r) const {
  bool linit = false, rinit = false;
  T ltail, rtail;
  l += n, r += n;
  while (l < r) {
    if (l & 1) {
      if (linit) {
        ltail = op(ltail, arr[l++]);
      } else {
        ltail = arr[l++];
        linit = true;
      }
    }
    if (r & 1) {
      if (rinit) {
        rtail = op(arr[--r], rtail);
      } else {
        rtail = arr[--r];
        rinit = true;
      }
    }
    l >>= 1, r >>= 1;
  }
  if (!linit) {
    return rtail;
  } else if (!rinit) {
    return ltail;
  } else {
    return op(ltail, rtail);
  }
}
template <class T, typename Op>
void SegmentTree<T, Op>::modify(size_t i, const T& value) {
  i += n;
  arr[i] = value;
  while (i > 1) {
    arr[i >> 1] = op(arr[i], arr[i ^ 1]);
    i >>= 1;
  }
}
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  vector<int> p(n);
  vector<long long> s(n);
  for (long long& s_i : s) scanf("%lld", &s_i);
  vector<long long> range(n);
  iota(range.begin(), range.end(), 1);
  SegmentTree<long long> T(n, range.begin());
  for (int i = n - 1; i >= 0; --i) {
    int x = 0, z = n, y = n >> 1;
    while (x != y) {
      (s[i] < T.query(0, y)) ? z = y : x = y;
      y = (x + z) >> 1;
    }
    T.modify(x, 0);
    p[i] = x + 1;
  }
  for (int x : p) printf("%d ", x);
}
