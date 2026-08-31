#include <bits/stdc++.h>
using namespace std;
template <typename T>
T BigMod(T b, T p, T m) {
  if (p == 0) return 1;
  if (p % 2 == 0) {
    T s = BigMod(b, p / 2, m);
    return ((s % m) * (s % m)) % m;
  }
  return ((b % m) * (BigMod(b, p - 1, m) % m)) % m;
}
template <typename T>
T ModInv(T b, T m) {
  return BigMod(b, m - 2, m);
}
template <typename T>
T in() {
  char ch;
  T n = 0;
  bool ng = false;
  while (1) {
    ch = getchar();
    if (ch == '-') {
      ng = true;
      ch = getchar();
      break;
    }
    if (ch >= '0' && ch <= '9') break;
  }
  while (1) {
    n = n * 10 + (ch - '0');
    ch = getchar();
    if (ch < '0' || ch > '9') break;
  }
  return (ng ? -n : n);
}
template <typename T>
T POW(T B, T printf) {
  if (printf == 0) return 1;
  if (printf & 1)
    return B * POW(B, printf - 1);
  else
    return (POW(B, printf / 2) * POW(B, printf / 2));
}
template <typename T>
T Bigmod(T b, T p, T m) {
  if (p == 0)
    return 1;
  else if (!(p & 1))
    return (Bigmod(b, p / 2, m) * Bigmod(b, p / 2, m)) % m;
  else
    return ((b % m) * Bigmod(b, p - 1, m)) % m;
}
template <typename T>
T Dis(T x1, T y1, T x2, T y2) {
  return sqrt((x1 - x2 * x1 - x2) + (y1 - y2 * y1 - y2));
}
template <typename T>
T Angle(T x1, T y1, T x2, T y2) {
  return atan(double(y1 - y2) / double(x1 - x2));
}
template <typename T>
T DIFF(T a, T b) {
  T d = a - b;
  if (d < 0)
    return -d;
  else
    return d;
}
template <typename T>
T ABS(T a) {
  if (a < 0)
    return -a;
  else
    return a;
}
template <typename T>
T gcd(T a, T b) {
  if (a < 0) return gcd(-a, b);
  if (b < 0) return gcd(a, -b);
  return (b == 0) ? a : gcd(b, a % b);
}
template <typename T>
T lcm(T a, T b) {
  if (a < 0) return lcm(-a, b);
  if (b < 0) return lcm(a, -b);
  return a * (b / gcd(a, b));
}
template <typename T>
T euclide(T a, T b, T &x, T &y) {
  if (a < 0) {
    T d = euclide(-a, b, x, y);
    x = -x;
    return d;
  }
  if (b < 0) {
    T d = euclide(a, -b, x, y);
    y = -y;
    return d;
  }
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  } else {
    T d = euclide(b, a % b, x, y);
    T t = x;
    x = y;
    y = t - (a / b) * y;
    return d;
  }
}
template <typename T>
void ia(T a[], int n) {
  for (int i = 0; i < n; i++) cin >> a[i];
}
template <typename T>
void pa(T a[], int n) {
  for (int i = 0; i < n - 1; i++) cout << a[i] << " ";
  cout << a[n - 1] << endl;
}
template <typename T>
long long int isLeft(T a, T b, T c) {
  return (a.x - b.x) * (b.y - c.y) - (b.x - c.x) * (a.y - b.y);
}
int Set(int N, int pos) { return N = N | (1 << pos); }
int Reset(int N, int pos) { return N = N & ~(1 << pos); }
bool Check(int N, int pos) { return (bool)(N & (1 << pos)); }
template <class T, class first>
inline T togglebit(T a, first i) {
  T t = 1;
  return (a ^ (t << i));
}
int toInt(string s) {
  int sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
int toLlint(string s) {
  long long int sm;
  stringstream ss(s);
  ss >> sm;
  return sm;
}
int cdigittoint(char ch) { return ch - '0'; }
bool isVowel(char ch) {
  ch = toupper(ch);
  if (ch == 'A' || ch == 'U' || ch == 'I' || ch == 'O' || ch == 'E')
    return true;
  return false;
}
bool isConst(char ch) {
  if (isalpha(ch) && !isVowel(ch)) return true;
  return false;
}
double DEG(double x) { return (180.0 * x) / (2.0 * acos(0.0)); }
double RAD(double x) { return (x * (double)2.0 * acos(0.0)) / (180.0); }
int DP[23][7];
int a[23];
int PT[23][7][2];
int dp(int p, int c) {
  if (p == 0) return c == 0;
  if (DP[p][c] != -1) return DP[p][c];
  int &res = DP[p][c];
  res = 0;
  for (int i = 0; i <= 6; i++) {
    for (int j = 0; j <= 6; j++) {
      int four = i, seven = j;
      if (i + j > 6) continue;
      int dg = (four * 4 + seven * 7 + c) % 10;
      int cr = (four * 4 + seven * 7 + c) / 10;
      if (dg == a[p]) {
        int tmp = dp(p - 1, cr);
        if (tmp) {
          PT[p][c][0] = four;
          PT[p][c][1] = seven;
        }
        res |= tmp;
      }
    }
  }
  return res;
}
long long int ans[8][23];
void Print(int l) {
  int p = l, c = 0;
  memset(ans, 0, sizeof ans);
  while (p) {
    int four = PT[p][c][0], seven = PT[p][c][1];
    for (int i = 1; i <= four; i++) ans[i][p] = 4;
    for (int i = 1; i <= seven; i++) ans[i + four][p] = 7;
    p = p - 1;
    c = (four * 4 + seven * 7 + c) / 10;
  }
  for (int i = 1; i <= 6; i++) {
    int j = 1;
    while (ans[i][j] == 0 && j <= l) j++;
    if (j == l + 1) printf("0");
    while (j <= l) printf("%d", ans[i][j]), j++;
    printf(" ");
  }
  printf("\n");
  ;
}
int main() {
  int(t);
  scanf("%d", &t);
  while (t--) {
    long long int x;
    scanf("%lld", &x);
    int l = 0;
    while (x) {
      a[++l] = x % 10;
      x /= 10;
    }
    reverse(a + 1, a + 1 + l);
    memset(DP, -1, sizeof DP);
    int ans = dp(l, 0);
    if (ans)
      Print(l);
    else
      puts("-1");
  }
  return 0;
}
