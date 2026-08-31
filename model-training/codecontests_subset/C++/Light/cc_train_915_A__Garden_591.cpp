#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  priority_queue<int> q;
  int val;
  while (n--) cin >> val, q.push(val);
  while (!q.empty())
    if (k % q.top())
      q.pop();
    else
      return !printf("%d", k / q.top());
}
