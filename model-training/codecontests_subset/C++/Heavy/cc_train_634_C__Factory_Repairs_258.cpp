#include <bits/stdc++.h>
using namespace std;
template <typename T, typename T1>
ostream &operator<<(ostream &out, pair<T, T1> obj) {
  out << "(" << obj.first << "," << obj.second << ")";
  return out;
}
template <typename T, typename T1>
ostream &operator<<(ostream &out, map<T, T1> cont) {
  typename map<T, T1>::const_iterator itr = cont.begin();
  typename map<T, T1>::const_iterator ends = cont.end();
  for (; itr != ends; ++itr) out << *itr << " ";
  out << endl;
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, set<T> cont) {
  typename set<T>::const_iterator itr = cont.begin();
  typename set<T>::const_iterator ends = cont.end();
  for (; itr != ends; ++itr) out << *itr << " ";
  out << endl;
  return out;
}
template <typename T>
ostream &operator<<(ostream &out, multiset<T> cont) {
  typename multiset<T>::const_iterator itr = cont.begin();
  typename multiset<T>::const_iterator ends = cont.end();
  for (; itr != ends; ++itr) out << *itr << " ";
  out << endl;
  return out;
}
template <typename T,
          template <typename ELEM, typename ALLOC = allocator<ELEM>> class CONT>
ostream &operator<<(ostream &out, CONT<T> cont) {
  typename CONT<T>::const_iterator itr = cont.begin();
  typename CONT<T>::const_iterator ends = cont.end();
  for (; itr != ends; ++itr) out << *itr << " ";
  out << endl;
  return out;
}
template <typename T, unsigned int N, typename CTy, typename CTr>
typename enable_if<!is_same<T, char>::value, basic_ostream<CTy, CTr> &>::type
operator<<(basic_ostream<CTy, CTr> &out, const T (&arr)[N]) {
  for (auto i = 0; i < N; ++i) out << arr[i] << " ";
  out << endl;
  return out;
}
template <typename T>
T gcd(T a, T b) {
  T min_v = min(a, b);
  T max_v = max(a, b);
  while (min_v) {
    T temp = max_v % min_v;
    max_v = min_v;
    min_v = temp;
  }
  return max_v;
}
template <typename T>
T lcm(T a, T b) {
  return (a * b) / gcd(a, b);
}
template <typename T>
T fast_exp_pow(T base, T exp, T mod) {
  long long res = 1;
  while (exp) {
    if (exp & 1) {
      res *= base;
      res %= mod;
    }
    exp >>= 1;
    base *= base;
    base %= mod;
  }
  return res;
}
int N, K, A, B, Q, D, P, ch;
long long bit_b[200010], bit_a[200010];
long long values[200010][2];
long long ret;
long long getSum(long long *bit, int ind) {
  long long sum = 0;
  while (ind) {
    sum += bit[ind];
    ind -= ind & (-ind);
  }
  return sum;
}
void updateBit(long long *bit, int ind, long long val) {
  while (ind <= N) {
    bit[ind] += val;
    ind += ind & (-ind);
  }
}
int main() {
  scanf("%d%d%d%d%d", &N, &K, &A, &B, &Q);
  for (auto q = 1; q <= Q; ++q) {
    scanf("%d", &ch);
    if (ch == 1) {
      scanf("%d%d", &D, &P);
      updateBit(bit_b, D, min((long long)B - values[D][0], (long long)P));
      updateBit(bit_a, D, min((long long)A - values[D][1], (long long)P));
      values[D][0] = min(values[D][0] + P, (long long)B);
      values[D][1] = min(values[D][1] + P, (long long)A);
    } else if (ch == 2) {
      scanf("%d", &P);
      ret = getSum(bit_b, P - 1) + getSum(bit_a, N) - getSum(bit_a, P + K - 1);
      printf("%I64d\n", ret);
    }
  }
  return 0;
}
