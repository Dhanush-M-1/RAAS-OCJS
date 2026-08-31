#include <bits/stdc++.h>
using namespace std;
static struct IO {
  char tmp[1 << 10];
  char cur;
  inline char nextChar() { return cur = getc(stdin); }
  inline char peekChar() { return cur; }
  inline operator bool() { return 0 != peekChar(); }
  inline static bool isBlank(char c) { return (c < '-' && c); }
  inline bool skipBlanks() {
    while (isBlank(nextChar()))
      ;
    return peekChar() != 0;
  }
  inline IO& operator>>(char& c) {
    c = nextChar();
    return *this;
  }
  inline IO& operator>>(char* buf) {
    if (skipBlanks()) {
      if (peekChar()) {
        *(buf++) = peekChar();
        while (!isBlank(nextChar())) *(buf++) = peekChar();
      }
      *(buf++) = 0;
    }
    return *this;
  }
  inline IO& operator>>(string& s) {
    if (skipBlanks()) {
      s.clear();
      s += peekChar();
      while (!isBlank(nextChar())) s += peekChar();
    }
    return *this;
  }
  inline IO& operator>>(double& d) {
    if ((*this) >> tmp) sscanf(tmp, "%lf", &d);
    return *this;
  }
  inline IO& operator>>(int& n) {
    if (skipBlanks()) {
      int sign = +1;
      if (peekChar() == '-') {
        sign = -1;
        n = nextChar() - '0';
      } else
        n = peekChar() - '0';
      while (!isBlank(nextChar())) {
        n += n + (n << 3) + peekChar() - 48;
      }
      n *= sign;
    }
    return *this;
  }
  inline IO& operator>>(unsigned int& n) {
    if (skipBlanks()) {
      int sign = +1;
      if (peekChar() == '-') {
        sign = -1;
        n = nextChar() - '0';
      } else
        n = peekChar() - '0';
      while (!isBlank(nextChar())) {
        n += n + (n << 3) + peekChar() - 48;
      }
      n *= sign;
    }
    return *this;
  }
  inline IO& operator>>(long long& n) {
    if (skipBlanks()) {
      int sign = +1;
      if (peekChar() == '-') {
        sign = -1;
        n = nextChar() - '0';
      } else
        n = peekChar() - '0';
      while (!isBlank(nextChar())) {
        n += n + (n << 3) + peekChar() - 48;
      }
      n *= sign;
    }
    return *this;
  }
  inline IO& operator>>(unsigned long long& n) {
    if (skipBlanks()) {
      int sign = +1;
      if (peekChar() == '-') {
        sign = -1;
        n = nextChar() - '0';
      } else
        n = peekChar() - '0';
      while (!isBlank(nextChar())) {
        n += n + (n << 3) + peekChar() - 48;
      }
      n *= sign;
    }
    return *this;
  }
  inline void putChar(char c) { putc(c, stdout); }
  inline IO& operator<<(char c) {
    putChar(c);
    return *this;
  }
  inline IO& operator<<(const char* s) {
    while (*s) putChar(*s++);
    return *this;
  }
  inline IO& operator<<(const string& s) {
    for (int i = 0; i < (int)s.size(); ++i) putChar(s[i]);
    return *this;
  }
  char* toString(double d) {
    sprintf(tmp, "%lf%c", d, '\0');
    return tmp;
  }
  inline IO& operator<<(double d) { return (*this) << toString(d); }
  inline char* toString(int n) {
    char* p = (tmp + 30);
    if (n) {
      bool isNeg = 0;
      if (n < 0) isNeg = 1, n = -n;
      while (n) *--p = (n % 10) + '0', n /= 10;
      if (isNeg) *--p = '-';
    } else
      *--p = '0';
    return p;
  }
  inline IO& operator<<(int n) { return (*this) << toString(n); }
  inline char* toString(long long n) {
    char* p = (tmp + 30);
    if (n) {
      bool isNeg = 0;
      if (n < 0) isNeg = 1, n = -n;
      while (n) *--p = (n % 10) + '0', n /= 10;
      if (isNeg) *--p = '-';
    } else
      *--p = '0';
    return p;
  }
  inline IO& operator<<(long long n) { return (*this) << toString(n); }
  inline char* toString(unsigned long long n) {
    char* p = (tmp + 30);
    if (n) {
      while (n) *--p = (n % 10) + '0', n /= 10;
    } else
      *--p = '0';
    return p;
  }
  inline IO& operator<<(unsigned long long n) { return (*this) << toString(n); }
} __io__;
class TimeTracker {
  clock_t start, end;

 public:
  TimeTracker() { start = clock(); }
  ~TimeTracker() {
    end = clock();
    fprintf(stderr, "%.3lf s\n", (double)(end - start) / CLOCKS_PER_SEC);
  }
};
int main() {
  int button, bulb, i, j;
  __io__ >> button >> bulb;
  vector<int> v(bulb + 1, 0);
  v[0] = 101;
  for (i = 1; i <= button; i++)
    for (__io__ >> j; j > 0; j--) {
      int tmp;
      __io__ >> tmp;
      v[tmp] = 1;
    }
  if (*min_element(v.begin(), v.end()) < 1)
    __io__ << "NO\n";
  else
    __io__ << "YES\n";
}
