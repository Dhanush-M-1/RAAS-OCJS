#include <bits/stdc++.h>
using namespace std;
template <typename T>
T read() {
  T res;
  std::cin >> res;
  return res;
}
template <typename T>
void print(const T& t) {
  std::cout << t;
}
template <>
int read<int>() {
  int res;
  scanf("%d", &res);
  return res;
}
template <>
void print<int>(const int& t) {
  printf("%d", t);
};
template <>
unsigned int read<unsigned int>() {
  unsigned int res;
  scanf("%u", &res);
  return res;
}
template <>
void print<unsigned int>(const unsigned int& t) {
  printf("%u", t);
};
template <>
int64_t read<int64_t>() {
  int64_t res;
  scanf("%lld", &res);
  return res;
}
template <>
void print<int64_t>(const int64_t& t) {
  printf("%lld", t);
};
template <>
float read<float>() {
  float res;
  scanf("%f", &res);
  return res;
}
template <>
void print<float>(const float& t) {
  printf("%f", t);
};
template <>
double read<double>() {
  double res;
  scanf("%lf", &res);
  return res;
}
template <>
void print<double>(const double& t) {
  printf("%lf", t);
};
template <>
char read<char>() {
  char res;
  scanf("%c", &res);
  return res;
}
template <>
void print<char>(const char& t) {
  printf("%c", t);
};
namespace updateTypes {
template <typename T>
struct IncreaseBy {
 public:
  IncreaseBy(T value = T(0)) : value_(std::move(value)) {}
  friend IncreaseBy<T> operator*(const IncreaseBy<T>& lh,
                                 const IncreaseBy<T>& rh) {
    return {lh.value_ + rh.value_};
  }
  T value_;
};
}  // namespace updateTypes
template <typename UpdateType, typename BinaryFunctor>
struct UpdateApplier {};
template <typename T>
struct UpdateApplier<updateTypes::IncreaseBy<T>, std::plus<T>> {
  static T apply(const T& v, const updateTypes::IncreaseBy<T>& upd,
                 size_t cnt) {
    return v + cnt * upd.value_;
  }
};
using std::vector;
template <typename ValueType, class AggregatingFunction, class UpdateType>
class SegmentTree {
 public:
  SegmentTree(const vector<ValueType>& initialValues,
              AggregatingFunction aggregatingFunction)
      : aggregatingFunction_(aggregatingFunction), size_(initialValues.size()) {
    auto heapSize = (size_t(1) << calcHeight_(size_)) - 1;
    valuesHeap_.resize(heapSize);
    lazyUpdatesHeap_.resize(heapSize);
    build_(begin(initialValues), end(initialValues), 0);
  }
  void updateElement(size_t i, UpdateType upd) { updateRange(i, i + 1, upd); }
  void updateRange(size_t l, size_t r, UpdateType upd) {
    if (l == r) return;
    update_(l, r, upd, 0, 0, size_);
  }
  ValueType getValueOnSegment(size_t l, size_t r) const {
    return calcValueOnSegment_(l, r, UpdateType(), 0, 0, size_);
  }

 private:
  void build_(typename vector<ValueType>::const_iterator left,
              typename vector<ValueType>::const_iterator right, size_t ind) {
    if (right - left == 1) {
      valuesHeap_[ind] = *left;
    } else {
      auto center = left + (right - left) / 2;
      build_(left, center, leftChild_(ind));
      build_(center, right, rightChild_(ind));
      valuesHeap_[ind] = aggregatingFunction_(valuesHeap_[leftChild_(ind)],
                                              valuesHeap_[rightChild_(ind)]);
    }
  }
  void update_(size_t l, size_t r, const UpdateType& upd, size_t nodeInd,
               size_t nodeLeft, size_t nodeRight) {
    if (l == nodeLeft && r == nodeRight) {
      lazyUpdatesHeap_[nodeInd] = upd * lazyUpdatesHeap_[nodeInd];
      return;
    }
    lazyUpdatesHeap_[leftChild_(nodeInd)] =
        lazyUpdatesHeap_[nodeInd] * lazyUpdatesHeap_[leftChild_(nodeInd)];
    lazyUpdatesHeap_[rightChild_(nodeInd)] =
        lazyUpdatesHeap_[nodeInd] * lazyUpdatesHeap_[rightChild_(nodeInd)];
    lazyUpdatesHeap_[nodeInd] = UpdateType();
    auto nodeCenter = (nodeLeft + nodeRight) / 2;
    if (r <= nodeCenter) {
      update_(l, r, upd, leftChild_(nodeInd), nodeLeft, nodeCenter);
    } else if (l >= nodeCenter) {
      update_(l, r, upd, rightChild_(nodeInd), nodeCenter, nodeRight);
    } else {
      update_(l, nodeCenter, upd, leftChild_(nodeInd), nodeLeft, nodeCenter);
      update_(nodeCenter, r, upd, rightChild_(nodeInd), nodeCenter, nodeRight);
    }
    valuesHeap_[nodeInd] = aggregatingFunction_(
        calcValueOnSegment_(nodeLeft, nodeCenter, {}, leftChild_(nodeInd),
                            nodeLeft, nodeCenter),
        calcValueOnSegment_(nodeCenter, nodeRight, {}, rightChild_(nodeInd),
                            nodeCenter, nodeRight));
  }
  static size_t leftChild_(size_t ind) { return 2 * ind + 1; }
  static size_t rightChild_(size_t ind) { return 2 * ind + 2; }
  ValueType calcValueOnSegment_(size_t l, size_t r, UpdateType upd,
                                size_t nodeInd, size_t nodeLeft,
                                size_t nodeRight) const {
    assert(l >= nodeLeft);
    assert(r <= nodeRight);
    upd = upd * lazyUpdatesHeap_[nodeInd];
    if (l == nodeLeft && r == nodeRight)
      return UpdateApplier<UpdateType, AggregatingFunction>::apply(
          valuesHeap_[nodeInd], upd, r - l);
    auto nodeCenter = (nodeLeft + nodeRight) / 2;
    if (r <= nodeCenter)
      return calcValueOnSegment_(l, r, upd, leftChild_(nodeInd), nodeLeft,
                                 nodeCenter);
    else if (l >= nodeCenter)
      return calcValueOnSegment_(l, r, upd, rightChild_(nodeInd), nodeCenter,
                                 nodeRight);
    else
      return aggregatingFunction_(
          calcValueOnSegment_(l, nodeCenter, upd, leftChild_(nodeInd), nodeLeft,
                              nodeCenter),
          calcValueOnSegment_(nodeCenter, r, upd, rightChild_(nodeInd),
                              nodeCenter, nodeRight));
  }
  int calcHeight_(size_t length) const {
    int result = 1;
    size_t maxLen = 1;
    while (length > maxLen) {
      maxLen *= 2;
      result++;
    }
    return result;
  }

