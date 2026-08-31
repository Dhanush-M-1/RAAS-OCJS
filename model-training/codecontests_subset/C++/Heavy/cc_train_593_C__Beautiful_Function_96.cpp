#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(T x) {
  return x * x;
}
const int maxn = 200001;
int a[maxn], b[maxn];
int n, c[maxn];
char s[maxn];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d%d", &a[i], &b[i], &c[i]);
  }
  string fx = "0", fy = "0";
  for (int i = 0; i <= n - 1; i++) {
    int d = a[i + 1];
    sprintf(s, "(%d*((1-abs((t%+d)))+abs((abs((t%+d))-1))))", abs(d / 2), -i,
            -i);
    fx = "(" + fx + (d >= 0 ? "+" : "-") + s + ")";
    d = b[i + 1];
    sprintf(s, "(%d*((1-abs((t%+d)))+abs((abs((t%+d))-1))))", abs(d / 2), -i,
            -i);
    fy = "(" + fy + (d >= 0 ? "+" : "-") + s + ")";
  }
  cout << fx << endl;
  cout << fy << endl;
}
