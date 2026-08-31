#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:500000000")
using namespace std;
template <typename Type, class MainOperator, class AddOperator = MainOperator>
class SegmentTree {
 protected:
  vector<Type> t;
  int ppow;
  Type defaultValue;
  MainOperator Operator;
  AddOperator addOperator;
  void _construct(int size, Type defaultValue, Type value) {
    ppow = size;
    while (ppow & (ppow - 1)) ppow++;
    this->defaultValue = defaultValue;
    t.resize(ppow * 2);
    for (int i = 0; i < ppow; i++)
      t[i + ppow] = i < size ? value : defaultValue;
    for (int i = ppow - 1; i > 0; i--) t[i] = Operator(t[i * 2], t[i * 2 + 1]);
  }

 public:
  SegmentTree(int size, Type defaultValue) {
    _construct(size, defaultValue, defaultValue);
  }
  SegmentTree(int size, Type defaultValue, Type value) {
    _construct(size, defaultValue, value);
  }
  template <typename Iterator>
  SegmentTree(Iterator begin, Iterator end, Type defaultValue) {
    this->defaultValue = defaultValue;
    vector<Type> values(begin, end);
    ppow = values.size();
    while (ppow & (ppow - 1)) ppow++;
    t.assign(ppow * 2, defaultValue);
    for (int i = 0; i < (int)values.size(); i++) t[i + ppow] = values[i];
    for (int i = ppow - 1; i > 0; i--) t[i] = Operator(t[i * 2], t[i * 2 + 1]);
  }
  Type Get(int L, int R) {
    L += ppow;
    R += ppow;
    Type res = defaultValue;
    while (L <= R) {
      if (L & 1) res = Operator(res, t[L++]);
      if (~R & 1) res = Operator(res, t[R--]);
      L /= 2;
      R /= 2;
    }
    return res;
  }
  void Add(int pos, Type value) {
    pos += ppow;
    t[pos] = addOperator(t[pos], value);
    pos /= 2;
    while (pos > 0) {
      t[pos] = Operator(t[pos * 2], t[pos * 2 + 1]);
      pos /= 2;
    }
  }
  void Set(int pos, Type value) {
    pos += ppow;
    t[pos] = value;
    pos /= 2;
    while (pos > 0) {
      t[pos] = Operator(t[pos * 2], t[pos * 2 + 1]);
      pos /= 2;
    }
  }
};
template <typename Type>
struct Sum {
  Type operator()(Type a, Type b) { return a + b; }
};
template <typename Type>
struct Min {
  Type operator()(Type a, Type b) { return a < b ? a : b; }
};
template <typename Type>
struct Max {
  Type operator()(Type a, Type b) { return a > b ? a : b; }
};
int main() {
  int n, k, a, b, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  SegmentTree<long long, Sum<int> > t1(n, 0ll);
  SegmentTree<long long, Sum<int> > t2(n, 0ll);
  while (q--) {
    int type, pos, val;
    scanf("%d %d", &type, &pos);
    pos--;
    if (type == 1) {
      scanf("%d", &val);
      auto v1 = t1.Get(pos, pos);
      v1 = min((long long)a, v1 + val);
      t1.Set(pos, v1);
      auto v2 = t2.Get(pos, pos);
      v2 = min((long long)b, v2 + val);
      t2.Set(pos, v2);
    } else {
      printf("%I64d\n", t2.Get(0, pos - 1) + t1.Get(pos + k, n - 1));
    }
  }
}
