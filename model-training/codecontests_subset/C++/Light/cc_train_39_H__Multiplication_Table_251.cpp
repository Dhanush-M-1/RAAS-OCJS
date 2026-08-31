#include <bits/stdc++.h>
using namespace std;
vector<int> t;
vector<int> tosystem(int x, int sys) {
  t.clear();
  while (x) {
    t.push_back(x % sys);
    x /= sys;
  }
  return t;
}
void out(vector<int> x) {
  reverse(x.begin(), x.end());
  for (int i = 0; i < x.size(); i++) {
    printf("%d", x[i]);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n - 1; i++) {
    for (int j = 1; j <= n - 1; j++) {
      if (j != 1) printf(" ");
      out(tosystem(i * j, n));
    }
    printf("\n");
  }
}
