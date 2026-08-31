#include <bits/stdc++.h>
using namespace std;
namespace io {
const int _kReadBufferSize = 1 << 15;
char _readBuffer[_kReadBufferSize];
int _readPos;
int _readLength;
bool _ended = false;
inline void _loadBuffer() {
  _readLength = static_cast<int>(
      fread(_readBuffer, sizeof(char), _kReadBufferSize, stdin));
  _readPos = 0;
}
inline char readChar(bool advance = true) {
  if (_ended) {
    return 0;
  }
  if (_readPos >= _readLength) {
    _loadBuffer();
    if (_readLength == 0) {
      _ended = true;
      return 0;
    }
  }
  return _readBuffer[advance ? _readPos++ : _readPos];
}
inline int readCharArray(char* s) {
  char ch;
  while (true) {
    ch = readChar(false);
    if (!ch) {
      return 0;
    }
    if (!isspace(ch)) {
      break;
    }
    ++_readPos;
  }
  *s++ = readChar(true);
  int res = 1;
  while (true) {
    ch = readChar(false);
    if (!ch) {
      return res;
    }
    if (isspace(ch)) {
      break;
    }
    *s++ = ch;
    ++res;
    ++_readPos;
  }
  *s = '\0';
  return res;
}
template <typename T>
inline bool readInt(T& res) {
  char ch;
  while (true) {
    ch = readChar(false);
    if (!ch) {
      return false;
    }
    if (!isspace(ch)) {
      break;
    }
    ++_readPos;
  }
  ch = readChar(false);
  bool negative = ch == '-';
  if (negative) {
    ++_readPos;
  }
  res = 0;
  while (true) {
    ch = readChar(false);
    if (!isdigit(ch)) {
      break;
    }
    res = (res << 3) + (res << 1) + (ch & 15);
    ++_readPos;
  }
  if (negative) {
    res = -res;
  }
  return true;
}
const int _kWriteBufferSize = 1 << 15;
int _writePos = 0;
char _writeBuffer[_kWriteBufferSize];
inline void writeChar(char x) {
  if (_writePos == _kWriteBufferSize) {
    fwrite(_writeBuffer, 1, _kWriteBufferSize, stdout);
    _writePos = 0;
  }
  _writeBuffer[_writePos++] = x;
}
struct _Flusher {
  inline void flush() {
    if (_writePos) {
      fwrite(_writeBuffer, 1, _writePos, stdout);
      _writePos = 0;
    }
    fflush(stdout);
  }
  inline ~_Flusher() { flush(); }
} _flusher;
}  // namespace io
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
  inline void operator+=(const Complex<T>& o) {
    real += o.real;
    imag += o.imag;
  }
  inline Complex<T> operator*(const Complex<T>& o) const {
    return Complex<T>(real * o.real - imag * o.imag,
                      real * o.imag + o.real * imag);
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
  inline void initSub(const Complex<T>& x, const Complex<T>& y) {
    real = x.real - y.real;
    imag = x.imag - y.imag;
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
    _roots.reserve(capacity);
    _roots.resize(2);
    _roots[0].init(0, 0);
    _roots[1].init(1, 0);
    _initCapacity(capacity);
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
    _expand(cs, pow2);
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
    for (int l = 1; l < pow2; l <<= 1) {
      for (int i = 0, l2 = l << 1; i < pow2; i += l2) {
        for (int j = 0, k = l; j < l; ++j, ++k) {
          Complex<T> c = cs[i + j + l] * _roots[k];
          cs[i + j + l].initSub(cs[i + j], c);
          cs[i + j] += c;
        }
      }
    }
  }
  inline void _expand(vector<Complex<T>>& cs, int pow2) {
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
      T baseAngle = PI / i;
      for (int j = i, k = 1; j < i << 1; j += 2, k += 2) {
        _roots[j] = _roots[j >> 1];
        _roots[j | 1].initPolar(1, baseAngle * k);
      }
    }
  }
  vector<int> _revs;
  vector<Complex<T>> _roots;
};
}  // namespace math
const int MAXN = 400 + 2;
const int MAXPOW2 = 1 << 10;
const double EPS = 1E-5;
using COMPLEX_T = double;
int n, m, r, c, nr, mc, pow2;
char board[MAXN][MAXN], pattern[MAXN][MAXN];
math::FFTUtils<COMPLEX_T> fft(MAXPOW2);
bool valid[MAXN][MAXN];
vector<vector<math::Complex<COMPLEX_T>>> boardCs, patternCs;
int main() {
  io::readInt(n);
  io::readInt(m);
  for (int i = 0; i < n; ++i) {
    io::readCharArray(board[i]);
  }
  io::readInt(r);
  io::readInt(c);
  for (int i = 0; i < r; ++i) {
    io::readCharArray(pattern[i]);
  }
  boardCs.reserve(MAXPOW2);
  boardCs.resize(n + r);
  for (int i = 0; i < n + r; ++i) {
    boardCs[i].reserve(MAXPOW2);
    boardCs[i].resize(m + c);
    for (int j = 0; j < m + c; ++j) {
      boardCs[i][j].initPolar(1, math::PI / 13 * (board[i % n][j % m] - 'a'));
    }
  }
  patternCs.reserve(MAXPOW2);
  patternCs.resize(r);
  int patternCnt = 0;
  for (int i = 0; i < r; ++i) {
    patternCs[r - 1 - i].reserve(MAXPOW2);
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
      io::writeChar(fabs(boardCs[i + r - 1][j + c - 1].real - patternCnt) < EPS
                        ? '1'
                        : '0');
    }
    io::writeChar('\n');
  }
}
