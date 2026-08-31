#include <bits/stdc++.h>
using namespace std;
void RD(int &x) { scanf("%d", &x); }
void RD(long long &x) { scanf("%I64d", &x); }
void RD(unsigned long long &x) { scanf("%I64u", &x); }
void RD(unsigned int &x) { scanf("%u", &x); }
void RD(double &x) { scanf("%lf", &x); }
void RD(int &x, int &y) { scanf("%d%d", &x, &y); }
void RD(long long &x, long long &y) { scanf("%I64d%I64d", &x, &y); }
void RD(unsigned int &x, unsigned int &y) { scanf("%u%u", &x, &y); }
void RD(double &x, double &y) { scanf("%lf%lf", &x, &y); }
void RD(int &x, int &y, int &z) { scanf("%d%d%d", &x, &y, &z); }
void RD(long long &x, long long &y, long long &z) {
  scanf("%I64d%I64d%I64d", &x, &y, &z);
}
void RD(unsigned int &x, unsigned int &y, unsigned int &z) {
  scanf("%u%u%u", &x, &y, &z);
}
void RD(double &x, double &y, double &z) { scanf("%lf%lf%lf", &x, &y, &z); }
void RD(char &x) { x = getchar(); }
void RD(char *s) { scanf("%s", s); }
void RD(string &s) { cin >> s; }
void PR(int x) { printf("%d\n", x); }
void PR(int x, int y) { printf("%d %d\n", x, y); }
void PR(long long x) { printf("%I64d\n", x); }
void PR(unsigned int x) { printf("%u\n", x); }
void PR(unsigned long long x) { printf("%I64u\n", x); }
void PR(double x) { printf("%.2lf\n", x); }
void PR(char x) { printf("%c\n", x); }
void PR(char *x) { printf("%s\n", x); }
void PR(string x) { cout << x << endl; }
const long long inf = ((long long)1) << 60;
const double dinf = 1e50;
const int INF = 1000000005;
const int N = 1005;
int pre[N], Next[N], n, m;
int d[N];
vector<int> V;
int flag = -1;
int DFS(int x) {
  if (!x) return 0;
  int t = DFS(Next[x]);
  if (x == m) flag = t;
  return t + 1;
}
int main() {
  RD(n);
  RD(m);
  int i, x;
  for (i = 1; i <= n; i++) {
    RD(x);
    if (x) {
      pre[i] = x;
      Next[x] = i;
      d[i]++;
    }
  }
  int K, M;
  for (i = 1; i <= n; i++)
    if (!d[i]) {
      flag = -1;
      int x = DFS(i);
      if (flag != -1) {
        M = flag + 1;
        K = x - M;
      } else
        V.push_back(x);
    }
  int f[N];
  memset(f, -1, sizeof(f));
  f[0] = 1;
  int s = V.size();
  for (i = 1; i <= s; i++) {
    int x = V[i - 1];
    int j;
    for (j = n; j >= 0; j--)
      if (f[j] != -1) {
        f[j + x] = 1;
      }
  }
  V.clear();
  for (i = 0; i < n + 1; i++)
    if (f[i] != -1) {
      V.push_back(i + K + 1);
    }
  sort(V.begin(), V.end());
  printf("%d\n", V[0]);
  for (i = 1; i < V.size(); i++)
    if (V[i] != V[i - 1]) PR(V[i]);
}
