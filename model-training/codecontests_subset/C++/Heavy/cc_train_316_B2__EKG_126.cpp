#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:512000000")
using namespace std;
template <class T>
inline T sqr(T x) {
  return x * x;
}
template <class T>
inline string tostr(const T& x) {
  stringstream ss;
  ss << x;
  return ss.str();
}
const double EPS = 1e-6;
const int INF = 1000 * 1000 * 1000;
const char CINF = 102;
const long long LINF = INF * 1ll * INF;
const double PI = 3.1415926535897932384626433832795;
long long gcd(long long a, long long b) { return a ? gcd(b % a, a) : b; }
unsigned int gcd(unsigned int a, unsigned int b) {
  return a ? gcd(b % a, a) : b;
}
int src[1100];
int head[1100];
int dist[1100];
int len[1100];
int n;
bool dp[1100];
void doit(int a) {
  if (len[a]) return;
  if (src[a] == -1) {
    head[a] = a;
    len[a] = 1;
    dist[a] = 1;
    return;
  }
  doit(src[a]);
  head[a] = head[src[a]];
  dist[a] = 1 + dist[src[a]];
  len[head[a]] = max(len[head[a]], dist[a]);
}
int main() {
  int x;
  cin >> n >> x;
  --x;
  for (int i = 0; i < (n); ++i) {
    cin >> src[i];
    --src[i];
  }
  for (int i = 0; i < (n); ++i) {
    doit(i);
  }
  int xpos = dist[x];
  vector<int> segs;
  for (int i = 0; i < (n); ++i) {
    if (src[i] == -1 && i != head[x]) {
      segs.push_back(len[i]);
    }
  }
  dp[0] = true;
  for (int i = 0; i < (((int)(segs).size())); ++i) {
    int s = segs[i];
    for (int j = n - s; j >= 0; --j) {
      dp[j + s] |= dp[j];
    }
  }
  for (int i = 0; i < (n); ++i) {
    if (dp[i]) cout << i + xpos << '\n';
  }
  return 0;
}
