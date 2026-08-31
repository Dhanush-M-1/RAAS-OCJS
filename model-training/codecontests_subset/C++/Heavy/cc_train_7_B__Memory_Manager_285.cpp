#include <bits/stdc++.h>
using namespace std;
template <class T>
inline T gcd(T a, T b) {
  if (a < 0) return gcd(-a, b);
  if (b < 0) return gcd(a, -b);
  return (b == 0) ? a : gcd(b, a % b);
}
template <class T>
inline T lcm(T a, T b) {
  if (a < 0) return lcm(-a, b);
  if (b < 0) return lcm(a, -b);
  return a * (b / gcd(a, b));
}
template <class T>
T power(T N, T P) {
  return (P == 0) ? 1 : N * power(N, P - 1);
}
long long toInt64(string s) {
  long long r = 0;
  istringstream sin(s);
  sin >> r;
  return r;
}
double LOG(long long N, long long B) { return (log10l(N)) / (log10l(B)); }
string itoa(long long a) {
  if (a == 0) return "0";
  string ret;
  for (long long i = a; i > 0; i = i / 10) ret.push_back((i % 10) + 48);
  reverse(ret.begin(), ret.end());
  return ret;
}
vector<string> token(string a, string b) {
  const char *q = a.c_str();
  while (count(b.begin(), b.end(), *q)) q++;
  vector<string> oot;
  while (*q) {
    const char *e = q;
    while (*e && !count(b.begin(), b.end(), *e)) e++;
    oot.push_back(string(q, e));
    q = e;
    while (count(b.begin(), b.end(), *q)) q++;
  }
  return oot;
}
int Set(int N, int pos) { return N = N | (1 << pos); }
int reset(int N, int pos) { return N = N & ~(1 << pos); }
int check(int N, int pos) { return (N & (1 << pos)); }
int toggle(int N, int pos) {
  if (check(N, pos)) return N = reset(N, pos);
  return N = Set(N, pos);
}
void pbit(int N) {
  printf("(");
  for (int i = 10; i >= 0; i--) {
    bool x = check(N, i);
    cout << x;
  }
  puts(")");
}
int fx[] = {0, 0, 1, -1, 1, -1, 1, -1};
int fy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
void Clear(int n, long long *ram) {
  for (int i = 1; i <= (int)n; i++) ram[i] = 1e15;
}
int main() {
  long long n, m;
  while (cin >> n >> m) {
    long long ram[1000];
    Clear(m, ram);
    long long id = 0;
    for (int loop = 1; loop <= (int)n; loop++) {
      string s;
      cin >> s;
      if (s[0] == 'a') {
        long long x, p = 1e15;
        cin >> x;
        for (int i = 1; i <= m; i++) {
          if (ram[i] == 1e15) {
            int c = 0;
            for (int j = i; ram[j] == 1e15 and j <= m; j++) c++;
            if (c >= x) {
              p = i;
              break;
            }
          }
        }
        if (p == 1e15)
          puts("NULL");
        else {
          id++;
          for (int i = p; i <= p + x - 1; i++) ram[i] = id;
          cout << id << endl;
        }
      }
      if (s[0] == 'e') {
        long long x, flag = 0;
        cin >> x;
        for (int i = 1; i <= m; i++)
          if (ram[i] == x) {
            ram[i] = 1e15;
            flag = 1;
          }
        if (flag == 0) puts("ILLEGAL_ERASE_ARGUMENT");
      }
      if (s[0] == 'd') {
        long long temp[1000], c = 1;
        Clear(m, temp);
        for (int i = 1; i <= m; i++)
          if (ram[i] != 1e15) temp[c++] = ram[i];
        for (int i = 1; i <= m; i++) ram[i] = temp[i];
      }
    }
  }
}
