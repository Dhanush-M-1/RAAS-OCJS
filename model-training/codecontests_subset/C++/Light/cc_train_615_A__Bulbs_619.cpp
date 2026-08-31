#include <bits/stdc++.h>
using namespace std;
const int oo = 1 << 29, N = 1e5 + 10;
const long double PI = acos(0.0) * 2;
int btns, lights, x, tmp;
bool vis[N];
int main() {
  cin >> btns >> lights;
  for (int i = 0; i < btns; ++i) {
    cin >> x;
    for (int j = 0; j < x; ++j) {
      cin >> tmp;
      vis[tmp - 1] = 1;
    }
  }
  for (int i = 0; i < lights; ++i)
    if (!vis[i]) {
      puts("NO");
      return 0;
    }
  puts("YES");
  return 0;
}
