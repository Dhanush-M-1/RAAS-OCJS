#include <bits/stdc++.h>
using namespace std;
const int inf = 1000000000;
const int mod = 1000000007;
const int KOK = 100000;
const int li = 100005;
const int LOG = 20;
int n, m, cev, x, a[li];
vector<int> v;
char c;
string s;
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  sort(a + 1, a + n + 1);
  for (int i = n; i >= 1; i--) {
    if (m % a[i] == 0) {
      printf("%d\n", m / a[i]);
      return 0;
    }
  }
  return 0;
}
