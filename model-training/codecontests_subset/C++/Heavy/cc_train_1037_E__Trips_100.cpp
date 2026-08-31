#include <bits/stdc++.h>
using namespace std;
template <class T, class U>
bool cmax(T& a, const U& b) {
  return a < b ? a = b, 1 : 0;
}
template <class T, class U>
bool cmin(T& a, const U& b) {
  return b < a ? a = b, 1 : 0;
}
void _BG(const char* s) { cerr << s << endl; };
template <class T, class... TT>
void _BG(const char* s, T a, TT... b) {
  for (int c = 0; *s && (c || *s != ','); ++s) {
    cerr << *s;
    for (char x : "([{") c += *s == x;
    for (char x : ")]}") c -= *s == x;
  }
  cerr << " = " << a;
  if (sizeof...(b)) {
    cerr << ", ";
    ++s;
  }
  _BG(s, b...);
}
bool RD() { return 1; }
bool RD(char& a) { return scanf(" %c", &a) == 1; }
bool RD(char* a) { return scanf("%s", a) == 1; }
bool RD(double& a) { return scanf("%lf", &a) == 1; }
bool RD(int& a) { return scanf("%d", &a) == 1; }
bool RD(long long& a) { return scanf("%lld", &a) == 1; }
template <class T, class... TT>
bool RD(T& a, TT&... b) {
  return RD(a) && RD(b...);
}
void PT(const char& a) { putchar(a); }
void PT(char const* const& a) { fputs(a, stdout); }
void PT(const double& a) { printf("%.16f", a); }
void PT(const int& a) { printf("%d", a); }
void PT(const long long& a) { printf("%lld", a); }
template <char s = ' ', char e = '\n'>
void PL() {
  if (e) PT(e);
}
template <char s = ' ', char e = '\n', class T, class... TT>
void PL(const T& a, const TT&... b) {
  PT(a);
  if (sizeof...(b) && s) PT(s);
  PL<s, e>(b...);
}
const int N = 212345;
int n, m, k;
set<int> g[N];
pair<int, int> e[N];
bool die[N];
int ans, QAQ[N];
vector<int> rm;
void chk(int v) {
  if (((int)(g[v]).size()) < k && !die[v]) {
    rm.push_back(v);
    die[v] = 1;
    --ans;
  }
}
void del(int u, int v) {
  g[u].erase(v);
  g[v].erase(u);
  chk(u);
  chk(v);
}
int main() {
  RD(n, m, k);
  for (int i(0); i < (m); ++i) {
    int u, v;
    RD(u, v);
    --u, --v;
    e[i] = {u, v};
    g[u].insert(v);
    g[v].insert(u);
  }
  ans = n;
  for (int i(0); i < (n); ++i) chk(i);
  for (int i((m)-1); i >= (0); --i) {
    while (((int)(rm).size())) {
      int u = ((rm).back());
      (rm).pop_back();
      while (((int)(g[u]).size())) del(u, *begin(g[u]));
    }
    QAQ[i] = ans;
    del(e[i].first, e[i].second);
  }
  for (int i(0); i < (m); ++i) PL(QAQ[i]);
}
