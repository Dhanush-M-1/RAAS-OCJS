#include <bits/stdc++.h>
using namespace std;
class Scanner {
 private:
  static const long long BUFFER_SIZE = 10000;
  char buff[BUFFER_SIZE];
  long long buffPos, buffLim;

 public:
  Scanner() {
    buffLim = fread(buff, 1, BUFFER_SIZE, stdin);
    buffPos = 0;
  }

 private:
  inline void flushBuff() {
    buffLim = fread(buff, 1, BUFFER_SIZE, stdin);
    if (buffLim == 0) {
      buff[buffLim++] = '\n';
    }
    buffPos = 0;
  }
  inline bool isWS(char t) { return t == ' ' || t == '\n'; }
  inline bool isDig(char t) { return t >= '0' && t <= '9'; }
  void nextPos() {
    buffPos++;
    if (buffPos == buffLim) {
      flushBuff();
    }
  }

 public:
  inline char getchar() {
    char ch = buff[buffPos];
    nextPos();
    return ch;
  }
  inline void next(char* s) {
    while (isWS(buff[buffPos])) {
      nextPos();
    }
    while (!isWS(buff[buffPos])) {
      *s = buff[buffPos];
      s++;
      nextPos();
    }
    *s = '\0';
  }
  inline void nextLine(char* s) {
    while (buff[buffPos] != '\n') {
      nextPos();
    }
    if (buff[buffPos] == '\n') {
      nextPos();
    }
    while (buff[buffPos] != '\n') {
      *s = buff[buffPos];
      s++;
      buffPos++;
    }
    *s = '\0';
  }
  inline long long nextInt() {
    while (!isDig(buff[buffPos])) {
      nextPos();
    }
    long long sign = (buff[buffPos] == '-') ? nextPos(), -1 : 1;
    long long res = 0;
    while (isDig(buff[buffPos])) {
      res = res * 10 + buff[buffPos] - '0';
      nextPos();
    }
    return res * sign;
  }
  inline double nextDouble() {
    while (isWS(buff[buffPos])) {
      nextPos();
    }
    long long sign = (buff[buffPos] == '-') ? nextPos(), -1 : 1;
    double res = 0;
    while (isDig(buff[buffPos])) {
      res = res * 10 + buff[buffPos] - '0';
      nextPos();
    }
    if (buff[buffPos] == '.') {
      nextPos();
      double ep = 1;
      while (isDig(buff[buffPos])) {
        ep *= 0.1;
        res += ep * (buff[buffPos] - '0');
        nextPos();
      }
    }
    return sign * res;
  }
  inline char nextChar() {
    while (isWS(buff[buffPos])) nextPos();
    char res = buff[buffPos];
    nextPos();
    return res;
  }
};
Scanner sc;
template <class T>
inline bool checkMin(T& a, T b) {
  return (a > b ? a = b, 1 : 0);
}
template <class T>
inline bool checkMax(T& a, T b) {
  return (a < b ? a = b, 1 : 0);
}
void ALERT(bool judgememt, const char* phrase) {
  if (judgememt) {
    puts(phrase);
    throw "ALERT";
  }
}
bool alert(bool judgememt, const char* phrase) {
  if (judgememt) puts(phrase);
  return judgememt;
}
void preInit();
void init();
void solve();
int32_t main() {
  preInit();
  init();
  solve();
  return 0;
}
const long long N = 100005;
const long long INF = 0x3f3f3f3f3f3f3f3f;
long long b[N], t[N];
vector<long long> e[N];
long long n;
void preInit() {
  n = sc.nextInt();
  for (long long i = 1; i <= n; i++) {
    b[i] = sc.nextInt();
  }
  for (long long i = 1; i <= n; i++) {
    b[i] -= sc.nextInt();
  }
  for (long long i = 2; i <= n; i++) {
    e[sc.nextInt()].push_back(i);
    t[i] = sc.nextInt();
  }
}
void init() {}
void dfs(long long u, long long f) {
  for (long long v : e[u])
    if (v != f) {
      dfs(v, u);
      if (b[v] > 0) {
        b[u] += b[v];
      } else {
        if (b[v] < (-INF) / t[v]) {
          b[u] = -INF;
        } else {
          b[u] += b[v] * t[v];
        }
        checkMax(b[u], -INF);
      }
    };
  ;
}
void solve() {
  dfs(1, 0);
  puts(b[1] >= 0 ? "YES" : "NO");
}