 private:
  const AggregatingFunction aggregatingFunction_;
  size_t size_;
  vector<ValueType> valuesHeap_;
  vector<UpdateType> lazyUpdatesHeap_;
};
template <typename ValueType, class AggregatingFunction, class UpdateType>
SegmentTree<ValueType, AggregatingFunction, UpdateType> makeSegmentTree(
    const vector<ValueType>& initialValues,
    AggregatingFunction aggregatingFunction, UpdateType dummy) {
  return SegmentTree<ValueType, AggregatingFunction, UpdateType>(
      initialValues, aggregatingFunction);
}
namespace internal {
template <typename ValueT>
class IterableRange {
 public:
  class iterator {
   public:
    iterator(ValueT v__) : v_(v__) {}
    iterator& operator++() {
      ++v_;
      return *this;
    }
    bool operator==(iterator rhs) const { return v_ == rhs.v_; }
    bool operator!=(iterator rhs) const { return v_ != rhs.v_; }
    ValueT operator*() const { return v_; }
    ValueT operator->() const { return v_; }

   private:
    ValueT v_ = {};
  };
  IterableRange(ValueT begin__, ValueT end__)
      : begin_value_(std::min(begin__, end__)), end_value_(end__) {}
  iterator begin() const { return {begin_value_}; }
  iterator end() const { return {end_value_}; }

 private:
  ValueT begin_value_ = {};
  ValueT end_value_ = {};
};
}  // namespace internal
template <typename ValueT>
internal::IterableRange<ValueT> range(ValueT end) {
  return {{}, end};
}
template <typename ValueT>
internal::IterableRange<ValueT> range(ValueT begin, ValueT end) {
  return {begin, end};
}
template <typename T>
void printVector(const std::vector<T>& out, std::string delimiter = " ") {
  if (out.empty()) return;
  for (size_t i = 0; i < out.size() - 1; ++i) std::cout << out[i] << delimiter;
  std::cout << out.back();
}
using namespace std;
class Solver634C {
 public:
  void run();
};
void Solver634C::run() {
  int nDays, repairLen, produceBeforeRepair, produceAfterRepair, nQueries;
  cin >> nDays >> repairLen >> produceAfterRepair >> produceBeforeRepair >>
      nQueries;
  vector<int> result;
  vector<int> nRequests(nDays, 0);
  auto streeBefore =
      makeSegmentTree(nRequests, plus<int>(), updateTypes::IncreaseBy<int>());
  auto streeAfter =
      makeSegmentTree(nRequests, plus<int>(), updateTypes::IncreaseBy<int>());
  for (int i : range(nQueries)) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, a;
      cin >> d >> a;
      --d;
      auto currBefore = streeBefore.getValueOnSegment(d, d + 1);
      auto incrBefore = min(a, produceBeforeRepair - currBefore);
      streeBefore.updateElement(d, updateTypes::IncreaseBy<int>(incrBefore));
      auto currAfter = streeAfter.getValueOnSegment(d, d + 1);
      auto incrAfter = min(a, produceAfterRepair - currAfter);
      streeAfter.updateElement(d, updateTypes::IncreaseBy<int>(incrAfter));
    } else {
      int p;
      cin >> p;
      --p;
      auto fullfillBeforeRepair =
          (p > 0) ? streeBefore.getValueOnSegment(0, p) : 0;
      auto fullfillAfterRepair =
          (nDays > p + repairLen)
              ? streeAfter.getValueOnSegment(p + repairLen, nDays)
              : 0;
      result.push_back(fullfillBeforeRepair + fullfillAfterRepair);
    }
  }
  printVector(result, "\n");
}
int main() {
  Solver634C solver;
  solver.run();
}
