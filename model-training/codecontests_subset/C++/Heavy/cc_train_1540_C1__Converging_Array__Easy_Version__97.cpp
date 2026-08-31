#include <bits/stdc++.h>

using namespace std;

static struct FastInput {
  static constexpr int BUF_SIZE = 1 << 20;
  char buf[BUF_SIZE];
  size_t chars_read = 0;
  size_t buf_pos = 0;
  FILE *in = stdin;
  char cur = 0;
 
  inline char get_char() {
    if (buf_pos >= chars_read) {
      chars_read = fread(buf, 1, BUF_SIZE, in);
      buf_pos = 0;
      buf[0] = (chars_read == 0 ? -1 : buf[0]);
    }
    return cur = buf[buf_pos++];
  }
 
  inline void tie(int) {}
 
  inline explicit operator bool() {
    return cur != -1;
  }
 
  inline static bool is_blank(char c) {
    return c <= ' ';
  }
 
  inline bool skip_blanks() {
    while (is_blank(cur) && cur != -1) {
      get_char();
    }
    return cur != -1;
  }
 
  inline FastInput& operator>>(char& c) {
    skip_blanks();
    c = cur;
    return *this;
  }
  
  inline FastInput& operator>>(string& s) {
    if (skip_blanks()) {
      s.clear();
      do {
        s += cur;
      } while (!is_blank(get_char()));
    }
    return *this;
  }
 
  template <typename T>
  inline FastInput& read_integer(T& n) {
    // unsafe, doesn't check that characters are actually digits
    n = 0;
    if (skip_blanks()) {
      int sign = +1;
      if (cur == '-') {
        sign = -1;
        get_char();
      }
      do {
        n += n + (n << 3) + cur - '0';
      } while (!is_blank(get_char()));
      n *= sign;
    }
    return *this;
  }
 
  template <typename T>
  inline typename enable_if<is_integral<T>::value, FastInput&>::type operator>>(T& n) {
    return read_integer(n);
  }
  
  #if !defined(_WIN32) || defined(_WIN64)
  inline FastInput& operator>>(__int128& n) {
    return read_integer(n);
  }
  #endif
 
  template <typename T>
  inline typename enable_if<is_floating_point<T>::value, FastInput&>::type operator>>(T& n) {
    // not sure if really fast, for compatibility only
    n = 0;
    if (skip_blanks()) {
      string s;
      (*this) >> s;
      sscanf(s.c_str(), "%lf", &n);
    }
    return *this;
  }
} fast_input;
 
#define cin fast_input

static struct FastOutput {
  static constexpr int BUF_SIZE = 1 << 20;
  char buf[BUF_SIZE];
  size_t buf_pos = 0;
  static constexpr int TMP_SIZE = 1 << 20;
  char tmp[TMP_SIZE];
  FILE *out = stdout;
 
  inline void put_char(char c) {
    buf[buf_pos++] = c;
    if (buf_pos == BUF_SIZE) {
      fwrite(buf, 1, buf_pos, out);
      buf_pos = 0;
    }
  }
 
  ~FastOutput() {
    fwrite(buf, 1, buf_pos, out);
  }
 
  inline FastOutput& operator<<(char c) {
    put_char(c);
    return *this;
  }
 
  inline FastOutput& operator<<(const char* s) {
    while (*s) {
      put_char(*s++);
    }
    return *this;
  }
 
  inline FastOutput& operator<<(const string& s) {
    for (int i = 0; i < (int) s.size(); i++) {
      put_char(s[i]);
    }
    return *this;
  }
 
  template <typename T>
  inline char* integer_to_string(T n) {
    // beware of TMP_SIZE
    char* p = tmp + TMP_SIZE - 1;
    if (n == 0) {
      *--p = '0';
    } else {
      bool is_negative = false;
      if (n < 0) {
        is_negative = true;
        n = -n;
      }
      while (n > 0) {
        *--p = (char) ('0' + n % 10);
        n /= 10;
      }
      if (is_negative) {
        *--p = '-';
      }
    }
    return p;
  }
 
  template <typename T>
  inline typename enable_if<is_integral<T>::value, char*>::type stringify(T n) {
    return integer_to_string(n);
  }
 
  #if !defined(_WIN32) || defined(_WIN64)
  inline char* stringify(__int128 n) {
    return integer_to_string(n);
  }
  #endif
 
  template <typename T>
  inline typename enable_if<is_floating_point<T>::value, char*>::type stringify(T n) {
    sprintf(tmp, "%.17f", n);
    return tmp;
  }
 
  template <typename T>
  inline FastOutput& operator<<(const T& n) {
    auto p = stringify(n);
    for (; *p != 0; p++) {
      put_char(*p);
    }
    return *this;
  }
} fast_output;

// here puts define
 
typedef long long ll;
typedef long double ld;
typedef unsigned long long ull;

#define rint register int
#define rll register ll 
#define pii pair<int, int>
#define pll pair<ll, ll>
#define fors(i, a, b) for (ll i = (a); i <= (b); ++i)
#define _fors(i, a, b) for (ll i = (a); i >= (b); --i)
#define cyc(m) fors(rqtwqtqwt, 1, m)
#define mp(a, b) make_pair(a, b)
#define mt(a, b, c) make_tuple(a, b, c)
#define mem(A, b) memset(A, b, sizeof(A))
#define all(X) (X).begin(), (X).end()
#define y0 gawgfawgawg
#define y1 sdfyseyegeh
#define pb push_back
#define eb emplace_back
#define cout fast_output
#define endl '\n'
#define yes cout << "YES" << endl
#define no cout << "NO" << endl
#define int long long

int start_time;

const int _ = 105;
const int mod = 1e9 + 7;
const int inv2 = (mod + 1) / 2;

inline int add(int a, int b) {
  return (((a + b) % mod) + mod) % mod;
}

inline int mul(int a, int b) {
  return 1ll * a * b % mod;
}

int n, q;
int b[_], c[_];
int dp[_*_], s[_*_];
int sum[_];
int m;

void solve() {
  cin >> n;
  fors(i, 1, n) cin >> c[i];
  fors(i, 1, n - 1) cin >> b[i];
  fors(i, 2, n) {
    sum[i] = sum[i-1];
    fors(j, 1, i - 1) sum[i] += b[j];
  }

  // cout << '*' << m << endl;
  cin >> q;
  while (q--) {
    int xx;
    cin >> xx;
    dp[0] = 1;
    fors(i, 0, 10000) s[i] = 1;
    fors(id, 1, n) {
      fors(i, 0, 10000) {
        if (i <= c[id]) dp[i] = s[i];
        else dp[i] = add(s[i], -s[i-c[id]-1]);
      }
      fors(i, 0, min(10000ll, id * xx + sum[id] - 1)) dp[i] = 0;
      s[0] = dp[0];
      fors(i, 1, 10000) s[i] = add(s[i-1], dp[i]);
    }
    cout << s[10000] << endl;
  }
  return ;
}

signed main() {
  #ifdef Sakuyalove
    freopen("in.txt", "r", stdin);
    freopen("out.txt", "w", stdout);
  #endif 
  ios::sync_with_stdio(false);
  cin.tie(0);
  start_time = clock();
  int T = 1;
  // cin >> T;
  while (T--) {
    solve();
  }

  #ifdef Sakuyalove
    cout << "time = " << clock() - start_time << endl;
  #endif

  return 0;
}