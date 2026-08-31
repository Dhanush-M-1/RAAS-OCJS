#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
template <typename T>
void read(T &first) {
  first = 0;
  char ch = getchar();
  long long f = 1;
  while (!isdigit(ch)) {
    if (ch == '-') f *= -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    first = first * 10 + ch - 48;
    ch = getchar();
  }
  first *= f;
}
int z[2000];
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    int m;
    cin >> n >> m;
    memset(z, 0, sizeof(z));
    int a;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &a);
      z[a] = 1;
    }
    for (int i = 1; i <= m; i++) {
      scanf("%d", &a);
      if (z[a] == 1) z[a] = 2;
    }
    int judge = 0;
    for (int i = 0; i < 1200; i++) {
      if (z[i] > 1) {
        judge = i;
        break;
      }
    }
    if (judge == 0)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      printf("1 %d\n", judge);
    }
  }
  return 0;
}
