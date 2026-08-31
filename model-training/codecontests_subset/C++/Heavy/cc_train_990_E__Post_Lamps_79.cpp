#include <bits/stdc++.h>
using namespace std;
template <typename S, typename T>
ostream& operator<<(ostream& out, pair<S, T> const& p) {
  out << '(' << p.first << ", " << p.second << ')';
  return out;
}
template <typename T>
ostream& operator<<(ostream& out, vector<T> const& v) {
  long long l = v.size();
  for (long long i = 0; i < l - 1; i++) out << v[i] << ' ';
  if (l > 0) out << v[l - 1];
  return out;
}
template <typename T>
void trace(const char* name, T&& arg1) {
  cout << name << " : " << arg1 << "\n";
}
template <typename T, typename... Args>
void trace(const char* names, T&& arg1, Args&&... args) {
  const char* comma = strchr(names + 1, ',');
  cout.write(names, comma - names) << " : " << arg1 << " | ";
  trace(comma + 1, args...);
}
long long n, m, k;
long long path[2000000];
long long cost[2000000];
long long near[2000000];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n >> m >> k;
  for (long long i = 0; i < m; i++) {
    long long temp;
    cin >> temp;
    path[temp] = 1;
  }
  for (long long i = 1; i <= k; i++) {
    cin >> cost[i];
  }
  long long max_block = 0;
  long long c = 0;
  for (long long i = 0; i < n; i++) {
    if (path[i] == 1) {
      c++;
      max_block = max(c, max_block);
    } else {
      c = 0;
    }
  }
  if (path[0] == 1 or max_block >= k) {
    cout << -1 << "\n";
    return 0;
  }
  long long t = 0;
  for (long long i = 1; i < n; i++) {
    if (path[i] == 1) {
      near[i] = t;
    } else {
      t = i;
    }
  }
  c = 0;
  long long min_cost = 1000000000000000001;
  for (long long i = max_block + 1; i <= k; i++) {
    for (long long j = 0; j < n; j += i) {
      c += cost[i];
      if (path[j] == 1) {
        j = near[j];
      }
    }
    min_cost = min(min_cost, c);
    c = 0;
  }
  cout << min_cost << "\n";
  return 0;
}
