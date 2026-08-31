#include <bits/stdc++.h>
using namespace std;
struct InputReader {
  char buf[1048576];
  int p;
  inline InputReader() { p = 1048576; }
  inline void Flush() {
    p = 0;
    fread(buf, 1, 1048576, stdin);
  }
  inline char C() {
    if (p >= 1048576) Flush();
    return buf[p++];
  }
  inline char Readnum() {
    char ch = C();
    while (!isdigit(ch) && ch != '-') ch = C();
    return ch;
  }
  inline void Readalpha(char &c) {
    c = C();
    while (!isalpha(c)) c = C();
  }
  int operator()() {
    int ans = 0, fu = 1;
    char ch = Readnum();
    if (ch == '-') fu = -1, ch = C();
    while (ch >= '0' && ch <= '9') {
      ans = ans * 10 + ch - '0';
      ch = C();
    }
    return ans * fu;
  }
  long long Readll() {
    long long ans = 0LL, fu = 1LL;
    char ch = Readnum();
    if (ch == '-') fu = -1LL, ch = C();
    while (ch >= '0' && ch <= '9') {
      ans = ans * 10LL + ch - '0';
      ch = C();
    }
    return ans * fu;
  }
  inline void Readstring(string &x) {
    x.clear();
    char ch = C();
    while (!isdigit(ch) && !isalpha(ch) && ch != '#' && ch != '.') ch = C();
    while (isdigit(ch) || isalpha(ch) || ch == '#' || ch == '.') {
      x += ch;
      ch = C();
    }
  }
  inline void Readchstring(char s[]) {
    int len = 0;
    char ch = C();
    while (!isdigit(ch) && !isalpha(ch)) ch = C();
    while (isdigit(ch) || isalpha(ch)) {
      s[len++] = ch;
      ch = C();
    }
    s[len] = '\0';
  }
  inline void Specialread(char &c) {
    c = C();
    while (!isdigit(c) && !isalpha(c) && c != '#' && c != '.' && c != '=' &&
           c != 'B')
      c = C();
  }
} In;
inline void Read(int &x) { x = In(); }
inline void Read(int &x, int &y) {
  x = In();
  y = In();
}
inline void Read(int &x1, int &x2, int &x3) {
  x1 = In();
  x2 = In();
  x3 = In();
}
inline void Read(int &x1, int &x2, int &x3, int &x4) {
  x1 = In();
  x2 = In();
  x3 = In();
  x4 = In();
}
inline void Read(long long &x) { x = In.Readll(); }
inline void Read(long long &x, long long &y) {
  x = In.Readll();
  y = In.Readll();
}
inline void Read(long long &x1, long long &x2, long long &x3) {
  x1 = In.Readll();
  x2 = In.Readll();
  x3 = In.Readll();
}
inline void Read(long long &x1, long long &x2, long long &x3, long long &x4) {
  x1 = In.Readll();
  x2 = In.Readll();
  x3 = In.Readll();
  x4 = In.Readll();
}
template <typename T>
void Read(T a[], int st, int ed) {
  for (int(i) = (st); (i) <= (ed); ++(i)) Read(a[i]);
}
inline void FILEIO() {}
inline void FILEIO(string pname) {
  freopen((pname + ".in").c_str(), "r", stdin);
  freopen((pname + ".out").c_str(), "w", stdout);
}
inline void FILEIO_OICONTEST(string pname) {
  freopen((pname + ".in").c_str(), "r", stdin);
  freopen((pname + ".out").c_str(), "w", stdout);
}
void Printtime() {}
void END() {
  Printtime();
  exit(0);
}
template <typename T>
void END(T mes) {
  cout << mes << endl;
  END();
}
template <typename T>
void Print(T a[], int s, int t, char sp = ' ', char ed = '\n') {
  if (s > t) return;
  for (int i = s; i < t; i++) cout << a[i] << sp;
  cout << a[t] << ed;
  cout.flush();
}
template <typename T>
void Print(T a, int s = 0, int t = -1, char sp = ' ', char ed = '\n') {
  if (t == -1) t = a.size() - 1;
  for (int i = s; i <= t; i++) cout << a[i] << sp;
  cout << ed;
  cout.flush();
}
vector<int> Range(int l, int r) {
  vector<int> ret{};
  for (int(i) = (l); (i) <= (r); ++(i)) ret.push_back(i);
  return ret;
}
int n;
vector<pair<pair<int, long long>, int>> a[524288];
vector<long long> ca[524288][4];
long long mem[524288][16];
long long Dfs(int round, int mod10) {
  if (round == n + 1) return 0;
  if (~mem[round][mod10]) return mem[round][mod10];
  long long ans0 = Dfs(round + 1, mod10);
  long long ans1 = 0;
  if (ca[round][1].size() >= 3) {
    ans1 = Dfs(round + 1, (mod10 + 3) % 10) + ca[round][1][0] +
           ca[round][1][1] + ca[round][1][2];
    if (mod10 == 9 or mod10 == 8 or mod10 == 7) ans1 += ca[round][1][0];
  }
  long long ans2 = 0;
  if (ca[round][1].size() and ca[round][2].size()) {
    ans2 = Dfs(round + 1, (mod10 + 2) % 10) + ca[round][1][0] + ca[round][2][0];
    if (mod10 == 9 or mod10 == 8) ans2 += max(ca[round][1][0], ca[round][2][0]);
  }
  long long ans3 = 0;
  if (ca[round][3].size()) {
    ans3 = Dfs(round + 1, (mod10 + 1) % 10) + ca[round][3][0];
    if (mod10 == 9) ans3 += ca[round][3][0];
  }
  long long ans4 = 0;
  if (ca[round][1].size()) {
    ans4 = Dfs(round + 1, (mod10 + 1) % 10) + ca[round][1][0];
    if (mod10 == 9) ans4 += ca[round][1][0];
  }
  long long ans5 = 0;
  if (ca[round][1].size() >= 2) {
    ans5 = Dfs(round + 1, (mod10 + 2) % 10) + ca[round][1][0] + ca[round][1][1];
    if (mod10 == 9 or mod10 == 8) ans5 += ca[round][1][0];
  }
  long long ans6 = 0;
  if (ca[round][2].size()) {
    ans6 = Dfs(round + 1, (mod10 + 1) % 10) + ca[round][2][0];
    if (mod10 == 9) ans6 += ca[round][2][0];
  }
  long long ans = max({ans0, ans1, ans2, ans3, ans4, ans5, ans6});
  return mem[round][mod10] = ans;
}
int main() {
  FILEIO();
  memset(mem, -1, sizeof(mem));
  Read(n);
  int id = 0;
  for (int(i) = 1; (i) <= (n); ++(i)) {
    int k;
    Read(k);
    ;
    for (int(j) = 1; (j) <= (k); ++(j)) {
      int c;
      Read(c);
      ;
      long long d;
      Read(d);
      ;
      ++id;
      a[i].push_back({{c, d}, id});
      ca[i][c].push_back(d);
    }
    sort(ca[i][1].begin(), ca[i][1].end(),
         [](long long x, long long y) { return x > y; });
    sort(ca[i][2].begin(), ca[i][2].end(),
         [](long long x, long long y) { return x > y; });
    sort(ca[i][3].begin(), ca[i][3].end(),
         [](long long x, long long y) { return x > y; });
  }
  long long ans = Dfs(1, 0);
  cout << ans << endl;
  END();
}
