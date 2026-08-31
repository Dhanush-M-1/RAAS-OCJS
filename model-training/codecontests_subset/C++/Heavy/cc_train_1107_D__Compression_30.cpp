#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ull = unsigned long long;
template <size_t l>
using BS = bitset<l>;
template <typename T>
using D = deque<T>;
template <typename T>
using L = list<T>;
template <typename T>
using MS = multiset<T>;
template <typename T, typename U>
using P = pair<T, U>;
template <typename T>
using Q = queue<T>;
template <typename T>
using S = set<T>;
template <typename T, typename U>
using UM = unordered_map<T, U>;
template <typename T>
using UMS = unordered_multiset<T>;
template <typename T>
using US = unordered_set<T>;
template <typename T>
using V = vector<T>;
template <typename T>
ostream& operator<<(ostream& os, const D<T>& d) {
  os << "d[";
  for (auto it = d.begin(), next = d.begin(); d.end() != next; it = next) {
    os << *it;
    ++next;
    if (d.end() != next) {
      os << ", ";
    }
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const L<T>& l) {
  os << "l[";
  for (auto it = l.begin(), next = l.begin(); l.end() != next; it = next) {
    os << *it;
    ++next;
    if (l.end() != next) {
      os << ", ";
    }
  }
  return os << "]";
}
template <typename T>
ostream& operator<<(ostream& os, const MS<T>& ms) {
  os << "m{";
  for (auto it = ms.begin(), next = ms.begin(); ms.end() != next; it = next) {
    os << *it;
    ++next;
    if (ms.end() != next) {
      os << ", ";
    }
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const S<T>& s) {
  os << "{";
  for (auto it = s.begin(), next = s.begin(); s.end() != next; it = next) {
    os << *it;
    ++next;
    if (s.end() != next) {
      os << ", ";
    }
  }
  return os << "}";
}
template <typename T, typename U>
ostream& operator<<(ostream& os, const UM<T, U>& um) {
  os << "um{";
  for (auto it = um.begin(), next = um.begin(); um.end() != next; it = next) {
    os << it->first << ": " << it->second;
    ++next;
    if (um.end() != next) {
      os << ", ";
    }
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const UMS<T>& ums) {
  os << "ums{";
  for (auto it = ums.begin(), next = ums.begin(); ums.end() != next;
       it = next) {
    os << *it;
    ++next;
    if (ums.end() != next) {
      os << ", ";
    }
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const US<T>& us) {
  os << "us{";
  for (auto it = us.begin(), next = us.begin(); us.end() != next; it = next) {
    os << *it;
    ++next;
    if (us.end() != next) {
      os << ", ";
    }
  }
  return os << "}";
}
template <typename T>
ostream& operator<<(ostream& os, const V<T>& v) {
  os << "[";
  for (auto it = v.begin(), next = v.begin(); v.end() != next; it = next) {
    os << *it;
    ++next;
    if (v.end() != next) {
      os << ", ";
    }
  }
  return os << "]";
}
template <typename T>
const T& abs(const T& x) {
  if (x >= 0) {
    return x;
  }
  return -x;
}
template <typename T>
V<T>& uniq(V<T>& v) {
  const auto newend_it = unique(v.begin(), v.end());
  v.resize(newend_it - v.begin());
  return v;
}
template <typename T>
struct E {
  T u, v;
};
template <typename T>
ostream& operator<<(ostream& os, const E<T>& e) {
  return os << "(" << e.u << ", " << e.v << ")";
}
template <typename T>
bool operator<(const E<T>& l, const E<T>& r) {
  return l.u < r.u || (l.u == r.u && l.v < r.v);
}
template <typename T>
constexpr T cshift(const T t, size_t left_shift_bits = 1) {
  constexpr size_t T_bits = sizeof(T) * 8;
  left_shift_bits %= T_bits;
  left_shift_bits += T_bits;
  left_shift_bits %= T_bits;
  const size_t right_shift_bits = T_bits - left_shift_bits;
  return (t << left_shift_bits) ^ (t >> right_shift_bits);
}
template <typename T>
size_t numdigits(T x, size_t base = 10) {
  size_t ret = 0;
  while (x > 0) {
    x /= base;
    ++ret;
  }
  return ret;
}
UM<char, string> LOOKUP = {
    {'0', "0000"}, {'1', "0001"}, {'2', "0010"}, {'3', "0011"},
    {'4', "0100"}, {'5', "0101"}, {'6', "0110"}, {'7', "0111"},
    {'8', "1000"}, {'9', "1001"}, {'A', "1010"}, {'B', "1011"},
    {'C', "1100"}, {'D', "1101"}, {'E', "1110"}, {'F', "1111"},
};
size_t n;
V<string> A;
V<BS<5200>> X, Y;
V<int> divs;
int main() {
  cin >> n;
  A = V<string>(n);
  for (int i = 0; i < int(n); i++) {
    string tmp;
    cin >> tmp;
    for (const char& ch : tmp) {
      A[i] += LOOKUP[ch];
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (n % i == 0) {
      divs.push_back(i);
    }
  }
  X = V<BS<5200>>(n);
  for (int i = 0; i < int(n); i++) {
    X[i] = BS<5200>(A[i]);
  }
  Y = V<BS<5200>>(n);
  for (int i = 0; i < int(n); i++) {
    for (int j = 0; j < int(n); j++) {
      Y[i][j] = X[j][i];
    }
  }
  for (auto it = divs.rbegin(); divs.rend() != it; ++it) {
    const int d = *it;
    if (d == 1) {
      cout << d << endl;
      return 0;
    }
    BS<5200> mask = 0b1, tmpbs;
    tmpbs = mask;
    int tmpd = d;
    do {
      mask = tmpbs;
      tmpbs = mask | (mask << tmpd);
      tmpd *= 2;
    } while (mask != tmpbs);
    mask.flip();
    for (int i = 0; i < int(n); i++) {
      if (!(((((X[i] & (mask >> 1)) << 1) | ((X[i] & mask) >> 1)) == X[i]) &&
            ((((Y[i] & (mask >> 1)) << 1) | ((Y[i] & mask) >> 1)) == Y[i]))) {
        goto breakcontinue;
      }
    }
    cout << d << endl;
    return 0;
  breakcontinue:;
  }
  return 0;
}
