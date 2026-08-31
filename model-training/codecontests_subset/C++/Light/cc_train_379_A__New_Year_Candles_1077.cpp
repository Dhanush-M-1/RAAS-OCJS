#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int a, b;
  cin >> a >> b;
  int cnt = 0;
  int dead = 0;
  while (a) {
    cnt += a;
    dead += a;
    a = dead / b;
    dead = dead % b;
  }
  cout << cnt << '\n';
  return 0;
}
