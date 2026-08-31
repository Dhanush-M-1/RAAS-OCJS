#include <bits/stdc++.h>
using namespace std;
const int INF = 2e9;
const int mod = 1e9 + 7;
const long long int LONGINF = 4e9;
const double eps = 1e-9;
void solve(int n) {
  map<int, int> m1, m2;
  int i, a;
  for (i = 0; i < (n); i++) {
    scanf("%d", &a);
    m1[a]++;
  }
  for (i = 0; i < (n - 1); i++) {
    scanf("%d", &a);
    m2[a]++;
    m1[a]--;
    if (m1[a] == 0) {
      m1.erase(a);
    }
  }
  for (i = 0; i < (n - 2); i++) {
    scanf("%d", &a);
    m2[a]--;
    if (m2[a] == 0) m2.erase(a);
  }
  printf("%d\n%d", m1.begin()->first, m2.begin()->first);
}
int main() {
#pragma comment(linker, "/STACK:268435456")
  int n;
  long long int a;
  char c[200200];
  string s;
  while (scanf("%d", &n) == 1) solve(n);
  return 0;
}
