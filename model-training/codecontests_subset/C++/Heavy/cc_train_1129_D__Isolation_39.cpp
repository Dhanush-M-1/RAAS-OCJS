#include <bits/stdc++.h>
using namespace std;
template <typename T>
void debug_out(T t) {
  cerr << t;
}
template <typename A, typename B>
void debug_out(pair<A, B> u) {
  cerr << "(" << u.first << " " << u.second << ")";
}
template <typename T>
void debug_out(vector<T> t) {
  int sz = t.size();
  for (int i = 0; i < sz; i++) {
    debug_out(t[i]);
    if (i != sz - 1) cerr << ", ";
  }
}
template <typename T>
void debug_out(vector<vector<T>> t) {
  int sz = t.size();
  for (int i = 0; i < sz; i++) {
    debug_out(t[i]);
    if (i != sz - 1) cerr << endl;
  }
}
const int md = 998244353;
inline void add(int &a, int b) {
  a += b;
  if (a >= md) a -= md;
}
inline void sub(int &a, int b) {
  a -= b;
  if (a < 0) a += md;
}
int n, k;
int main() {
  scanf("%d%d", &n, &k);
  vector<int> a(n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    a[i]--;
  }
  vector<int> to(n), foo(n, n);
  for (int i = n - 1; i > -1; i--) {
    to[i] = foo[a[i]];
    foo[a[i]] = i;
  }
  vector<int> dp(n + 1);
  int b = sqrt(n + 1);
  int cnt = (n + b) / b;
  vector<int> shift(cnt);
  vector<unordered_map<int, int>> cur(cnt);
  cur.back()[0] = 1;
  dp[n] = 1;
  vector<int> over(n + 1);
  int total = 1;
  auto modify = [&](int l, int r, int c) {
    while (l <= r && l % b) {
      over[l] += c;
      if (over[l] + shift[l / b] == k + 1 && c > 0) sub(total, dp[l]);
      if (over[l] + shift[l / b] == k && c < 0) add(total, dp[l]);
      add(cur[l / b][over[l]], dp[l]);
      sub(cur[l / b][over[l] - c], dp[l]);
      if (!cur[l / b][over[l] - c]) cur[l / b].erase(over[l] - c);
      l++;
    }
    while (r >= l && (r + 1) % b) {
      over[r] += c;
      if (over[r] + shift[r / b] == k + 1 && c > 0) sub(total, dp[r]);
      if (over[r] + shift[r / b] == k && c < 0) add(total, dp[r]);
      add(cur[r / b][over[r]], dp[r]);
      sub(cur[r / b][over[r] - c], dp[r]);
      if (!cur[r / b][over[r] - c]) cur[r / b].erase(over[r] - c);
      r--;
    }
    if (r < l) return;
    for (int block = l; block <= r; block += b) {
      int t = block / b;
      shift[t] += c;
      if (c > 0 && cur[t].count(k + 1 - shift[t]))
        sub(total, cur[t][k + 1 - shift[t]]);
      if (c < 0 && cur[t].count(k - shift[t])) add(total, cur[t][k - shift[t]]);
    }
  };
  for (int i = n - 1; i > -1; i--) {
    modify(i + 1, to[i], 1);
    if (to[i] < n) modify(to[i] + 1, to[to[i]], -1);
    dp[i] = total;
    add(total, dp[i]);
    add(cur[i / b][-shift[i / b]], dp[i]);
  }
  printf("%d", dp[0]);
  return 0;
}
