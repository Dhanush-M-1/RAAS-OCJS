#include <bits/stdc++.h>
using namespace std;
namespace math {
inline uint32_t nextPow2_32(uint32_t v) {
  if (!v) {
    return 1;
  }
  uint32_t res = 1U << (31 - __builtin_clz(v));
  return res == v ? res : res << 1;
}
template <typename T = double>
struct Complex {
  inline Complex(T _real = 0, T _imag = 0) : real(_real), imag(_imag) {}
  inline void operator=(const Complex<T>& o) {
    real = o.real;
    imag = o.imag;
  }
  inline void operator+=(const Complex<T>& o) {
    real += o.real;
    imag += o.imag;
  }
  inline void operator*=(const Complex<T>& o) {
    T originalReal = real;
    real = originalReal * o.real - imag * o.imag;
    imag = originalReal * o.imag + imag * o.real;
  }
  inline void operator/=(T scale) {
    real /= scale;
    imag /= scale;
  }
  inline void init(T _real = 0, T _imag = 0) {
    real = _real;
    imag = _imag;
  }
  inline void initPolar(T r, T theta) {
    real = r * cos(theta);
    imag = r * sin(theta);
  }
  inline void initMul(const Complex<T>& x, const Complex<T>& y) {
    real = x.real * y.real - x.imag * y.imag;
    imag = x.real * y.imag + x.imag * y.real;
  }
  inline void initSub(const Complex<T>& x, const Complex<T>& y) {
    real = x.real - y.real;
    imag = x.imag - y.imag;
  }
  inline void flip() {
    real = -real;
    imag = -imag;
  }
  T real, imag;
};
const long double PI = acos(static_cast<long double>(-1));
template <typename T = double>
struct FFTUtils {
  inline FFTUtils(int capacity = -1) {
    if (capacity > 0) {
      capacity = nextPow2_32(capacity);
    }
    capacity = max(capacity, 2);
    _revs.reserve(capacity);
    _revs.resize(2);
    _revs[0] = 0;
    _revs[1] = 1;
    _roots.reserve(capacity | 1);
    _roots.resize(2);
    _roots[0].init(0, 0);
    _roots[1].init(1, 0);
    _initCapacity(capacity);
    _cs.reserve(capacity);
  }
  inline void mulInline(vector<vector<Complex<T>>>& x,
                        vector<vector<Complex<T>>>& y, bool cyclic = false) {
    if (x.empty() || y.empty() || x[0].empty() || y[0].empty()) {
      x.clear();
      return;
    }
    int n = cyclic ? max(max(x.size(), y.size()), max(x[0].size(), y[0].size()))
                   : max(x.size() + y.size(), x[0].size() + y[0].size()) - 1;
    int pow2 = nextPow2_32(n);
    fft(x, false, pow2);
    fft(y, false, pow2);
    for (int i = 0; i < pow2; ++i) {
      for (int j = 0; j < pow2; ++j) {
        x[i][j] *= y[i][j];
      }
    }
    fft(x, true, pow2);
  }
  inline void fft(vector<vector<Complex<T>>>& cs, bool invert, int n = -1) {
    int pow2 = nextPow2_32(n < 0 ? cs.size() : n);
    cs.reserve(pow2);
    for (size_t i = 0; i < pow2; ++i) {
      if (i < cs.size()) {
        fft(cs[i], invert, pow2);
      } else {
        cs.push_back(vector<Complex<T>>(pow2));
      }
    }
    for (int i = 0; i < pow2; ++i) {
      for (int j = i + 1; j < pow2; ++j) {
        swap(cs[i][j], cs[j][i]);
      }
    }
    for (size_t i = 0; i < pow2; ++i) {
      fft(cs[i], invert, pow2);
    }
  }
  inline void fft(vector<Complex<T>>& cs, bool invert, int n = -1) {
    int pow2 = nextPow2_32(n < 0 ? cs.size() : n);
    _initCapacity(pow2);
    _expand(pow2, cs);
    if (invert) {
      reverse(cs.begin() + 1, cs.begin() + pow2);
      for (int i = 0; i < pow2; ++i) {
        cs[i] /= pow2;
      }
    }
    int shift = __builtin_ctz(_revs.size()) - __builtin_ctz(pow2);
    for (int i = 0; i < pow2; ++i) {
      int j = _revs[i] >> shift;
      if (i < j) {
        swap(cs[i], cs[j]);
      }
    }
    const Complex<T>* csEnd = cs.data() + pow2;
    for (int l = 1; l < pow2; l <<= 1) {
      Complex<T>* i = cs.data();
      for (int l2 = l << 1; i != csEnd; i += l2) {
        Complex<T>*k = _roots.data() + l, *ij = i, *ijl = ij + l;
        const Complex<T>* endIj = i + l;
        for (; ij != endIj; ++ij, ++ijl, ++k) {
          _c.initMul(*ijl, *k);
          ijl->initSub(*ij, _c);
          *ij += _c;
        }
      }
    }
  }
  inline void _expand(int pow2, vector<Complex<T>>& cs) {
    for (size_t i = cs.size(); i < pow2; ++i) {
      cs.emplace_back(0, 0);
    }
  }
  inline void _initCapacity(int pow2) {
    if (_revs.size() >= pow2) {
      return;
    }
    int oldPow2 = _revs.size(), lgN = __builtin_ctz(pow2);
    _revs.resize(pow2);
    for (int i = 0; i < pow2; ++i) {
      _revs[i] = (_revs[i >> 1] >> 1) + ((i & 1) << (lgN - 1));
    }
    _roots.resize(pow2);
    for (int i = oldPow2; i < pow2; i <<= 1) {
      T angle = PI / i, baseAngle = angle * 2;
      for (int j = i; j < i << 1; j += 2, angle += baseAngle) {
        _roots[j] = _roots[j >> 1];
        _roots[j | 1].initPolar(1, angle);
      }
    }
  }
  vector<int> _revs;
  vector<Complex<T>> _roots, _cs;
  Complex<T> _c;
};
}  // namespace math
const int MAXN = 400 + 2;
const double EPS = 1E-5;
using COMPLEX_T = double;
int n, m, r, c, nr, mc, pow2;
char board[MAXN][MAXN], pattern[MAXN][MAXN];
math::FFTUtils<COMPLEX_T> fft;
bool valid[MAXN][MAXN];
vector<vector<math::Complex<COMPLEX_T>>> boardCs, patternCs;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < n; ++i) {
    scanf("%s", board[i]);
  }
  scanf("%d%d", &r, &c);
  for (int i = 0; i < r; ++i) {
    scanf("%s", pattern[i]);
  }
  boardCs.resize(n + r);
  for (int i = 0; i < n + r; ++i) {
    boardCs[i].resize(m + c);
    for (int j = 0; j < m + c; ++j) {
      boardCs[i][j].initPolar(1, math::PI / 13 * (board[i % n][j % m] - 'a'));
    }
  }
  patternCs.resize(r);
  int patternCnt = 0;
  for (int i = 0; i < r; ++i) {
    patternCs[r - 1 - i].resize(c);
    for (int j = 0; j < c; ++j) {
      if (pattern[i][j] == '?') {
        patternCs[r - 1 - i][c - 1 - j].init(0, 0);
      } else {
        patternCs[r - 1 - i][c - 1 - j].initPolar(
            1, -math::PI / 13 * (pattern[i][j] - 'a'));
        ++patternCnt;
      }
    }
  }
  fft.mulInline(boardCs, patternCs, true);
  for (int i = 0; i < n; ++i) {
    for (int j = 0; j < m; ++j) {
      putchar(fabs(boardCs[i + r - 1][j + c - 1].real - patternCnt) < EPS
                  ? '1'
                  : '0');
    }
    putchar('\n');
  }
}
